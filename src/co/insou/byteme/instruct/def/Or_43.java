package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Or_43 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int a0 = runtime.stack().pop();
        int a1 = runtime.stack().pop();

        runtime.stack().push((a0 == 0 && a1 == 0) ? 0 : 1);
    }

}
