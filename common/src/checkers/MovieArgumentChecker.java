package checkers;

import enums.Color;
import enums.Country;
import enums.MovieGenre;
import enums.MpaaRating;
import models.Coordinates;
import models.Location;
import models.Person;
import server.exceptions.WrongArgumentException;

import java.time.LocalDate;

public class MovieArgumentChecker {
    public static void checkMovie(String name, Coordinates coordinates, LocalDate creationDate, Long oscarsCount, MovieGenre genre,
                                  MpaaRating mpaaRating, Person operator) throws WrongArgumentException {
        checkNotNull(name, "name");
        checkCondition(!name.equals(""), "Имя фильма не должно быть пустой строкой");
        checkNotNull(coordinates, "coordinates");
        checkCoordinates(coordinates.getX(), coordinates.getY());
        checkNotNull(creationDate, "coordinates");
        checkNotNull(oscarsCount, "coordinates");
        checkCondition(oscarsCount >= 0, "Количество оскаров должно быть >= 0");
        checkNotNull(genre, "genre");
        checkNotNull(mpaaRating, "mpaaRating");
        checkNotNull(operator, "operator");
        checkPerson(operator.getName(), operator.getWeight(), operator.getAge(), operator.getEyeColor(),
                operator.getHairColor(), operator.getNationality(), operator.getLocation());
    }

    private static void checkCoordinates(Double x, Float y) throws WrongArgumentException {
        checkNotNull(x, "Локация X");
        checkNotNull(y, "Локация Y");
    }

    private static void checkPerson(String name, Integer weight, Integer age, Color eyeColor, Color hairColor,
                                   Country nationality, Location location) throws WrongArgumentException {
        checkNotNull(name, "name");
        checkCondition(!name.equals(""), "Имя оператора не должно быть пустой строкой");
        checkNotNull(weight, "weight");
        checkCondition(weight > 0, "Вес оператора должен быть > 0");
        checkNotNull(age, "age");
        checkCondition(age > 0, "Возраст оператора должен быть > 0");
        checkNotNull(eyeColor, "eyeColor");
        checkNotNull(hairColor, "hairColor");
        checkNotNull(nationality, "nationality");
        checkNotNull(location, "location");
        checkLocation(location.getX(), location.getY(), location.getZ());
    }

    private static void checkLocation(Double x, Float y, Integer z) throws WrongArgumentException {
        checkNotNull(x, "Локация X");
        checkNotNull(y, "Локация Y");
        checkNotNull(z, "Локация Z");
    }

    private static void checkCondition(boolean condition, String description) throws WrongArgumentException {
        if (!condition) {
            throw new WrongArgumentException(description);
        }
    }

    private static void checkNotNull(Object object, String name) throws WrongArgumentException {
        if (object == null) {
            throw new WrongArgumentException("Поле " + name + " не может быть null");
        }
    }
 }
