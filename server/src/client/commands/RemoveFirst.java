package client.commands;

import requests.RemoveFirstRequest;
import requests.Request;
import responses.RemoveFirstResponse;

import responses.Response;

import server.Receiver;

import java.io.Serial;

public class RemoveFirst extends AbstractCommand{
    @Serial
    private static final long serialVersionUID = 1L;
    public RemoveFirst(NetworkServer networkServer) {
        super("removeFirst", networkServer);
    }

    @Override
    public Response execute(Request request) {
        RemoveFirstRequest removefirstRequest = (RemoveFirstRequest) request;
        RemoveFirstResponse response;
        receiver.removeFirst();
        response = new RemoveFirstResponse(null);
        return response;
    }
}
