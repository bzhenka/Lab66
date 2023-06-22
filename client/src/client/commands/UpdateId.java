package client.commands;

import client.Client;
import client.exceptions.MovieNotFoundException;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import requests.UpdateIdRequest;
import responses.Response;

public class UpdateId extends AbstractCommand{
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "обновить значение элемента коллекции, id которого равен заданному";
    int id;
    String[] movieArguments;
    public UpdateId(Client client, NetworkClient networkClient, int id, String[] movieArguments) {
        super("updateId", client, networkClient);
        this.id = id;
        this.movieArguments = movieArguments;
    }

    @Override
    public Response execute() throws NetworkClientException {
        UpdateIdRequest request = new UpdateIdRequest(id, movieArguments);
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
