package org.example;

import java.util.Scanner;

public class MessagesService {

    public  static void createMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a text message: ");
        String message = scanner.nextLine();

        System.out.println("What is your name: ");
        String name = scanner.nextLine();

        Messages writeMessage = new Messages();
        writeMessage.setMessage(message);
        writeMessage.setAuthor_name(name);

        MessagesDao.createMessageInDB(writeMessage);
    }

    public static void showMessages() {
        MessagesDao.readMessages();
    }

    public  static void updateMessage() {}

    public  static void deleteMessage() {}
}
