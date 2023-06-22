package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import models.Movie;
import requests.FilterLessThanOscarsCountRequest;
import responses.FilterLessThanOscarsCountResponse;
import responses.Response;

import java.util.ArrayDeque;

public class FilterLessThanOscarsCount extends AbstractCommand {
    public static final int ARGS_LENGTH = 1;
    public static final String DESCRIPTION = "вывести элементы, значение поля oscarsCount которых меньше заданного";
    private final Long oscarCount;
    public FilterLessThanOscarsCount(Client client, NetworkClient networkClient, Long oscarCount) {
        super("filterLessThanOscarsCount", client, networkClient);
        this.oscarCount=oscarCount;
    }

    @Override
    public Response execute() throws NetworkClientException {
        FilterLessThanOscarsCountRequest request = new FilterLessThanOscarsCountRequest(oscarCount);
        Response response = networkClient.sendRequest(request);
        return response;
    }
}
