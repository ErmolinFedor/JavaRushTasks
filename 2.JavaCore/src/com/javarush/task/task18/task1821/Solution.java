package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        Map<Character , Integer> map= new HashMap<>();

        while (file.available()>0){
            char ch =(char) file.read();
            if (map.containsKey(ch)){
                int val = map.get(ch);
                ++val;
                map.put(ch , val);
            }else {
                map.put(ch , 1);
            }
        }
        file.close();
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (Character chr : list){

            System.out.println(chr + " "+ map.get(chr));
        }

    }
}
