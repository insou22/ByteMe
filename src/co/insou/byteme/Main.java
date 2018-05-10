package co.insou.byteme;

import co.insou.byteme.vm.ByteMeExecutionResult;
import co.insou.byteme.vm.ByteMeProgram;
import co.insou.byteme.vm.ByteMeVM;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public final class Main {

    public static void main(String[] args) throws Exception
    {
        if (args.length == 0)
        {
            System.out.println("Usage: java -jar ByteMe.jar <file.bm>");
        }

        ByteMeVM vm = ByteMe.defaultVM();

        ByteMeProgram program = vm.compile(
                Files.readAllLines(Paths.get(args[0]))
        );

        ByteMeExecutionResult result = vm.execute(program);

        System.out.println("Result: " + result.resultType());
        System.out.println("Data: " + Arrays.toString(result.data()));
    }

}
