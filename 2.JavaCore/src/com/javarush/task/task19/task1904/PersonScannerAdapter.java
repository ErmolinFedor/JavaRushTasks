package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonScannerAdapter implements PersonScanner{
    private Scanner fileScaner;

    public PersonScannerAdapter(Scanner fileScaner) {
        this.fileScaner = fileScaner;
    }

    @Override
    public Person read() throws IOException {
        String line = fileScaner.nextLine();//Иванов Иван Иванович 31 12 1950
        String[] lines = line.split(" ");
        String firstName = lines[1].trim();
        String middleName = lines[2].trim();
        String lastName = lines[0].trim();
        Date birthDate = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String birth = lines[3].trim()+"-"+lines[4].trim()+"-"+lines[5].trim();

        try {

            birthDate = format.parse(birth);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return new Person(firstName , middleName , lastName, birthDate);
    }

    @Override
    public void close() throws IOException {
        fileScaner.close();
    }
}
