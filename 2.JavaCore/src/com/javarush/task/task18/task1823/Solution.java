package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String file = br.readLine();
        while (!file.equals("exit")){
            ReadThread thread = new ReadThread(file);
            thread.start();
            file = br.readLine();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        public void run(){
            Map<Integer , Integer> tmp = new HashMap<>();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available()>0){
                    int num = fis.read();
                    if (tmp.containsKey(num)){
                        int val = tmp.get(num);
                        ++val;
                        tmp.put(num , val);
                    }else {
                        tmp.put(num , 1);
                    }

                }
                fis.close();
            }catch (FileNotFoundException e){
                e.printStackTrace(); return;
            } catch (IOException e) {
                e.printStackTrace();return;
            }
            List<Integer> list = new ArrayList<>(tmp.values());
            synchronized (resultMap){
                int res =0;
                for (Map.Entry<Integer , Integer> pair : tmp.entrySet()){
                    if (pair.getValue()==Collections.max(list)) res = pair.getKey();
                }
            resultMap.put(fileName , res);
            }
        }
    }
}
