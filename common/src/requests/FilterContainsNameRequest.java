package requests;

import java.io.Serial;

public class FilterContainsNameRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;
    public final String name;

    public FilterContainsNameRequest(String name) {
        super("FilterContainsName");
        this.name = name;
    }
}
