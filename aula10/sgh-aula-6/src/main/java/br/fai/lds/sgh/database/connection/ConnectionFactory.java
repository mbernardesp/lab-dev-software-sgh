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

    private static final String URL = "jdbc:postgresql://localhost:5432/sgh";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return conn;
    }

}
