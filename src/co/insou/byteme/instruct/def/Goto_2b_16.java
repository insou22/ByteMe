package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Goto_2b_16 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        byte index = runtime.next();
        runtime.setPC(index);
    }

}
