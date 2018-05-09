package co.insou.byteme.vm;

import co.insou.byteme.instruct.ByteMeInstruction;

public interface ByteMeRuntime {

    ByteMeVM vm();

    ByteMeProgram program();

    int getPC();

    void setPC(int pc);

    ByteMeInstruction currentInstruction();

    byte next();

    ByteMeRegister register();

    ByteMeStack stack();

    ByteMeExecutionResult getResult();

    void setResult(ByteMeExecutionResult result);

    void exit();

    void begin();

}
