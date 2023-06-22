package server.commands;
import requests.Request;
import responses.Response;
import server.Receiver;
import server.networkServer.NetworkServer;

import java.io.Serial;

public class Exit extends AbstractCommand {

    @Serial
    private static final long serialVersionUID = 1L;
    private final transient NetworkServer server;
    // todo add server app

    public Exit(Receiver receiver, NetworkServer server) {
        super("exit", receiver);
        this.server = server;
    }


    @Override
    public Response execute(Request request) {
        Response response = server.exit();
        return response;
    }
}