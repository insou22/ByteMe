package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class CmpLe_29 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int greater = runtime.stack().pop();
        int lesser = runtime.stack().pop();

        runtime.stack().push((greater >= lesser) ? 1 : 0);
    }

}
