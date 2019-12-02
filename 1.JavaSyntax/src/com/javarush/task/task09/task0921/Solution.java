package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        readData();
    }

    public static void readData() throws IOException {
        //BufferedReader br = null;
        List<Integer> list = new ArrayList<>();

       // br = new BufferedReader(new InputStreamReader(System.in));

        /*InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String s =br.readLine();*/
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //int age = scanner.nextInt();
        while (s!=null){
            if(s.equals("0")) break;;
            list.add(Integer.parseInt(s));
            s = scanner.nextLine();
        }
    }
}
