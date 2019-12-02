package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> str = new ArrayList<>();
        int n= Integer.parseInt(reader.readLine());
        int m= Integer.parseInt(reader.readLine());

        for(int i=0 ; i<n ; i++){
            str.add(reader.readLine());
        }

        for (int i = 0 ; i < m ; i++){
            String s= str.get(0);
            str.remove(0);
            str.add(str.size()-1 , s);
        }
        for( String s : str) System.out.println(s);
    }
}
