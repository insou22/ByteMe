package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Store3_4 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        runtime.register().setData(3, runtime.stack().pop());
    }

}
