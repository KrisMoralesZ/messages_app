package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("-----------------");
            System.out.println("Messages Application");
            System.out.println("1. Create a new message");
            System.out.println("2. Display all messages");
            System.out.println("3. Edit message");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    MessagesService.createMessage();
                    break;
                case 2:
                    MessagesService.showMessages();
                    break;
                case 3:
                    MessagesService.updateMessage();
                    break;
                case 4:
                    MessagesService.deleteMessage();
                    break;
                default:
                    break;
            }
        }
        while (option != 5);
    }
}