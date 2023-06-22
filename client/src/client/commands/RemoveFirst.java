package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import requests.RemoveFirstRequest;
import responses.Response;

public class RemoveFirst extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "удалить первый элемент из коллекции";
    public RemoveFirst(Client client, NetworkClient networkClient) {
        super("removeFirst", client, networkClient);
    }

    @Override
    public Response execute() throws NetworkClientException {
        RemoveFirstRequest request = new RemoveFirstRequest();
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
