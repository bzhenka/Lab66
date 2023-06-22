package server.commands;


import server.Receiver;

public abstract class AbstractCommandResult<T> extends AbstractCommand implements CommandWithResult<T> {
    protected T result;

    public AbstractCommandResult(String name, Receiver receiver) {
        super(name, receiver);
    }
}
