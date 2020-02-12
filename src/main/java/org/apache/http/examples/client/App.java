package org.apache.http.examples.client;
import com.example.Example.java.User;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author postgresqltutorial.com
 */
public class App{

    private final String url = "jdbc:postgresql://localhost:5434/postgres";
    private final String user = "postgres";
    private final String password = "123";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @param
     */
    public Connection connect(Test test) {
        ObjectMapper mapper = new ObjectMapper();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            try {
                String b = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(test.getLocation());
                String c = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(test.getUsers());
                PreparedStatement pt = conn.prepareStatement("INSERT INTO \"rest\" values(?,?,?,?)");
                pt.setString(1,test.getClientContext());
                pt.setString(2,b);
                pt.setString(3,test.getUId());
                pt.setString(4,c);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }






        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }




}
