package requests;

import java.io.Serial;

public class RemoveByIdRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;
    public final int id;
    public RemoveByIdRequest(int id) {
        super("removeById");
        this.id = id;
    }
}
