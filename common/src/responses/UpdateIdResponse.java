package responses;

import java.io.Serial;

public class UpdateIdResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;

    public UpdateIdResponse(String error) {
        super("Update", error);
    }
}


