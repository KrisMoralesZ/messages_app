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

    public  static void deleteMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What message do you want to delete?: ");
        int id_message = scanner.nextInt();
        MessagesDao.deleteMessageInDB(id_message);
    }

    public  static void updateMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your new message: ");
        String message = scanner.nextLine();

        System.out.println("Which message do you want to update?: ");
        int id_message = scanner.nextInt();

        Messages updateMessage = new Messages();
        updateMessage.setMessage(message);
        updateMessage.setId_message(id_message);
        MessagesDao.updateMessageInDB(updateMessage);
    }

}
