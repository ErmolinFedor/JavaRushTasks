package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(Statics.FILE_NAME)));
            String s = br.readLine();
            while (s!=null){
                lines.add(s);
                s = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
