package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(br.readLine());

        Set<Integer> set= new HashSet<>();

        while (fis.available() > 0){
            set.add(fis.read());
        }
        fis.close();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Integer num : list) System.out.print(num + " ");
    }
}
