import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        PicocliApp picocli = new PicocliApp();
        new CommandLine(picocli).parse(args);
        picocli.run();    }
}