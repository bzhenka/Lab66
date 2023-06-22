package client.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScriptReader implements Reader {
    private final String filepath;
    private final Scanner readScript;

    public ScriptReader(String filepath) throws FileNotFoundException {
        this.filepath = filepath;
        this.readScript = new Scanner(new FileReader(filepath));
    }

    @Override
    public String readLine() {
        String InputAString = readScript.nextLine();
        return InputAString;
    }

    @Override
    public String readLineWithMessage(String message) {
        return readLine();
    }

    @Override
    public boolean hasNextLine() {
        return readScript.hasNextLine();
    }
}
