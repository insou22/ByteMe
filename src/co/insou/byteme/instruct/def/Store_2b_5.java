package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Store_2b_5 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        runtime.register().setData(runtime.next(), runtime.stack().pop());
    }

}
