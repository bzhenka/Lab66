package client.commands;
import models.Movie;
import requests.FilterContainsNameRequest;
import requests.Request;
import responses.FilterContainsNameResponse;
import responses.FilterLessThanOscarsCountResponse;
import responses.Response;
import server.Receiver;

import java.io.Serial;
import java.util.ArrayDeque;

public class FilterContainsName extends AbstractCommandResult<ArrayDeque<Movie>> {
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayDeque<Movie> result = null;

    public FilterContainsName(NetworkServer networkServer) {
        super("filterContainsName", networkServer);
    }


    @Override
    public ArrayDeque<Movie> getResult() {
        return result;
    }

    @Override
    public Response execute(Request request) {
        FilterContainsNameRequest filterContainsName = (FilterContainsNameRequest) request;
        result = receiver.filterContainsName(filterContainsName.name);
        FilterContainsNameResponse response;
        return new FilterLessThanOscarsCountResponse(null, result);
    }
}
