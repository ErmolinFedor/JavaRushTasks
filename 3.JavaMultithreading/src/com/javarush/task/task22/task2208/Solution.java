package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String , String> map = new HashMap<>();
        map.put("name" , null);
        map.put("country" , null);
        map.put("city" , null);
        map.put("age" , null);
        System.out.println(getQuery(map));
    }
    //{name=Ivanov, country=Ukraine, city=Kiev, age=null}
    //
    //Результат:
    //name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
    public static String getQuery(Map<String, String> params) {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String , String> pair : params.entrySet()){
            if (pair.getValue()!=null) res.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }
        if (res.length()>5){
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);}
        return res.toString();
    }
}
