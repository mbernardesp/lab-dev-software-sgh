/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcelo
 */
public class ConnectionFactory {

    private static Connection conn = null;

    private static final String url = "jdbc:postgresql://localhost:5432/sgh";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static Connection getConnection() {

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return conn;
    }

}
