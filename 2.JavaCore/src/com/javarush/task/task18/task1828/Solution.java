package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length<1) return;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        if (args[0].startsWith("-u")){
            //chek
            if (args.length<5) return;
            int id=0;
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <args.length-2 ; i++) {
                sb.append(args[i]).append(" ");
            }
            //String productName = sb.length()>30 ? sb.substring(0 , 30) : sb.toString();
            String productName =sb.toString();
            float price = 0.0f;
            int quantity = 0;
            try {
                id = Integer.parseInt(args[1]);
                price = Float.parseFloat(args[args.length-2]);
                quantity = Integer.parseInt(args[args.length-1]);
            }catch (NumberFormatException e){
                return;
            }
            new Solution().update(fileName , id , productName , price, quantity);
        }else if (args[0].startsWith("-d")){
            if (args.length<2) return;
            int id = 0;
            try {
                id= Integer.parseInt(args[1]);
            }catch (NumberFormatException e){
                return;
            }
            new Solution().detete(fileName, id);
        }

    }

    private void update(String fileName , int id , String productName , float price , int quantity)throws IOException{

        String line = String.format(Locale.ROOT,"%-8d%-30.30s%-8.2f%-4d", id, productName, price, quantity);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()){
            String res= bufferedReader.readLine();
            int idCurrent = Integer.parseInt(res.substring(0 , 8).trim());
            if (idCurrent == id){
                sb.append(line).append("\n");
            }else {
                sb.append(res).append("\n");
            }
        }
        bufferedReader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.close();
    }
    private void detete (String fileName , int id) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        System.out.println("delete:" + id);
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()){
            String res= bufferedReader.readLine();
            int idCurrent = Integer.parseInt(res.substring(0 , 8).trim());
            if (idCurrent != id){
                sb.append(res).append("\n");
            }
        }
        bufferedReader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.close();
    }
}
