package br.fai.lds.sgh.database.dao.impl;

import br.fai.lds.sgh.database.connection.ConnectionFactory;
import br.fai.lds.sgh.database.dao.IGuestDao;
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
public class GuestDao implements IGuestDao {

    private final Connection conn;
    
    public GuestDao() {

        conn = ConnectionFactory.getConnection();
    }

    public void closeConnection() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void create(Guest guest) {
        String sql = "INSERT INTO guest (id, id_room, _name, age, cpf, phone) VALUES(nextval('guest_id_seq'), ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, guest.getIdRoom());
            stmt.setString(2, guest.getName());
            stmt.setInt(3, guest.getAge());
            stmt.setString(4, guest.getCpf());
            stmt.setString(5, guest.getPhone());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Guest> readAll() {

        List<Guest> guestList = new ArrayList<Guest>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * from guest");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Guest guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setIdRoom(rs.getLong("id_room"));
                guest.setName(rs.getString("_name"));
                guest.setAge(rs.getInt("age"));
                guest.setCpf(rs.getString("cpf"));
                guest.setPhone(rs.getString("phone"));

                // adicionando o objeto à lista
                guestList.add(guest);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return guestList;
    }

    //EXERCÍCIO EM SALA
    @Override
    public Guest readById(long id) {

        Guest guest = null;

        PreparedStatement stmt;
           
        try {
            stmt = conn.prepareStatement("SELECT * FROM guest WHERE id = ?");
            stmt.setLong(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setIdRoom(rs.getLong("id_room"));
                guest.setName(rs.getString("_name"));
                guest.setAge(rs.getInt("age"));
                guest.setCpf(rs.getString("cpf"));
                guest.setPhone(rs.getString("phone"));
            }

            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return guest;
    }

    //EXERCÍCIO EM SALA
    @Override
    public void update(Guest guest) {

        String sql = "UPDATE guest SET id_room = ?, _name = ?, age = ?, cpf = ?, phone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, guest.getIdRoom());
            stmt.setString(2, guest.getName());
            stmt.setInt(3, guest.getAge());
            stmt.setString(4, guest.getPhone());
            stmt.setString(5, guest.getCpf());
            stmt.setLong(6, guest.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    //EXERCÍCIO EM SALA
    @Override
    public void delete(Guest guest) {

        String sql = "DELETE FROM guest WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, guest.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        
    }

}
