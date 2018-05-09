package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class Load_2b_10 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        runtime.stack().push(runtime.register().getData(runtime.next()));
    }

}
