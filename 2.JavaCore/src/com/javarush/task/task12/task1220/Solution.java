package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы CanRun, CanSwim
*/

/*
Класс Human и интерфейсы CanRun, CanSwim
Напиши public класс Human(человек) и public интерфейсы CanRun(бежать/ездить), CanSwim(плавать).
Добавь в каждый интерфейс по oдному методу.
Добавь эти интерфейсы классу Human, но не реализуй методы.
Объяви класс Human абстрактным.


Требования:
1. Класс Solution должен содержать интерфейс CanRun с одним методом.
2. Класс Solution должен содержать интерфейс CanSwim с одним методом.
3. Класс Solution должен содержать класс Human.
4. Класс Human должен реализовывать интерфейсы CanRun и CanSwim.
5. Класс Human должен быть абстрактным.
6. Класс Human не должен иметь методов.
 */

public class Solution {
    public static void main(String[] args) {
    }

    public abstract class Human implements  CanRun , CanSwim{

    }
    public  interface CanRun {
        public void run();
    }
    public interface CanSwim {
        public void swim();
    }
}
