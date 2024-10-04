package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable{

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filePath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filePath2;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
