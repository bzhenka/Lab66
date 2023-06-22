package server.commands;


import requests.*;
import responses.Response;
import responses.UpdateIdResponse;
import server.Receiver;

import java.io.Serial;


public class UpdateId extends AbstractCommand{

    @Serial
    private static final long serialVersionUID = 1L;
    public UpdateId(Receiver receiver) {
        super("update", receiver);
    }

    @Override
    public Response execute(Request request) {
        UpdateIdRequest uRequest = (UpdateIdRequest) request;
        UpdateIdResponse response;
        receiver.updateId(uRequest.id, uRequest.movieArguments);
        response = new UpdateIdResponse(null);
        return response;
    }
}


