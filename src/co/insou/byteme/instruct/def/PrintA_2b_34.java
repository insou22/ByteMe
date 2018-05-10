package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class PrintA_2b_34 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int len = runtime.next();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            builder.append((char) runtime.stack().pop());
        }

        System.out.println(builder.toString());
    }

}
