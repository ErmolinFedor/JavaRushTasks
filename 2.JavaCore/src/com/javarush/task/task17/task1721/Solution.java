package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in));
        String file1 = "" ,file2 ="";
        try {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(new File(file1)));
            BufferedReader reader2 = new BufferedReader(new FileReader(new File(file2)));

            while (reader1.ready()){
                allLines.add(reader1.readLine());
            }
            while (reader2.ready()){
                forRemoveLines.add(reader2.readLine());
            }
            reader1.close();
            reader2.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Solution sol = new Solution();
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
