package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution  implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone =(Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public int hashCode() {
        int res = users!=null ? users.hashCode() : 0;
        return 31*res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Solution)) return false;
        Solution o = (Solution) obj;
        if (o.users!= null && users!= null) {
            for (Map.Entry<String ,User> pair : users.entrySet()){
                if (!(o.users.containsKey(pair.getKey())))return false;
                if (!(o.users.containsValue(pair.getValue()))) return false;
            }
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution clone = (Solution) super.clone();
        clone.users = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            clone.users.put(entry.getKey(), (User) entry.getValue().clone());
        }
        return clone;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        private User(User other){
            age = other.age;
            name = other.name;
        }

        @Override
        public int hashCode() {
            int res = name!=null ? name.hashCode() : 0;
            return res + 31* age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof User))return false;
            User o = (User) obj;
            if (o.name!= null ? name != o.name : name!=null) return false;
            if (o.age != age) return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //User clon = (User)super.clone();
            return new User(this);
        }
    }
}
