package client.form;

import client.reader.Reader;
import client.exceptions.InputInterruptionException;
import server.exceptions.WrongArgumentException;

public abstract class Form {
    protected final Reader reader;

    public Form(Reader reader) {
        this.reader = reader;
    }

    abstract String[] getData() throws WrongArgumentException, InputInterruptionException;
}
