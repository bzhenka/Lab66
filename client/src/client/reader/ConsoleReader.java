package client.reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner readConsole = new Scanner(System.in);
    @Override
    public String readLine() {
        System.out.print("~ ");
        String InputAString = readConsole.nextLine();
        return InputAString;
    }

    @Override
    public String readLineWithMessage(String message) {
        System.out.print(" > ");
        System.out.print(message);
        String InputAString = readConsole.nextLine();
        return InputAString;
    }

    @Override
    public boolean hasNextLine() {
        return readConsole.hasNextLine();
    }
}
