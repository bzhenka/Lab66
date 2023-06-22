package client.commands;
import models.Movie;
import requests.HeadRequest;
import requests.Request;
import responses.HeadResponse;
import responses.Response;
import server.Receiver;

import java.io.Serial;

public class Head extends AbstractCommandResult<Movie> {
    @Serial
    private static final long serialVersionUID = 1L;
    public final Movie movie = result;
    public Head(NetworkServer networkServer) {
        super("head", networkServer);
    }

    @Override
    public Movie getResult() {
        return result;
    }

    @Override
    public Response execute(Request request) {
        HeadRequest headRequest = (HeadRequest) request;
        result = receiver.head();
        HeadResponse response;
        return new HeadResponse(null, result);
    }
}
