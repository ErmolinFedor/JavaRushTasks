package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader file = new BufferedReader( new FileReader( args[0]));

        while (file.ready()){
            String[] words = file.readLine().split(" ");
            if (words.length>3){
            Date birthday = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            birthday = simpleDateFormat.parse(words[words.length-1] + "-" + words[words.length-2] + "-" + words[words.length-3]);
            String name = "";
            for (int i = 0; i <words.length-3 ; i++) {
                name += words[i];
                if (i<words.length-4) name+=" ";
            }
            PEOPLE.add(new Person(name , birthday));}
        }

        for (Person p : PEOPLE) System.out.println(p.getName() + " : " + p.getBirthDate().toString());
        file.close();
    }
}
