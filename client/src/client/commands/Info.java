package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import requests.InfoRequest;
import responses.Response;

public class Info extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести в стандартный поток вывода информацию о коллекции";
    public Info(Client client, NetworkClient networkClient) {
        super("info", client, networkClient);
    }

    @Override
    public Response execute() throws NetworkClientException {
        InfoRequest request = new InfoRequest();
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
