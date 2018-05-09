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
        List<Byte> bytes = new ArrayList<>();

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

        for (int i = 0; i < codes.length; i++)
        {
            String code = codes[i].trim();

            if (Strings.isBlank(code)) {
                continue;
            }

            if (ignore > 0) {
                bytes.add(Byte.parseByte(code));
                ignore--;
                continue;
            }

            byte opcode = Instructions.getOpcode(code);

            if (opcode == Instructions.INVALID)
            {
                System.out.println("Error compiling @ line " + i + ": Invalid opcode \"" + code + "\"");
                System.exit(1);
            }

            ByteMeInstruction instruction = Instructions.getInstruction(opcode);

            bytes.add(opcode);

            ignore += instruction.parameters();
        }

        byte[] bytecode = new byte[bytes.size()];

        for (int i = 0; i < bytes.size(); i++)
        {
            bytecode[i] = bytes.get(i);
        }

        System.out.println("Completed compilation - " + bytecode.length + " bytes:");
        System.out.println(Arrays.toString(bytecode));

        return this.compile(bytecode);
    }

    @Override
    public ByteMeProgram compile(byte[] code)
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
