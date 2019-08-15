/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcelo
 */
public class ConnectionSingleton {

    private static Connection conn = null;

    private static final String url = "jdbc:postgresql://localhost:5432/sgh";
    private static final String user = "postgres";
    private static final String pass = "postgres";
            
    public static Connection getConnection() {

        if (conn == null) {
      
            try {
                conn = DriverManager.getConnection(url, user, pass) ;
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return conn;
    }
}
