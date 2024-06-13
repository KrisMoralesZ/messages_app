package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    }
    public  static  void updateMessageInDB(Messages messages){

    }
    public  static  void deleteMessageInDB(int id_message){

    }

}
