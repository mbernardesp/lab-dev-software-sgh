/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database;

import br.fai.lds.sgh.database.singleton.ConnectionSingleton;
import br.fai.lds.sgh.database.entity.Guest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        List<Guest> guestList = new ArrayList<>();

        Connection conn = null;
        
        try {

            conn = ConnectionSingleton.getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT * from guest");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Guest guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setIdRoom(rs.getLong("id_room"));
                guest.setName(rs.getString("_name"));
                guest.setAge(rs.getInt("age"));
                guest.setPhone(rs.getString("phone"));

                guestList.add(guest);
            }

            //Usando lambda
            //guestList.forEach(x -> System.out.println(x));
            for (Guest guest : guestList) {
                System.out.println(guest);
                System.out.println("");
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            
            if(!conn.isClosed()){
                conn.close();
            }

        }
        
    }
    
}
