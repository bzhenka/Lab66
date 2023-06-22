package client.commands;
import requests.Request;
import responses.Response;
import server.Receiver;

import java.io.Serial;

public class Exit extends AbstractCommand {

    @Serial
    private static final long serialVersionUID = 1L;
    private final transient NetworkServer server;

    public Exit(NetworkServer networkServer) {
        super("exit", networkServer);
    }


    @Override
    public Response execute(Request request) {
        Response response = server.exit();
        return response;
    }
}