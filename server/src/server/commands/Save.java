package server.commands;
import requests.Request;
import responses.Response;
import server.Receiver;

public class Save extends AbstractCommand{
    public Save(Receiver receiver) {
        super("save", receiver);
    }


    @Override
    public Response execute(Request request) {
        return null;
    }
}

