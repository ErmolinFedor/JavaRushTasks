package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        FileInputStream fs = new FileInputStream(br.readLine());
        List<Integer> list = new ArrayList<>();
        int cn;
        StringBuilder sb = new StringBuilder();
        while ((cn = fs.read())!=-1)sb.append((char) cn);
        StringTokenizer token = new StringTokenizer(sb.toString(), " \t\n\r,.");
        while (token.hasMoreTokens()) list.add(Integer.parseInt(token.nextToken()));
        Collections.sort(list);
        for(Integer num : list){
            if( num%2 == 0 )System.out.println(num);
        }
        fs.close();
        br.close();
    }
}
