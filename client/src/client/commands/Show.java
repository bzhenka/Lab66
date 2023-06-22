package client.commands;

import client.Client;
import client.exceptions.NetworkClientException;
import client.network.NetworkClient;
import models.Movie;
import requests.ShowRequest;
import responses.Response;

import java.util.ArrayDeque;

public class Show extends AbstractCommand{
    public static final int ARGS_LENGTH = 0;
    public static final String DESCRIPTION = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    public Show(Client client, NetworkClient networkClient) {
            super("show", client, networkClient);
        }
        @Override
        public Response execute() throws NetworkClientException {
            ShowRequest request = new ShowRequest();
            Response response = networkClient.sendRequest(request);
            return response;
}}
