package server.commands;

import server.Receiver;

import java.io.Serializable;

public abstract class AbstractCommand implements Command, Serializable {
    protected final Receiver receiver;
    protected final String name;

    public AbstractCommand(String name, Receiver receiver) {
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
