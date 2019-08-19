/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcelo
 */
@Repository
public class GuestDao implements IGuestDao<Guest>{

    @Override
    public void create(Guest guest) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO guest (id, id_room, _name, age, phone) VALUES(nextval('guest_id_seq'), ?, ?, ?, ?)";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, guest.getIdRoom());
            stmt.setString(2, guest.getName());
            stmt.setInt(3, guest.getAge());
            stmt.setString(4, guest.getPhone());

            stmt.execute();
            
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            System.out.println(e);
        } finally {

            if (!stmt.isClosed()) {
                stmt.close();
            }

            if (!conn.isClosed()) {
                conn.close();
            }
        }
    }

    @Override
    public List<Guest> readAll() throws SQLException {

        List<Guest> guestList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * from guest");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Guest guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setIdRoom(rs.getLong("id_room"));
                guest.setName(rs.getString("_name"));
                guest.setAge(rs.getInt("age"));
                guest.setPhone(rs.getString("phone"));

                // adicionando o objeto à lista
                guestList.add(guest);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (!rs.isClosed()) {
                rs.close();
            }

            if (!stmt.isClosed()) {
                stmt.close();
            }

            if (!conn.isClosed()) {
                conn.close();
            }
        }

        return guestList;
    }

    //EXERCÍCIO EM SALA
    @Override
    public Guest readById(long id) throws SQLException {

        Guest guest = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM guest WHERE id = ?");
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setIdRoom(rs.getLong("id_room"));
                guest.setName(rs.getString("_name"));
                guest.setAge(rs.getInt("age"));
                guest.setPhone(rs.getString("phone"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (!rs.isClosed()) {
                rs.close();
            }

            if (!stmt.isClosed()) {
                stmt.close();
            }

            if (!conn.isClosed()) {
                conn.close();
            }
        }

        return guest;
    }

    //EXERCÍCIO EM SALA
    @Override
    public void update(Guest guest) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE guest SET id_room = ?, _name = ?, age = ?, phone = ? WHERE id = ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, guest.getIdRoom());
            stmt.setString(2, guest.getName());
            stmt.setInt(3, guest.getAge());
            stmt.setString(4, guest.getPhone());
            stmt.setLong(5, guest.getId());

            stmt.execute();
            conn.commit();            
        } catch (SQLException e) {
            conn.rollback();
            System.out.println(e);
        } finally {
            if (!stmt.isClosed()) {
                stmt.close();
            }

            if (!conn.isClosed()) {
                conn.close();
            }
        }
    }

    //EXERCÍCIO EM SALA
    @Override
    public void delete(Guest guest) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM guest WHERE id = ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, guest.getId());

            stmt.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            System.out.println(e);
        } finally {
            if (!stmt.isClosed()) {
                stmt.close();
            }

            if (!conn.isClosed()) {
                conn.close();
            }
        }
    }
}
