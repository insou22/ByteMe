package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class CmpGt_26 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int lesser = runtime.stack().pop();
        int greater = runtime.stack().pop();

        runtime.stack().push((greater > lesser) ? 1 : 0);
    }

}
