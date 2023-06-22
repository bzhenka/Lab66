package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import models.Movie;
import requests.HeadRequest;
import responses.Response;

public class Head extends AbstractCommand {
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести первый элемент коллекции";

    public Head(Client client, NetworkClient networkClient) {
        super("head", client, networkClient);
    }


    @Override
    public Response execute() throws NetworkClientException {
        HeadRequest request = new HeadRequest();
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
