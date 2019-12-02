package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.ArrayList;
import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public List<User> getUsers(){
        AbstractDbSelectExecutor<User> abstractDbSelectExecutor = new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        };
        List<User> res = abstractDbSelectExecutor.execute();
        return res;
    }

    public List<Subject> getSubjects(){
        AbstractDbSelectExecutor<Subject> abstractDbSelectExecutor = new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        };
        List<Subject> res = abstractDbSelectExecutor.execute();
        return res;
    }

    public List<Subscription> getSubscriptions(){
        AbstractDbSelectExecutor<Subscription> abstractDbSelectExecutor = new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        };
        List<Subscription> res = abstractDbSelectExecutor.execute();
        return res;
    }
    public List<Server> getServers(){
        AbstractDbSelectExecutor<Server> abstractDbSelectExecutor = new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        };
        List<Server> res = abstractDbSelectExecutor.execute();
        return res;
    }
    public List<Location> getLocations(){
        AbstractDbSelectExecutor<Location> abstractDbSelectExecutor= new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
        List<Location> res = abstractDbSelectExecutor.execute();
        return res;
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
