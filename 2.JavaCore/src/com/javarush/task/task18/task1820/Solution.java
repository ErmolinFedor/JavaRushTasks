package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream fos = new FileOutputStream(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (fis.available()>0){
            sb.append((char)fis.read());
        }
        fis.close();
        String line = sb.toString();
        String[] lines = line.split(" ");
        double[] nums = new double[lines.length];
        int[] res = new int[lines.length];
        sb.setLength(0);

        for (int i = 0; i < lines.length ; i++) {
            nums[i] = Double.parseDouble(lines[i].trim());
            res[i] = (int) Math.round(nums[i]);
            sb.append(res[i]);
            if (i<lines.length-1) sb.append(" ");
        }
        fos.write(sb.toString().getBytes());
        fos.close();
    }
}
