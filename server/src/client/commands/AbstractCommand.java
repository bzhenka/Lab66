package client.commands;

import networkServer.NetworkServer;
import server.Receiver;

import java.io.Serializable;

public abstract class AbstractCommand implements Command, Serializable {
    final String name;
    final transient NetworkServer networkServer;

    public AbstractCommand(String name, NetworkServer networkServer) {
        this.name = name;
        this.receiver = receiver;
    }
    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }


}
