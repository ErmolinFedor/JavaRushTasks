package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter( new FileWriter(args[1]));
        List<String> wordList = new ArrayList<>();

        while (reader.ready()){
            String[] words = reader.readLine().split(" ");
            for (String word : words){
                if (word.length()>6){
                    wordList.add(word);
                }
            }
        }
        for (int i = 0; i <wordList.size() ; i++) {
            writer.write(wordList.get(i));
            if (i<wordList.size()-1)writer.write(",");
        }
        reader.close();
        writer.close();
    }
}
