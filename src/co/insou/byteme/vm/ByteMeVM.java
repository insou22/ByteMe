package co.insou.byteme.vm;

import java.util.List;

public interface ByteMeVM {

    ByteMeProgram compile(List<String> lines);

    ByteMeProgram compile(int[] code);

    ByteMeExecutionResult execute(ByteMeProgram program);

    ByteMeRuntime runtime();

}
