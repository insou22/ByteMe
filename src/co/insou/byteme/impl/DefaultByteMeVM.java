package co.insou.byteme.impl;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.instruct.Instructions;
import co.insou.byteme.util.Strings;
import co.insou.byteme.vm.ByteMeExecutionResult;
import co.insou.byteme.vm.ByteMeProgram;
import co.insou.byteme.vm.ByteMeRuntime;
import co.insou.byteme.vm.ByteMeVM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class DefaultByteMeVM implements ByteMeVM {

    private static final Pattern NO_COMMENT = Pattern.compile("(\\s+)?;");
    private static final Pattern COMMENT_START = Pattern.compile("(\\s+)?;.*$");

    private ByteMeRuntime runtime;

    @Override
    public ByteMeProgram compile(List<String> program)
    {
        List<Integer> rawCode = new ArrayList<>();

        StringJoiner joiner = new StringJoiner("\n");

        for (int i = 0; i < program.size(); i++)
        {
            String line = program.get(i);

            if (Strings.isBlank(line) || DefaultByteMeVM.COMMENT_START.matcher(line).matches())
            {
                continue;
            }

            if (line.contains(";"))
            {
                String newValue = DefaultByteMeVM.NO_COMMENT.split(line)[0].trim();
                joiner.add(newValue);
            }
            else
            {
                joiner.add(line.trim());
            }
        }

        String[] codes = joiner.toString().split("[\\n\\r\\s]+");

        int ignore = 0;
        boolean ldc = false;
        boolean ldcOpen = false;
        StringBuilder ldcBuffer = null;

        for (int i = 0; i < codes.length; i++)
        {
            String code = codes[i].trim();

            if (Strings.isBlank(code)) {
                continue;
            }

            if (ldc) {
                if (ldcBuffer.length() > 0) {
                    ldcBuffer.append(" ");
                }
                System.out.println("LDC loaded");
                if (ldcOpen) {
                    System.out.println("Open");
                    if (this.fillLdc(code, ldcBuffer)) {
                        System.out.println("Filled");
                        this.completeLdc(ldcBuffer.toString(), rawCode);
                        ldc = false;
                        ldcOpen = false;
                    }
                } else {
                    System.out.println("Closed");
                    int c = 0;
                    for (; c < code.length(); c++) {
                        if ((code.charAt(c)) == '\"') {
                            System.out.println("Now Open");
                            ldcOpen = true;
                            break;
                        }
                    }

                    if (ldcOpen) {
                        System.out.println("Attempting fill");
                        if (this.fillLdc(code.substring(c + 1), ldcBuffer)) {
                            System.out.println("Filled");
                            this.completeLdc(ldcBuffer.toString(), rawCode);
                            ldc = false;
                            ldcOpen = false;
                        }
                    }
                }
                continue;
            }

            if (ignore > 0) {
                rawCode.add(Integer.parseInt(code));
                ignore--;
                continue;
            }

            if (code.equalsIgnoreCase("ldc")) {
                System.out.println("ldc");
                ldc = true;
                ldcBuffer = new StringBuilder();
                continue;
            }

            int opcode = Instructions.getOpcode(code);

            if (opcode == Instructions.INVALID)
            {
                System.out.println("Error compiling @ line " + i + ": Invalid opcode \"" + code + "\"");
                System.exit(1);
            }

            ByteMeInstruction instruction = Instructions.getInstruction(opcode);

            rawCode.add(opcode);

            ignore += instruction.parameters();
        }

        int[] codeArray = new int[rawCode.size()];

        for (int i = 0; i < rawCode.size(); i++)
        {
            codeArray[i] = rawCode.get(i);
        }

        System.out.println("Completed compilation - size=" + codeArray.length + ":");
        System.out.println(Arrays.toString(codeArray));

        return this.compile(codeArray);
    }

    private boolean fillLdc(String code, StringBuilder builder) {
        boolean literalNext = false;
        for (char c : code.toCharArray()) {
            if (literalNext) {
                builder.append(c);
                System.out.println("Appended literal " + c);
                literalNext = false;
                continue;
            }
            if (c == '\\') {
                literalNext = true;
                continue;
            }
            if (c == '\"') {
                return true;
            }
            builder.append(c);
            System.out.println("Appended natural " + c);
        }
        return false;
    }

    private void completeLdc(String lcd, List<Integer> code) {
        for (int index = lcd.length() - 1; index >= 0; index--) {
            code.add(Instructions.CONST.getOpcode());
            code.add((int) lcd.charAt(index));
        }
    }

    @Override
    public ByteMeProgram compile(int[] code)
    {
        return new DefaultByteMeProgram(code);
    }

    @Override
    public ByteMeExecutionResult execute(ByteMeProgram program)
    {
        this.runtime = new DefaultByteMeRuntime(this, program);
        this.runtime.begin();

        return this.runtime.getResult();
    }

    @Override
    public ByteMeRuntime runtime()
    {
        return this.runtime;
    }

}
