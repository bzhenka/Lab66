package client.commands;


import server.Receiver;

public abstract class AbstractCommandResult<T> extends AbstractCommand implements CommandWithResult<T> {
    protected T result;

    public AbstractCommandResult(String name, NetworkServer networkServer) {
        super(name, networkServer);
    }
}
