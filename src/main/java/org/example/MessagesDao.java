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
                System.out.println("Message: "+rs.getString("message"));
            }
        } catch (SQLException e) {
            System.out.println("Couldn't read messages");
            System.out.println(e);
        }
    }

    public  static  void deleteMessageInDB(int id_message){
        ConnectWithDB db_connect = new ConnectWithDB();

        try(Connection connection = db_connect.get_connection()) {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "DELETE FROM messages WHERE id_message = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id_message);
                preparedStatement.executeUpdate();
                System.out.println("Message deleted successfully");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println("Couldn't delete message");
            System.out.println(e);
        }
    }

    public static  void updateMessageInDB(Messages messages){
        ConnectWithDB db_connect = new ConnectWithDB();

        try (Connection connection = db_connect.get_connection()) {
            PreparedStatement preparedStatement = null;

            try {
                String sql = "UPDATE messages SET message = ? WHERE id_message = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, messages.getMessage());
                preparedStatement.setInt(2, messages.getId_message());
                preparedStatement.executeUpdate();
                System.out.println("Message updated successfully");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println("Couldn't update message");
            System.out.println(e);
        }
    }


}
