package client.commands;


import networkServer.NetworkServer;
import requests.Request;
import responses.*;
import server.Receiver;

import java.io.Serial;

public class Clear extends AbstractCommand{
    @Serial
    private static final long serialVersionUID = 1L;

    public Clear(NetworkServer networkServer) {
        super("clear", networkServer);
    }



    @Override
    public ClearResponse execute(Request request) {
        receiver.clear();
        return new ClearResponse(null);
    }
}
