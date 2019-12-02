package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) {
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConsoleWriter(File file, boolean append){
        try {
            fileWriter = new FileWriter(file , append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConsoleWriter (FileDescriptor fd){
        fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName){
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConsoleWriter(String fileName, boolean append){
        try {
            fileWriter = new FileWriter(fileName , append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(char[] cbuf, int off, int len) throws IOException{
        System.out.print(new String(cbuf, off, len));
        fileWriter.write(cbuf , off , len);
    }
    public void write(int c) throws IOException{
        System.out.println(c);
        fileWriter.write(c);
    }
    public void write(String str) throws IOException{
        System.out.println(str);
        fileWriter.write(str);
    }
    public void write(String str, int off, int len){
        System.out.println(str.substring(off , off+len));
        try {
            fileWriter.write(str , off , len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(char[] cbuf) throws IOException{
        System.out.println(cbuf);
        fileWriter.write(cbuf);
    }
    public void close() throws IOException{
        fileWriter.close();
    }


    public static void main(String[] args) {

    }

}
