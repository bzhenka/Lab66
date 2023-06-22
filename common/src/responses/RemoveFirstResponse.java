package responses;

import java.io.Serial;

public class RemoveFirstResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;
    public RemoveFirstResponse(String error) {
        super("RemoveFirst", error);
    }
}
