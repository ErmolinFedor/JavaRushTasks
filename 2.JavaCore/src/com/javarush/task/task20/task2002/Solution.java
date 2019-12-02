package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("D:\\3.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Frank");
            user1.setLastName("galager");
            user1.setMale(true);
            Date date = null;
            try {
                date = simpleDateFormat.parse("1985-09-20");
            }catch (DateTimeParseException e){
                e.printStackTrace();
            }
            user1.setBirthDate(date);
            user1.setCountry(User.Country.RUSSIA);

            User user2 = new User();
            user2.setFirstName("Den");
            user2.setLastName("Daugh");
            user2.setMale(false);
            Date date1 = null;
            try {
                date1 = simpleDateFormat.parse("1990-03-16");
            }catch (DateTimeParseException e){
                e.printStackTrace();
            }
            user2.setBirthDate(date1);
            user2.setCountry(User.Country.OTHER);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

           // System.out.println("write done");

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
           /* System.out.println(loadedObject.users.size());
            System.out.println(loadedObject.users.get(0).getBirthDate().getTime());
            System.out.println(javaRush.users.get(0).getBirthDate().getTime());
            System.out.println(loadedObject.users.get(1).getBirthDate().getTime());
            System.out.println(javaRush.users.get(1).getBirthDate().getTime());
            System.out.println(javaRush.users.toString());
            System.out.println(loadedObject.users.toString());
            System.out.println(javaRush.users.equals(loadedObject.users));*/

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        private String isMail(boolean isMail){
            return isMail ? "m" : "f";
        }
        private boolean isMail(String is){
            return is.equals("m");
        }

        public void save(OutputStream outputStream) throws Exception {
            //System.out.println("Start write");
            outputStream.write(String.valueOf(users.size()).getBytes());
            outputStream.write("\n".getBytes());

            if (users.size()>0){
                for (User user : users){
                    outputStream.write(user.getFirstName().getBytes());
                    outputStream.write("\n".getBytes());
                    outputStream.write(user.getLastName().getBytes());
                    outputStream.write("\n".getBytes());
                    //outputStream.write(simpleDateFormat.format(user.getBirthDate()).getBytes());
                    outputStream.write(String.valueOf(user.getBirthDate().getTime()).getBytes());
                    outputStream.write("\n".getBytes());
                    outputStream.write(isMail(user.isMale()).getBytes());
                    outputStream.write("\n".getBytes());
                    outputStream.write(user.getCountry().getDisplayName().getBytes());
                    outputStream.write("\n".getBytes());
                }
            }//System.out.println("Stop write");
        }

        public void load(InputStream inputStream) throws Exception {
            StringBuilder sb = new StringBuilder();

            //System.out.println("Start Read");

            while (inputStream.available()>0){
                sb.append((char)inputStream.read());
            }
            //System.out.println(sb.toString());
            String[] lines = sb.toString().split("\\n");
            int capacity = Integer.parseInt(lines[0]);
            //System.out.println("Capacity " + capacity);
            if (capacity>0){
                for (int i = 1; i < lines.length-4; i = i + 5) {
                    User user = new User();
                    user.setFirstName(lines[i].trim());//System.out.println("Firs "+lines[i]);
                    user.setLastName(lines[i+1].trim());//System.out.println("Last "+lines[i+1]);
                   /* Date birthday = null;
                    try {
                        birthday = simpleDateFormat.parse(lines[i+2].trim());
                    }catch (DateTimeParseException e){
                        e.printStackTrace();
                    }
                    user.setBirthDate(birthday);//System.out.println("birth "+lines[i+2]);*/
                    user.setBirthDate(new Date(Long.parseLong(lines[i+2])));
                    user.setMale(isMail(lines[i+3].trim()));//System.out.println("mail "+isMail(lines[i+3]));
                    String country = lines[i+4];//System.out.println("state in file " + lines[i+4]);
                    switch (country){
                        case "Ukraine" : user.setCountry(User.Country.UKRAINE);break;
                        case "Russia" : user.setCountry(User.Country.RUSSIA);break;
                        case "Other" : user.setCountry(User.Country.OTHER);break;
                    }//System.out.println("State " + user.getCountry().getDisplayName());
                    users.add(user);
                }
            }
            //System.out.println("Stop Read");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
