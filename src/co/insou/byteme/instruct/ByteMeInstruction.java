package co.insou.byteme.instruct;

import co.insou.byteme.vm.ByteMeRuntime;

@FunctionalInterface
public interface ByteMeInstruction {

    void execute(ByteMeRuntime runtime);

    default int parameters() {
        return 0;
    }

}
