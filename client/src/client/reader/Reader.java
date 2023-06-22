package client.reader;

public interface Reader {
    String readLine();
    String readLineWithMessage(String message);
    boolean hasNextLine();
}
