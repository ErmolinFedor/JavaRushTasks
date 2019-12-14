package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        //Integer[] arr = {13, 8, 15, 5 };
        //System.out.println(Arrays.toString(sort(arr)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);

        final double median;
        if (array.length%2==0)
            median = ((double)array[array.length/2-1]+(double)array[array.length/2])/2;
        else
            median = array[array.length/2];

        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2) {
                double dif = Math.abs(o1 - median) - Math.abs(o2 - median);
                dif = dif != 0 ? dif : o1 -o2;
                return (int)dif;
            }
        };
        Arrays.sort(array, comparator);
        return array;
    }
}
