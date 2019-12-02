package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m , short n , String value){
        for (int i = 0; i < m; i++) {
            for (short j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m , Short n , String value){
        for (int i = 0; i < m; i++) {
            for (short j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(short m , short n , String value){
        for (short i = 0; i < m; i++) {
            for (short j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(long m , short n , String value){
        for (long i = 0; i < m; i++) {
            for (short j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(long m , long n , String value){
        for (long i = 0; i < m; i++) {
            for (long j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m , short n , String value){
        for (Integer i = 0; i < m; i++) {
            for (short j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m , Integer n , String value){
        for (Integer i = 0; i < m; i++) {
            for (Integer j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(byte m , byte n , String value){
        for (byte i = 0; i < m; i++) {
            for (byte j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
