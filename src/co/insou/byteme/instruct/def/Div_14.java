package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Div_14 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        byte div = runtime.stack().pop();
        byte base = runtime.stack().pop();

        runtime.stack().push((byte) (base / div));
    }

}
