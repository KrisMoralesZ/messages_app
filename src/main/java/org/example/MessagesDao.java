package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagesDao {

    public  static  void createMessageInDB(Messages messages){
        ConnectWithDB db_connect = new ConnectWithDB();
        try(Connection connection = db_connect.get_connection()){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "INSERT INTO messages (message,author_message) values (?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, messages.getMessage());
                preparedStatement.setString(2, messages.getAuthor_name());
                preparedStatement.executeUpdate();
                System.out.println("Message inserted successfully");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void readMessages(){
        ConnectWithDB db_connect = new ConnectWithDB();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try(Connection connection = db_connect.get_connection()){
            String query = "SELECT * FROM messages";
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();

            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_message"));
                System.out.println(rs.getString("Message: "+ rs.getString("message")));
                System.out.println(rs.getString("Author: "+rs.getString("author_name")));
                System.out.println(rs.getString("Date: "+ rs.getString("date_message")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public  static  void updateMessageInDB(Messages messages){

    }
    public  static  void deleteMessageInDB(int id_message){

    }

}