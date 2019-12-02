package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try (BufferedReader fileInputStream =new BufferedReader( new InputStreamReader(
                new FileInputStream(console.readLine()) , "UTF-8"))) {
            while (fileInputStream.ready())sb.append(fileInputStream.readLine()).append(" ");
        }
        List<String> tmp = new ArrayList<>();
        String[] words = sb.toString().split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            System.out.println(words[i]);
            StringBuilder sbTmp = new StringBuilder(words[i]);
            sbTmp.reverse();
            System.out.println("reverse: " + sbTmp);
            if (tmp.size()>0){
                if (tmp.contains(sbTmp.toString())){
                    Pair pair = new Pair();
                    pair.first = sbTmp.toString();
                    pair.second = words[i];
                    result.add(pair);
                    tmp.remove(sbTmp.toString());
                }else tmp.add(words[i]);
            }else{
                tmp.add(words[i]);
            }
        }
        System.out.println("result:");
        for (Pair pair : result) System.out.println(pair);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
