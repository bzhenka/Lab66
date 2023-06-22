package requests;

import java.io.Serial;

public class CountLessThanOperatorRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;
    public final String[] operatorArgs;
    public CountLessThanOperatorRequest(String[] operatorArgs) {
        super("CountLessThanOperator");
        this.operatorArgs = operatorArgs;
    }
}
