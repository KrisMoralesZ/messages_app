package org.example;

public class Messages {
    int id_message;
    String message;
    String author_name;
    String date_message;

    public Messages(int id_message, String message, String author_name, String date_message) {
        this.id_message = id_message;
        this.message = message;
        this.author_name = author_name;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setDate_message(String date_message) {
        this.date_message = date_message;
    }

    public int getId_message() {
        return id_message;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getDate_message() {
        return date_message;
    }
}
