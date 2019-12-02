package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        String file = br.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        String line;
        while(true) {
            line =br.readLine();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            if(line.equalsIgnoreCase("exit"))break;
           // bufferedWriter.newLine();
        }
        bufferedWriter.close();;
        br.close();
    }

  //  public static void write(String file){

  //  }
}
