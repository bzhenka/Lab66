package responses;

import java.io.Serial;

public class CountLessThanOperatorResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;
    public final Integer count;


    public CountLessThanOperatorResponse(String error, Integer count) {
        super("CountLessThanOperator", error);
        this.count = count;
    }
}

