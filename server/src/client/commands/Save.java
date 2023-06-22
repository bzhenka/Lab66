package client.commands;
import requests.Request;
import responses.Response;
import server.Receiver;

public class Save extends AbstractCommand{
    public Save(NetworkServer networkServer) {
        super("save", networkServer);
    }


    @Override
    public Response execute(Request request) {
        return null;
    }
}

