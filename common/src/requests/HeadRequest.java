package requests;

import java.io.Serial;

public class HeadRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;

    public HeadRequest() {
        super("Head");
    }
}
