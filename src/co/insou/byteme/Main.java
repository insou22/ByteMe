package co.insou.byteme;

import co.insou.byteme.vm.ByteMeExecutionResult;
import co.insou.byteme.vm.ByteMeProgram;
import co.insou.byteme.vm.ByteMeVM;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Main {

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Path path;
            System.out.print("Demo example? ");

            boolean demo = scanner.nextBoolean();
            scanner.nextLine();

            if (demo) {
                System.out.println("Example options: ");
                for (File example : Objects.requireNonNull(Paths.get("examples").toFile().listFiles())) {
                    System.out.println("  " + example.getName().substring(0, example.getName().length() - 3));
                }
                System.out.print("Example name? ");
                path = Paths.get("examples/" + scanner.nextLine() + ".bm");
            } else {
                System.out.println("Path: ");
                path = Paths.get(scanner.nextLine());
            }

            Main.printDoubleLine();

            ByteMeVM vm = ByteMe.defaultVM();

            ByteMeProgram program = vm.compile(
                    Files.readAllLines(path)
            );

            Main.printPaddedBorder();

            ByteMeExecutionResult result = vm.execute(program);

            Main.printPaddedBorder();
            System.out.println("Result: " + result.resultType());
            System.out.println("Data: " + Arrays.toString(result.data()));
            Main.printDoubleLine();
        }
    }

    private static void printPaddedBorder() {
        Main.printBlankLine();
        Main.printBorder();
        Main.printBlankLine();
    }

    private static void printBorder() {
        System.out.println(IntStream.range(0, 50).mapToObj(i -> "=").collect(Collectors.joining()));
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static void printDoubleLine() {
        System.out.println("\r\n");
    }

}
