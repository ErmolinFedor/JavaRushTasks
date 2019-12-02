package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone =(Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public int hashCode() {
            return 31* branches.hashCode();
        }

        private boolean helperEq( String[] o1 , String[] o2){
            if (o1.length!= o2.length)return false;
            for (int i = 0; i < o2.length; i++) {
                if (o1[i]!=o2[i]) return false;
            }
            return true;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;
            Tree o = (Tree) obj;
            if (o.branches!=null ? helperEq(o.branches , this.branches) : branches!=null) return false;
            if (o.getName()!=null ? this.getName().equals(o.getName()) : this.getName()!=null) return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            String[] oBranches = new String[this.branches.length];
            for (int i = 0; i < oBranches.length; i++) {
                oBranches[i] = this.branches[i];
            }
            Tree res = new Tree(this.getName() , oBranches);
            return res;
        }
    }
}
