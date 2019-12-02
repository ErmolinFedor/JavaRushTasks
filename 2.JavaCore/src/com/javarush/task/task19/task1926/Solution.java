package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader cosole = new BufferedReader( new InputStreamReader(System.in));
        BufferedReader file =new BufferedReader( new FileReader(cosole.readLine()));

        StringBuilder sb = new StringBuilder();

        while (file.ready()){
            StringBuilder s = new StringBuilder();
            s.append(file.readLine());
            sb.append(s.reverse().toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());
        file.close();
        cosole.close();
    }
}
