package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream( new File(args[0]));
        FileOutputStream writer = new FileOutputStream(new File(args[1]));

        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] buffer= new byte[reader.available()];
        reader.read(buffer);
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(utf8);
        writer.write(buffer);
        reader.close();
        writer.flush();
        writer.close();
    }
}
