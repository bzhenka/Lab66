package requests;

import java.io.Serial;

public class FilterLessThanOscarsCountRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;
    public final Long oscarCount;

    public FilterLessThanOscarsCountRequest(Long oscarCount) {
        super("FilterLessThanOscarsCountRequest");
        this.oscarCount = oscarCount;
    }
}
