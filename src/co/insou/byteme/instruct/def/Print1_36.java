package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Print1_36 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        System.out.println(runtime.stack().pop());
    }

}
