package client.commands;


import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import requests.AddRequest;
import requests.Request;
import responses.Response;

public class Add extends AbstractCommand{
    public final static int ARGS_LENGTH = 0;
    public static final String DESCRIPTION ="добавить новый элемент в коллекцию";
    private final String[] movieArguments;
    private final Integer id;


    public Add(Client client, NetworkClient networkClient, String[] movieArguments, Integer id) {
        super("add", client, networkClient);
        this.movieArguments = movieArguments;
        this.id = id;
    }


    @Override
    public Response execute() throws NetworkClientException {
        Request request = new AddRequest(id, movieArguments);
        Response response = networkClient.sendRequest(request);
        return response;
    }
}



