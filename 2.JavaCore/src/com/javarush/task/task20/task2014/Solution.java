package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File objectFile = File.createTempFile("objectWhithStaticFild.bin",null);
        //System.out.println(objectFile.getPath()); // путь к созданному временному файлу
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));

        Solution savedObject = new Solution(77);
        oos.writeObject(savedObject);
        oos.close();


        Solution loadedObject = (Solution) ois.readObject();
        // у Вас будут разные надписи(в зависимости от наличия/отсутствия методов)
        ois.close();
        System.out.println(savedObject);
        System.out.println(loadedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
        //System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
