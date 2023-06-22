package client.form;

import enums.Color;
import enums.ConsoleColor;
import enums.Country;
import client.reader.Reader;
import client.exceptions.InputInterruptionException;
import server.exceptions.WrongArgumentException;

import java.util.Objects;

public class OperatorForm extends Form{
    public OperatorForm(Reader reader) {
        super(reader);
    }

    @Override
    public String[] getData() throws WrongArgumentException, InputInterruptionException {
        String[] movieArgs = new String[9];
        String name = null;
        while (name == null){
            name = reader.readLineWithMessage("Введите имя оператора: ");

            if (name.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException("\n Вы вышли из команды");
            }

            if (Objects.equals(name, "")){
                name = null;
                System.out.println(ConsoleColor.RED.getCode() + "Имя не может быть пустым");
            }
        }
        movieArgs[0] = name;

        Integer weight = null;
        while (weight == null){
            try {
                String weightS =  reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите вес оператора: ");
                if (weightS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
                }
                weight = Integer.parseInt(weightS);
                if (weight <= 0){
                    System.out.println(ConsoleColor.RED.getCode() + "Вес не может быть отрицательным");
                    weight = null;
                }

            }catch (NumberFormatException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно веден вес");}}
        movieArgs[1] = String.valueOf(weight);

        Integer age = null;
        while (age == null){
            try {
                String ageS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите возраст оператора: ");
                if (ageS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
                }
                age = Integer.parseInt(ageS);
                if (age <= 0){
                    System.out.println(ConsoleColor.RED.getCode() + "Возраст не может быть отрицательным");
                    age = null;
                }
            }catch (NumberFormatException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно веден вес");}}
        movieArgs[2] = String.valueOf(age);


        Color color = null;
        while (color == null){
            try {
                String colorS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите цвет глаз оператора: ");
                if (colorS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
                }
                colorS = colorS.toUpperCase();
                color = Color.valueOf(colorS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введен цвет глаз");
            }}
        movieArgs[3] = String.valueOf(color);



        Color color1 = null;
        while (color1 == null){
            try {
                String colorS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите цвет волос оператора: ");
                if (colorS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
                }
                colorS = colorS.toUpperCase();
                color1 = Color.valueOf(colorS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введен цвет волос");
            }}
        movieArgs[4] = String.valueOf(color1);

        Country country = null;
        while(country == null){

            try {
                String countryS = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите национальность оператора: ");
                if (countryS.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
                }
                countryS = countryS.toUpperCase();
                country = Country.valueOf(countryS);
            }catch (IllegalArgumentException e){
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введена страна оператора");
            }}
        movieArgs[5] = String.valueOf(country);
        Double x = null;
        while (x == null) {
            try {
                String xString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите координату x: ");
                if (xString.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
                }
                x = Double.parseDouble(xString);
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введена координата х");
            }
        }
        movieArgs[6] = String.valueOf(x);
        Float y = null;
        while (y == null){
            String yString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите координату y: ");
            if (yString.equalsIgnoreCase("cancel")) {
                throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
            }
            try {
                y = Float.valueOf(yString);
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введена координата y");
            }
        }
        movieArgs[7] = String.valueOf(y);
        Integer z = null;
        while(z == null){
            try {
                String zString = reader.readLineWithMessage(ConsoleColor.CYAN.getCode() + "Введите координату z: ");
                if (zString.equalsIgnoreCase("cancel")) {
                    throw new InputInterruptionException(ConsoleColor.YELLOW.getCode() + "\n Вы вышли из команды");
                }
                z = Integer.valueOf(zString);
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColor.RED.getCode() + "Неверно введена координата z ");
            }}
        movieArgs[8] = String.valueOf(z);
        return movieArgs;

}}
