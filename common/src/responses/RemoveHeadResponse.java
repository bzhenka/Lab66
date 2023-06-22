package responses;

import models.Movie;

import java.io.Serial;

public class RemoveHeadResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;
    public final Movie movies;
    public RemoveHeadResponse(Movie movies, String error) {
        super("RemoveHeadRequest", error);
        this.movies = movies;
    }
}
