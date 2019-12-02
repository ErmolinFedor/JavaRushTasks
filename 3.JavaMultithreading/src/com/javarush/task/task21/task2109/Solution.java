package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public int hashCode() {
            return 31 * i + 15 * j;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj==null || obj.getClass() != this.getClass() ) return false;
            A o = (A) obj;
            if (i !=o.getI() || j != o.getJ()) return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new A(i , j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            int res = super.hashCode();
            res+= name!=null ? name.hashCode() : 0;
            res+=3*super.getI();
            res+=7*super.getJ();
            return res;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass()!=this.getClass()) return false;
            B o = (B) obj;
            if (o.getName() != null ? o.getName().equals(this.name) : name!= null) return false;
            if ( super.getI() != o.getI()) return false;
            if ( super.getJ() != o.getJ()) return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new  CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C(C obj){
            super(obj.getI() , obj.getJ() , obj.getName());
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C(this);
        }
    }

    public static void main(String[] args) {

    }
}
