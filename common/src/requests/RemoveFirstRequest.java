package requests;

import java.io.Serial;

public class RemoveFirstRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;
    public RemoveFirstRequest() {
        super("RemoveFirst");
    }
}
