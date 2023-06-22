package client.commands;
import requests.RemoveByIdRequest;
import requests.Request;
import responses.RemoveByIdResponse;
import responses.Response;
import server.Receiver;

import java.io.Serial;

public class RemoveById extends AbstractCommandResult<Boolean>{
    @Serial
    private static final long serialVersionUID = 1L;
    private final int id;
    public RemoveById(NetworkServer networkServer, int id) {
        super("removeById", networkServer);
        this.id = id;
    }

    @Override
    public Response execute(Request request) {
        RemoveByIdRequest remidRequest = (RemoveByIdRequest) request;
        RemoveByIdResponse response;
        receiver.removeById(remidRequest.id);
        response = new RemoveByIdResponse(null);
        return response;
    }

    @Override
    public Boolean getResult() {
        return result;
    }


}
