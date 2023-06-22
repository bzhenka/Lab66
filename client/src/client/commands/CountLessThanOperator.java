package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import requests.CountLessThanOperatorRequest;
import responses.Response;

public class CountLessThanOperator extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести количество элементов, значение поля operator которых меньше заданного";
    private final String[] operatorArgs;

    public CountLessThanOperator(Client client, NetworkClient networkClient, String[] operatorArgs) {
        super("CountLessThanOperator", client, networkClient);
        this.operatorArgs = operatorArgs;
    }

    @Override
    public Response execute() throws NetworkClientException {
        CountLessThanOperatorRequest request = new CountLessThanOperatorRequest(operatorArgs);
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
