package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import requests.ClearRequest;
import responses.Response;

public class Clear extends AbstractCommand{
    public final static int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "очистить коллекцию";
    public Clear(Client client, NetworkClient networkClient) {
        super("clear", client, networkClient);
    }


    @Override
    public Response execute() throws NetworkClientException {
        ClearRequest request = new ClearRequest();
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
