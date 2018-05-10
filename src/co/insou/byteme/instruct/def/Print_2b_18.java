package co.insou.byteme.instruct.def;

import co.insou.byteme.instruct.ByteMe2BInstruction;
import co.insou.byteme.vm.ByteMeRuntime;

import java.util.StringJoiner;

public class Print_2b_18 implements ByteMe2BInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int amount = runtime.next();

        StringJoiner joiner = new StringJoiner(", ");

        for (int i = 0; i < amount; i++) {
            joiner.add(String.valueOf(runtime.stack().pop()));
        }

        System.out.println(joiner.toString());
    }

}
