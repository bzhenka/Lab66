package client.form;

import enums.ConsoleColor;
import enums.MovieGenre;
import enums.MpaaRating;
import client.reader.Reader;
import client.exceptions.InputInterruptionException;
import server.exceptions.WrongArgumentException;

import java.util.Objects;

public class MovieForm extends Form{
    public MovieForm(Reader reader) {
        super(reader);
    }

    @Override
    public String[] getData() throws WrongArgumentException, InputInterruptionException {
        String[] movieArgs = new String[15];
        String name = null;
        while (name == null){
            name = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите название фильма: ");

            if (name.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
            }

            if (Objects.equals(name.trim(), "")){
                name = null;
                System.out.println(ConsoleColor.RED.getCode() + "Имя не может быть пустым");
            }
        }
        movieArgs[0] = name;
        Double x = null;

        while (x == null) {

            try {
                String xString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"Введите координату x (широта) : ");
                if (xString.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");}
//                if (xString.equals("?")){
//                    movieArgs[1] = "?";
//                    break;
//                }
                x = Double.parseDouble(xString);
                if (x < 0 || x > 90){
                    System.out.println(ConsoleColor.RED.getCode() + "Координата х не может выходить за рамки [0; 90]");
                    x = null;
                }

            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введена координата х");

            }
        }
        movieArgs[1] = String.valueOf(x);
//        if (!Objects.equals(movieArgs[1], "?")){
//            movieArgs[1] = String.valueOf(x);
//        }

        Float y = null;
        while (y == null){
            String yString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"Введите координату y (долгота) : ");
            if (yString.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");}

            try {
                y = Float.valueOf(yString);
                if (y < 0 || y > 180){
                    System.out.println(ConsoleColor.RED.getCode() + "Координата y не может выходить за рамки [0; 180]");
                    y = null;}

            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введена координата y");
            }
        }
        movieArgs[2] = String.valueOf(y);


        Integer oscar = null;
        while (oscar == null){
            String oscarS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"Введите количество оскаров: ");
            if (oscarS.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");}
            try {
                oscar = Integer.valueOf(oscarS);
                if (oscar < 0){
                    System.out.println(ConsoleColor.RED.getCode() + "Число не должно быть отрицательным");
                    oscar = null;
                }
            }catch (NumberFormatException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введено количество оскаров");
            }
        }
        movieArgs[3] = String.valueOf(oscar);
        MovieGenre genre = null;
        while (genre == null){
                String genreS= reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"Введите жанр фильма: ");
            if (genreS.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");}
            try {
                genreS = genreS.toUpperCase();
                genre = MovieGenre.valueOf(genreS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введен жанр");
            }}
        movieArgs[4] = String.valueOf(genre);

        MpaaRating mpaaRating = null;
        while (mpaaRating == null){
            try {
                String mpaaRatingS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() +"Введите возрастное ограничение (G, PG, PG_13, R, NC_17): ");
                if (mpaaRatingS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");}
                mpaaRatingS = mpaaRatingS.toUpperCase();
                mpaaRating = MpaaRating.valueOf(mpaaRatingS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введено возрастное ограничение");
            }}
        movieArgs[5] = String.valueOf(mpaaRating);

        Form operatorForm = new OperatorForm(reader);
        String[] operatorArgs = operatorForm.getData();
        System.arraycopy(operatorArgs, 0, movieArgs, 6, operatorArgs.length);
        return movieArgs;
    }
}
