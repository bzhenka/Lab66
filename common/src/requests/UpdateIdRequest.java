package requests;

import java.io.Serial;

public class UpdateIdRequest extends Request{
    @Serial
    private static final long serialVersionUID = 1L;
    public final Integer id;
    public final String[] movieArguments;

    public UpdateIdRequest(Integer id, String[] movieArguments) {
        super("UpdateIdRequest");
        this.id = id;
        this.movieArguments = movieArguments;
    }
}
