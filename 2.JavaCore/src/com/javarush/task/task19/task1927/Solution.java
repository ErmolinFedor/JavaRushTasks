package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        testString.printSomething();
        System.setOut(consoleStream);

//        long t = System.currentTimeMillis();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        for (int i = 1; reader.ready(); i++) {
            System.out.println(reader.readLine());
            if (i % 2 == 0) System.out.println("JavaRush - курсы Java онлайн");
        }
//        System.out.println(System.currentTimeMillis() - t);

        bais.close();
        baos.close();
        reader.close();
        consoleStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}