package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream amigo;

    public QuestionFileOutputStream(AmigoOutputStream amigo){
            this.amigo = amigo;
    }

    @Override
    public void flush() throws IOException {
        amigo.flush();
    }

    @Override
    public void write(int b) throws IOException {
        amigo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
            amigo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
            amigo.write(b ,off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        if (br.readLine().equals("Д")) amigo.close();
    }
}

