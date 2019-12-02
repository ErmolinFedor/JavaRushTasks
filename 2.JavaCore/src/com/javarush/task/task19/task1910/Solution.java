package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(new FileReader(br.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(br.readLine()));

        while (in.ready()){
            String line = in.readLine();
            out.write(line.replaceAll("\\pP" , ""));
        }
        out.close();
        in.close();
        br.close();
    }
}
