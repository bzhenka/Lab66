package server.commands;


import models.Movie;
import requests.FilterLessThanOscarsCountRequest;
import requests.Request;
import responses.FilterLessThanOscarsCountResponse;
import responses.Response;
import server.Receiver;

import java.io.Serial;
import java.util.ArrayDeque;

public class FilterLessThanOscarsCount extends AbstractCommandResult<ArrayDeque<Movie>> {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Long oscarCount;
    public ArrayDeque<Movie> result = null;

    public FilterLessThanOscarsCount(Receiver receiver, Long oscarCount) {
        super("filterLessThanOscarsCount", receiver);
        this.oscarCount=oscarCount;
    }

    @Override
    public ArrayDeque<Movie> getResult() {
        return result;
    }

    @Override
    public Response execute(Request request) {
        FilterLessThanOscarsCountRequest oscarsCountRequest = (FilterLessThanOscarsCountRequest) request;
        FilterLessThanOscarsCountResponse response;
        result = receiver.filterLessThanOscarsCount(oscarsCountRequest.oscarCount);
        return new FilterLessThanOscarsCountResponse(null, result);
    }
}
