package com.javarush.task.task27.task2710;

/* 
Расставьте wait-notify
*/
public class Solution {
    //Thread-0 MailServer received: [Person [Thread-1] wrote an email 'AAA'] in 1001 ms after start
    public static void main(String[] args) {
        Mail mail = new Mail();
        Thread server = new Thread(new MailServer(mail));
        Thread amigo = new Thread(new Person(mail));

        server.start();
        amigo.start();
    }
}
