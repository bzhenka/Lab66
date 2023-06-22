package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import responses.Response;

public class ExecuteScript extends AbstractCommand{
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "читать и исполнить скрипт из указанного файла";
    private final String filepath;

    public ExecuteScript(Client client, NetworkClient networkClient, String filepath) {
        super("ExecuteScript", client, networkClient);
        this.filepath = filepath;
    }


    @Override
    public Response execute() throws NetworkClientException {
        Response response = client.executeScript(filepath);
        return response;
    }
}
