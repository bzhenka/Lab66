package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import responses.Response;

public class Help extends AbstractCommand {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести справку по доступным командам";
    public Help(Client client, NetworkClient networkClient) {
        super("help", client, networkClient);
    }

    @Override
    public Response execute() throws NetworkClientException {
        Response response = client.help();
        return response;
    }
}
