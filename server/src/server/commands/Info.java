package server.commands;
import requests.Request;
import responses.InfoResponse;
import responses.Response;
import server.Receiver;

import java.io.Serial;

public class Info extends AbstractCommandResult<String[]>{
    @Serial
    private static final long serialVersionUID = 1L;
    private String[] result = null;
    public Info(Receiver receiver) {
        super("info", receiver);
    }



    @Override
    public String[] getResult() {
        return result;
    }

    @Override
    public Response execute(Request request) {
        result = receiver.info();
        return new InfoResponse(null, result);
    }
}
