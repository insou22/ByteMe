package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Const3_22 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        runtime.stack().push(3);
    }

}
