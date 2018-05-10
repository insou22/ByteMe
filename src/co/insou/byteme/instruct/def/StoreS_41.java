package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class StoreS_41 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int register = runtime.stack().pop();
        int data = runtime.stack().pop();

        runtime.register().setData(register, data);
        runtime.stack().push(data);
    }

}
