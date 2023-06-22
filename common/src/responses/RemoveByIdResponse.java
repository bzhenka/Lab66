package responses;

import java.io.Serial;

public class RemoveByIdResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;

    public RemoveByIdResponse(String error) {
        super("removeById", error);

    }
}
