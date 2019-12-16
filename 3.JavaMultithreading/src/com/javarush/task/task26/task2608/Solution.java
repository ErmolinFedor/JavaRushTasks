package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать
*/
/*
1. Класс Solution должен содержать метод getSumOfVar1AndVar2().
2. Класс Solution должен содержать метод getSumOfVar3AndVar4().
3. Метод getSumOfVar1AndVar2() должен содержать synchronized блок.
4. Метод getSumOfVar3AndVar4() должен содержать synchronized блок.
5. Synchronized блоки методов getSumOfVar1AndVar2() и getSumOfVar3AndVar4() должны использовать мьютексы разных объектов.
 */
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        int res;
        Integer var1warp = Integer.valueOf(var1);
        synchronized (var1warp){
            res = var1warp + var2;
        }
        return res;
    }

    public int getSumOfVar3AndVar4() {
        int res;
        Integer var3warp = Integer.valueOf(var3);
        synchronized (var3warp){
            res = var3warp + var4;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
