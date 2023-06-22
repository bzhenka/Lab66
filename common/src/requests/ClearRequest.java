package requests;

import java.io.Serial;

public class ClearRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;
    public ClearRequest() {
        super("clear");
    }
}
