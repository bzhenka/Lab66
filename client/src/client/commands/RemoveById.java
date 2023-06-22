package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import requests.RemoveByIdRequest;
import responses.Response;

public class RemoveById extends AbstractCommand{
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "удалить элемент из коллекции по его id";
    private final int id;
    public RemoveById(Client client, NetworkClient networkClient, int id) {
        super("removeById", client, networkClient);
        this.id = id;
    }

    @Override
    public Response execute() throws NetworkClientException {
        RemoveByIdRequest request = new RemoveByIdRequest(id);
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
