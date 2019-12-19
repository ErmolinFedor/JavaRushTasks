package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args){
        int number = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(number)) {
            System.out.println("Server has started.");

            while (true){
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run(){
            ConsoleHelper.writeMessage("Established new connection with remote address " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                ConsoleHelper.writeMessage("Connection with port " + connection.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection , userName);
                serverMainLoop(connection , userName);

            }catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }finally {
                if (userName != null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    ConsoleHelper.writeMessage(String.format("Connection with remote address (%s) is closed.", socket.getRemoteSocketAddress()));
                }
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true) {
                // Сформировать и отправить команду запроса имени пользователя
                connection.send(new Message(MessageType.NAME_REQUEST));
                // Получить ответ клиента
                Message message = connection.receive();

                // Проверить, что получена команда с именем пользователя
                if (message.getType() == MessageType.USER_NAME) {

                    //Достать из ответа имя, проверить, что оно не пустое
                    if (message.getData() != null && !message.getData().isEmpty()) {

                        // и пользователь с таким именем еще не подключен (используй connectionMap)
                        if (connectionMap.get(message.getData()) == null) {

                            // Добавить нового пользователя и соединение с ним в connectionMap
                            connectionMap.put(message.getData(), connection);
                            // Отправить клиенту команду информирующую, что его имя принято
                            connection.send(new Message(MessageType.NAME_ACCEPTED));

                            // Вернуть принятое имя в качестве возвращаемого значения
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{

            for (String key : connectionMap.keySet()) {
                Message message = new Message(MessageType.USER_ADDED, key);

                if (!key.equals(userName)) {
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{

            while (true){
                Message message = connection.receive();
                if (message.getType()== MessageType.TEXT){
                    String text = userName + ": "+ message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT , text));
                }
                else {
                    ConsoleHelper.writeMessage("Нe правильный формат сообщения отличный от \"TEXT\"!");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String , Connection> connectionEntry : connectionMap.entrySet()){
            //String who = connectionEntry.getKey();
            try {
                connectionEntry.getValue().send(message);
            } catch (IOException e) {
                System.out.println("The message didn't send");
            }
        }
    }
}
