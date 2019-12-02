package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);
        int count =1;
        while (fr.ready()){
            int tmp = fr.read();
            if (count%2==0){
                fw.write(tmp);
            }
            count++;
        }
        fr.close();
        fw.close();
    }
}
