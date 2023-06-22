package responses;

import models.Movie;

import java.io.Serial;

public class HeadResponse extends Response{
    @Serial
    private static final long serialVersionUID = 1L;
    public final Movie movies;
    public HeadResponse(String error, Movie movies) {
        super("Head", error);
        this.movies = movies;
    }
}
