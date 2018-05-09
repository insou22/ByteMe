package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

import java.util.StringJoiner;

public class Print_2b_18 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        byte amount = runtime.next();

        StringJoiner joiner = new StringJoiner(", ");

        for (byte b = 0; b < amount; b++) {
            joiner.add(String.valueOf(runtime.stack().pop()));
        }

        System.out.println(joiner.toString());
    }

}
