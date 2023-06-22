package requests;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    final public String name;

    public Request(String name) {
        this.name = name;
    }
}
