package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Xor_44 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int a0 = runtime.stack().pop();
        int a1 = runtime.stack().pop();

        if (a0 == a1 || (a0 != 0 && a1 != 0)) {
            runtime.stack().push(0);
        } else {
            runtime.stack().push(1);
        }
    }

}
