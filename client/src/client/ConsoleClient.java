package client;

import client.form.*;
import client.network.NetworkClient;
import enums.*;
import client.commands.*;
import client.exceptions.*;
import client.reader.*;
import responses.HeadResponse;
import responses.RemoveByIdResponse;
import responses.Response;
import server.exceptions.*;
import models.*;

import java.io.IOException;
import java.util.*;

public class ConsoleClient implements Client {
    private Reader reader = new ConsoleReader();
    private boolean stopWorker = false;
    private Set<String> paths = new HashSet<>();
    NetworkClient networkClient;

    public ConsoleClient() {
        System.out.println("������ ������� �������");
    }

    public void worker() {
        while (!stopWorker) {
            try {
                String line = reader.readLine().trim();
                executeCommand(line);

            } catch (WrongCommandException | WrongArgumentsLengthException | IOException | WrongArgumentException |
                     InputInterruptionException | MovieNotFoundException | NetworkClientException e) {
                System.out.println("�������� ������ " + e.getMessage());
            }
        }
    }
    private void executeCommand(String line) throws WrongCommandException, WrongArgumentsLengthException, IOException,
            WrongArgumentException, InputInterruptionException, MovieNotFoundException, NetworkClientException {
        String[] splitLine = line.split(" ");
        String commandName = splitLine[0].toLowerCase();
        String[] arguments = Arrays.copyOfRange(splitLine, 1, splitLine.length);
        switch (commandName) {
                case "exit" -> {
                    if (arguments.length != Exit.ARGS_LENGTH) {
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Exit(this, networkClient);
                    command.execute();
                }
                case "clear" -> {
                    if (arguments.length != Clear.ARGS_LENGTH) {
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Clear(this, networkClient);
                    command.execute();
                    System.out.println("��������� �������");
                }
                case "add" -> {
                    if (arguments.length != Add.ARGS_LENGTH) {
                        throw new WrongArgumentsLengthException();
                    }

                    String[] movieArgs = new MovieForm(reader).getData();
                    Command command = new Add(this, networkClient, movieArgs, id);
                    command.execute();
                    System.out.println("����� ��������");
                }
                case "save" -> {
                    if (arguments.length != Save.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Save(this, networkClient);
                    command.execute();
                    System.out.println("����� ��������");
                }
                case "show" -> {
                    if (arguments.length != Show.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Show(this, networkClient);
                    command.execute();
                    ArrayDeque<Movie> movies = command.getResult();
                    if (movies.size() == 0){
                        System.out.println("� ��������� ��� �������");
                    }
                    FilmConsole.printMovie(movies);
                }
                case "updateid" -> {
                    if (arguments.length != UpdateId.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Integer id;
                    try {
                        id = Integer.parseInt(arguments[0]);
                    } catch (NumberFormatException e) {
                        throw new WrongCommandException(", id ������ �� �����");
                    }

                    String[] movieArgs = new MovieForm(reader).getData();
                    Command command = new UpdateId(this, networkClient, id, movieArgs);
                    command.execute();
                    System.out.println("����� � id " + id + " ��������");
                }
                case "head" -> {
                    if (arguments.length != Head.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Head command = new Head(this, networkClient);
                    HeadResponse response = (HeadResponse) command.execute();
                    FilmConsole.oneMovie(response.movies);
                }
                case "removebyid" -> {
                    if (arguments.length != RemoveById.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    int id = Integer.parseInt(arguments[0]);
                    Command command = new RemoveById(this, networkClient, id);
                    RemoveByIdResponse response = (RemoveByIdResponse) command.execute();
                    boolean result = command.getResult();
                    if (result) {
                        System.out.println("����� � id " + id + " ������");
                    } else {
                        System.out.println("����� � id " + id + " �� ������");
                    }
                }
                case "removefirst" -> {
                    if (arguments.length != RemoveFirst.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new RemoveFirst(this, networkClient);
                    command.execute();
                    System.out.println(ConsoleColor.BLUE.getCode() + "������ ����� ������");
                }
                case "removehead" -> {
                    if (arguments.length != RemoveHead.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    CommandWithResult<Movie> command = new RemoveHead(this, networkClient);
                    command.execute();
                    Movie firstMovie = command.getResult();
                    FilmConsole.oneMovie(firstMovie);
                    System.out.println(ConsoleColor.BLUE.getCode() + "����� ������");
                }
                case "countlessthanoperator" -> {
                    if (arguments.length != CountLessThanOperator.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    String[] operatorArgs = new OperatorForm(reader).getData();
                    CommandWithResult<Integer> command = new CountLessThanOperator(this, networkClient, operatorArgs, operatorArgs);
                    command.execute();
                    int count = command.getResult();
                    System.out.println(ConsoleColor.BLUE.getCode() + "���������� �������, �������� ���� operator ������� ������ ���������: " + count);
                }
                case "filtercontainsname" -> {
                    if (arguments.length != FilterContainsName.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    String name = arguments[0];
                    CommandWithResult<ArrayList<Movie>> command = new FilterContainsName(this, networkClient, name);
                    command.execute();
                    ArrayList<Movie> movies = command.getResult();
                    if (movies.size() == 0){
                        System.out.println(ConsoleColor.PURPLE.getCode() + "��� �������, ������� �������� �������� ���������");
                    }
                    FilmConsole.printMovie(movies);
                }
                case "filterlessthanoscarscount" -> {
                    if (arguments.length != FilterLessThanOscarsCount.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Long oscars;
                    try {
                        oscars = Long.valueOf(arguments[0]);
                    } catch (NumberFormatException e) {
                        throw new WrongCommandException(", ���������� ������� ������� �� �����");
                    }
                    CommandWithResult<ArrayDeque<Movie>> command = new FilterLessThanOscarsCount(this, networkClient, oscars);
                    command.execute();
                    ArrayDeque<Movie> movies = command.getResult();
                    if (movies.size() == 0){
                        System.out.println(ConsoleColor.PURPLE.getCode() + "��� ������� ������ ��������� ���������� �������");
                    }
                    FilmConsole.printMovie(movies);
                }
                case "info" -> {
                    if (arguments.length != Info.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    CommandWithResult<String[]> command = new Info(this, networkClient);
                    command.execute();
                    String[] result = command.getResult();
                    System.out.println(ConsoleColor.BLUE.getCode() + "��� ���������: " + result[0] + ", ������ ���������: " + result[1] + ", ���� �������������: " + result[2]);
                }
                case "help" -> {
                    if (arguments.length != Help.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    Command command = new Help(this, networkClient);
                    command.execute();
                }
                case "executescript" -> {
                    if (arguments.length != ExecuteScript.ARGS_LENGTH){
                        throw new WrongArgumentsLengthException();
                    }
                    String filepath = arguments[0];
                    Command command = new ExecuteScript(this, networkClient, filepath);
                    command.execute();
                }
                default -> {
                    throw new WrongCommandException(ConsoleColor.PURPLE.getCode() + "�������� ������� " + commandName);
                }

            }
    }

    @Override
    public void exit() {
        stopWorker = true;
    }

    @Override
    public void help() {
        System.out.println("Help: " + Help.DESCRIPTION);
        System.out.println("Info: " + Info.DESCRIPTION);
        System.out.println("Show: " + Show.DESCRIPTION);
        System.out.println("Add: " + Add.DESCRIPTION);
        System.out.println("UpdateId: " + UpdateId.DESCRIPTION);
        System.out.println("RemoveById: " + RemoveById.DESCRIPTION);
        System.out.println("Clear: " + Clear.DESCRIPTION);
        System.out.println("Save: " + Save.DESCRIPTION);
        System.out.println("ExecuteScript: " + ExecuteScript.DESCRIPTION);
        System.out.println("Exit: " + Exit.DESCRIPTION);
        System.out.println("RemoveFirst: " + RemoveFirst.DESCRIPTION);
        System.out.println("Head: " + Head.DESCRIPTION);
        System.out.println("RemoveHead: " + RemoveHead.DESCRIPTION);
        System.out.println("CountLessThanOperator: " + CountLessThanOperator.DESCRIPTION);
        System.out.println("FilterContainsName: " + FilterContainsName.DESCRIPTION);
        System.out.println("FilterLessThanOscarsCount: " + FilterLessThanOscarsCount.DESCRIPTION);
    }

    @Override
    public void executeScript(String filepath) {
        try {
            if (paths.contains(filepath)) {
                System.out.println("��������");
                return;
            }
            paths.add(filepath);

            reader = new ScriptReader(filepath);
            String line;
            while (reader.hasNextLine()) {
                line = reader.readLine();
                if (Objects.equals(line, "executeScript")){
                    System.out.println("���� �������� ������� executeScript, ��� �������� � ��������, ������� �������");
                    break;
                }
                executeCommand(line);
            }

            reader = new ConsoleReader();
            paths.remove(filepath);

        } catch (IOException | WrongCommandException | WrongArgumentsLengthException | WrongArgumentException |
                 InputInterruptionException | MovieNotFoundException e){
            System.err.println(ConsoleColor.PURPLE.getCode() + "������ ������ �����: " + e.getMessage());
        }

    }
}
