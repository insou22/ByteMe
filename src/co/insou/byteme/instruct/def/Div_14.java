package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Div_14 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int div = runtime.stack().pop();
        int base = runtime.stack().pop();

        runtime.stack().push(base / div);
    }

}
