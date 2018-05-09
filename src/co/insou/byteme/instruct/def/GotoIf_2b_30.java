package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class GotoIf_2b_30 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        if (runtime.stack().pop() != 0) {
            byte index = runtime.next();
            runtime.setPC(index);
        }
    }

}
