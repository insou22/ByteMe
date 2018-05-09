package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class GotoSIf_31 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        if (runtime.stack().pop() != 0) {
            byte index = runtime.stack().pop();
            runtime.setPC(index);
        }
    }

}
