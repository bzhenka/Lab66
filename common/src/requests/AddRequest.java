package requests;

import java.io.Serial;

public class AddRequest extends Request{

    @Serial
    private static final long serialVersionUID = 1L;
    public final Integer id;
    public final String[] movieArguments;

    public AddRequest(Integer id, String[] movieArguments) {
        super("add");
        this.id = id;
        this.movieArguments = movieArguments;
    }
}


