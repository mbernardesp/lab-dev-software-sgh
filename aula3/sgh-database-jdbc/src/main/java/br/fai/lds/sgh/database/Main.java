package br.fai.lds.sgh.database;

import br.fai.lds.sgh.database.entity.Guest;
import java.sql.Connection;
import java.sql.DriverManager;
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

    public static void main(String[] args) throws SQLException {

        List<Guest> guestList = new ArrayList<>();

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sgh", "postgres", "postgres");

            PreparedStatement stmt = conn.prepareStatement("SELECT * from guest");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Guest guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setIdRoom(rs.getLong("id_room"));
                guest.setName(rs.getString("_name"));
                guest.setAge(rs.getInt("age"));
                guest.setCpf(rs.getString("cpf"));
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

            if (!conn.isClosed()) {
                conn.close();
            }

        }

    }

}
