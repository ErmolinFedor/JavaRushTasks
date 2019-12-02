package com.javarush.task.task22.task2210;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("Fr rfd ewq eee" , " ")));
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query , delimiter);
        String[] res = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()){
            res[i] = stringTokenizer.nextToken();
            i++;
        }
        return res;
    }
}
