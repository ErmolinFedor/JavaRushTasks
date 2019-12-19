package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public static void main(String[] args){
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (message.contains(":")){
                String[] req = message.split(":");
                switch (req[1].trim()){
                    case "дата":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime())));
                        break;
                    case "день":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("d").format(Calendar.getInstance().getTime())));
                        break;
                    case "месяц":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime())));
                        break;
                    case "год":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime())));
                        break;
                    case "время":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime())));
                        break;
                    case "час":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("H").format(Calendar.getInstance().getTime())));
                        break;
                    case "минуты":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("m").format(Calendar.getInstance().getTime())));
                        break;
                    case "секунды":
                        sendTextMessage(String.format("Информация для %s: %s", req[0].trim(),
                                new SimpleDateFormat("s").format(Calendar.getInstance().getTime())));
                        break;
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }
}
