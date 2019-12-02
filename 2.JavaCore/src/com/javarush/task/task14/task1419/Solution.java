package com.javarush.task.task14.task1419;

import javax.management.BadAttributeValueExpException;
import javax.naming.NamingException;
import javax.xml.xpath.XPathException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.nio.file.FileAlreadyExistsException;
import java.rmi.AlreadyBoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[1];//2
            arr[7] = 9;
        }catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int n = Integer.parseInt("o");//3
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new AlreadyBoundException();//4
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new BadAttributeValueExpException(new Object());//5
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw  new InvalidClassException("dd");//6
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NamingException();//7
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new SQLException();//8
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new TimeoutException();//9
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new XPathException(new OutOfMemoryError());//10
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
