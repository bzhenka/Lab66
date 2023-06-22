package responses;

import java.io.Serial;

public class AddResponse extends Response {

    @Serial
    private static final long serialVersionUID = 1L;


    public AddResponse(String error) {
        super("Add", error);
    }
}


