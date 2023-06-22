package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import responses.Response;

public class Exit extends AbstractCommand {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "завершить программу";
    public Exit(Client client, NetworkClient networkClient) {
        super("exit", client, networkClient);
    }


    @Override
    public Response execute() throws NetworkClientException {
        Response response = client.exit();
        return response;
    }
}