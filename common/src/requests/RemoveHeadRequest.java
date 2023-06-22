package requests;

import java.io.Serial;

public class RemoveHeadRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;

    public RemoveHeadRequest() {
        super("RemoveHeadRequest");
    }
}
