package co.insou.byteme.impl;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.instruct.Instructions;
import co.insou.byteme.vm.*;

public class DefaultByteMeRuntime implements ByteMeRuntime {

    private final ByteMeRegister cache = new DefaultByteMeRegister();
    private final ByteMeStack stack = new DefaultByteMeStack();
    private final ByteMeVM vm;
    private final ByteMeProgram program;

    private int pc = 0;
    private int totalCount = 0;
    private boolean running = true;
    private ByteMeInstruction currentInstruction;
    private ByteMeExecutionResult result;

    public DefaultByteMeRuntime(ByteMeVM vm, ByteMeProgram program)
    {
        this.vm = vm;
        this.program = program;
    }

    @Override
    public ByteMeVM vm()
    {
        return this.vm;
    }

    @Override
    public ByteMeProgram program()
    {
        return this.program;
    }

    @Override
    public int getPC()
    {
        return this.pc;
    }

    @Override
    public void setPC(int pc)
    {
        this.pc = pc;
    }

    @Override
    public ByteMeInstruction currentInstruction()
    {
        return this.currentInstruction;
    }

    @Override
    public int next() {
        int next = this.program.code()[pc];
        this.totalCount++;
        this.pc++;

        return next;
    }

    @Override
    public ByteMeRegister register()
    {
        return this.cache;
    }

    @Override
    public ByteMeStack stack() {
        return this.stack;
    }

    @Override
    public ByteMeExecutionResult getResult()
    {
        return this.result;
    }

    @Override
    public void setResult(ByteMeExecutionResult result)
    {
        this.result = result;
    }

    @Override
    public void exit()
    {
        this.running = false;
    }

    @Override
    public void begin()
    {
        while (this.pc < this.program.len() && this.running)
        {
            int opcode = this.next();

            ByteMeInstruction instruction = Instructions.getInstruction(opcode);

            this.attemptExecution(instruction);
        }

        if (this.running)
        {
            this.result = new DefaultByteMeExecutionResult(new int[0], ByteMeExecutionResultType.SUCCESS_EOF);
        }
    }

    private void attemptExecution(ByteMeInstruction instruction) {
        try
        {
            instruction.execute(this);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            this.result = new DefaultByteMeExecutionResult(new int[0], ByteMeExecutionResultType.FAILED);
            this.exit();
        }
    }

}
