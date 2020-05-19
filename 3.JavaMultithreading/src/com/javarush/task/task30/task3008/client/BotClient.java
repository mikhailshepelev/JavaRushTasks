package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_" + (int) (Math.random()*100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(":")) return;
            String [] array = message.split(": ");
            switch (array[1]) {
                case "дата" :
                    createMessage(array[0],"d.MM.YYYY");
                    break;
                case "день" :
                    createMessage(array[0],"d");
                    break;
                case "месяц" :
                    createMessage(array[0],"MMMM");
                    break;
                case "год" :
                    createMessage(array[0],"YYYY");
                    break;
                case "время" :
                    createMessage(array[0],"H:mm:ss");
                    break;
                case "час" :
                    createMessage(array[0],"H");
                    break;
                case "минуты" :
                    createMessage(array[0],"m");
                    break;
                case "секунды" :
                    createMessage(array[0],"s");
                    break;
            }
        }

        private void createMessage(String name, String datePattern) {
            Date date = new GregorianCalendar().getTime();
            DateFormat df = new SimpleDateFormat(datePattern);
            String parsedDate = df.format(date);
            sendTextMessage("Информация для " + name + ": " + parsedDate);
        }
    }
}
