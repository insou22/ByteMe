package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Const2_21 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        runtime.stack().push((byte) 2);
    }

}
