package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Sum_11 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        runtime.stack().push(runtime.stack().pop() + runtime.stack().pop());
    }

}
