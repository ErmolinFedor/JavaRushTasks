package com.javarush.task.task22.task2206;

import java.util.Date;

/* 
Форматирование даты
*/
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
        //05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)
    }

    public static String getFormattedString() {
        return "%td:%tm:%ty %tH:%tM:%tS";
    }
}
