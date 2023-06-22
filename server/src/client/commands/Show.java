package client.commands;
import models.Movie;
import requests.Request;
import responses.Response;
import responses.ShowResponse;
import server.Receiver;

import java.io.Serial;
import java.util.ArrayDeque;

public class Show extends AbstractCommandResult<ArrayDeque<Movie>> {
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayDeque<Movie> result = null;
    public Show(NetworkServer networkServer) {
        super("show", networkServer);
    }




    @Override
    public Response execute(Request request) {
        result = receiver.show();
        ShowResponse showResponse = new ShowResponse(result, null);
        return showResponse;
    }
    @Override
    public ArrayDeque<Movie> getResult() {
        return result;
    }
}
