package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class CmpGt_26 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        byte lesser = runtime.stack().pop();
        byte greater = runtime.stack().pop();

        runtime.stack().push((byte) ((greater > lesser) ? 1 : 0));
    }

}
