package utilities;

public class ConsoleLogUtility {
    public static void logTextToConsole(ConsoleTextGeneratorInterface generator) {
        System.out.println(generator.generateText());
    }
}
