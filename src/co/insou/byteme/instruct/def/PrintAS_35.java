package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

public class PrintAS_35 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int len = runtime.stack().pop();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            builder.append((char) runtime.stack().pop());
        }

        System.out.println(builder.toString());
    }

}
