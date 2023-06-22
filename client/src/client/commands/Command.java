package client.commands;


import client.exceptions.NetworkClientException;
import responses.Response;

public interface Command {
    Response execute() throws NetworkClientException;
}
