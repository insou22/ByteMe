package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class CmpLt_28 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        byte greater = runtime.stack().pop();
        byte lesser = runtime.stack().pop();

        runtime.stack().push((byte) ((greater > lesser) ? 1 : 0));
    }

}
