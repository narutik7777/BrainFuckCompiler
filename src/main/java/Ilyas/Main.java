

package Ilyas;
import Ilyas.compile.Compiler;
import Ilyas.vm.Machine;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            throw new IllegalArgumentException("Please transfer a file to execute");

        Runner runner = new Runner(
                new Compiler(),
                new Machine(System.in, System.out, new byte[30000])
        );

        String file = args[0];
        String program = new String(readAllBytes(get(file)));

        runner.run(program);
    }
}