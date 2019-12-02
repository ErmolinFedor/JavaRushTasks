package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static int nod(int a , int b){
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        int a =0;
        int b=0;
        try {
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(a <= 0) throw new Exception();
        if(b<=0) throw new Exception();
        System.out.println(nod( a, b));
    }
}
