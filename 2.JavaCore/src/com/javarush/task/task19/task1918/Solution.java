package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String teg = "<" + args[0] ;
        String close ="<" + "/" + args[0] + ">";
        BufferedReader console = new BufferedReader( new InputStreamReader( System.in));
        BufferedReader file = new BufferedReader( new FileReader(console.readLine()));

        StringBuilder sb = new StringBuilder();

        while (file.ready()){
            sb.append(file.readLine());
        }
        String all = sb.toString();

        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < all.length() - close.length()+1; i++) {
            if (i < all.length() - teg.length() && all.substring(i, i + teg.length()).equals(teg)) {
                linkedList.add(i);
                if (list.size()>0){
                    while (list.size()>0)System.out.println(list.pollLast());
                }
            } else if (i < all.length() - close.length() + 1 && all.substring(i, i + close.length()).equals(close)) {
                String str = all.substring(linkedList.pollLast(), i + close.length());
                list.add(str);
            }
        }
        for (String line : list) System.out.println(line);

        file.close();
        console.close();
    }
}
