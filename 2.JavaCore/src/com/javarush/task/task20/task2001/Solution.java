package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("D:\\3.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home",
                    999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            System.out.println(ivanov.equals(somePerson));
     //       System.out.println(ivanov.name);
      //      System.out.println(somePerson.name);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
           // outputStream.write("Human".getBytes());
            outputStream.write(name.getBytes());
            outputStream.write("\n".getBytes());
            for (Asset asset : assets){
               // outputStream.write("Asset".getBytes());
                outputStream.write(asset.getName().getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write(String.valueOf(asset.getPrice()).getBytes());
                outputStream.write("\n".getBytes());
            }

        }

        public void load(InputStream inputStream) throws Exception {
            StringBuilder sb = new StringBuilder();
            while (inputStream.available()>0){
                sb.append((char)inputStream.read());
            }
            String[] lines = sb.toString().split("\\n");
            name = lines[0].trim();

            for (int i = 1; i < lines.length; i= i+2) {
                String log = lines[i].trim();
                double price = Double.parseDouble(lines[i+1]);
                assets.add(new Asset(log, price));
            }

        }
    }
}
