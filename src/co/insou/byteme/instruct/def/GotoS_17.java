package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class GotoS_17 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int index = runtime.stack().pop();
        runtime.setPC(index);
    }

}
