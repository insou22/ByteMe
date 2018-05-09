package co.insou.byteme.instruct.def;

import co.insou.byteme.impl.DefaultByteMeExecutionResult;
import co.insou.byteme.instruct.ByteMeInstruction;
import co.insou.byteme.vm.ByteMeExecutionResultType;
import co.insou.byteme.vm.ByteMeRuntime;

public class Exit_0 implements ByteMeInstruction {

    @Override
    public void execute(ByteMeRuntime runtime) {
        int size = runtime.stack().size();

        byte[] stack = new byte[size];

        for (int index = 0; index < size; index++) {
            stack[index] = runtime.stack().pop();
        }

        runtime.setResult(new DefaultByteMeExecutionResult(stack, ByteMeExecutionResultType.SUCCESS_EXIT));
        runtime.exit();
    }

}
