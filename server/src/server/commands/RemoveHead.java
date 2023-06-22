package server.commands;
import models.Movie;
import requests.Request;
import responses.RemoveHeadResponse;
import responses.Response;
import server.Receiver;

import java.io.Serial;

public class RemoveHead extends AbstractCommandResult<Movie> {
    @Serial
    private static final long serialVersionUID = 1L;
    private Movie result = null;
    public RemoveHead(Receiver receiver) {
        super("removeHead", receiver);
    }


    @Override
    public Movie getResult() {
        return result;
    }

    @Override
    public Response execute(Request request) {
        result = receiver.removeHead();
        RemoveHeadResponse removeHeadResponse = new RemoveHeadResponse(result, null);
        return removeHeadResponse;
    }
}
