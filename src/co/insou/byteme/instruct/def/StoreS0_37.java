package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class StoreS0_37 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int data = runtime.stack().pop();

        runtime.register().setData(0, data);
        runtime.stack().push(data);
    }

}
