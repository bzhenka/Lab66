package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import models.Movie;
import requests.RemoveHeadRequest;
import responses.RemoveHeadResponse;
import responses.Response;

public class RemoveHead extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести первый элемент коллекции и удалить его";
    public RemoveHead(Client client, NetworkClient networkClient) {
        super("removeHead", client, networkClient);
    }


    @Override
    public Response execute() throws NetworkClientException {
        RemoveHeadRequest request = new RemoveHeadRequest();
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
