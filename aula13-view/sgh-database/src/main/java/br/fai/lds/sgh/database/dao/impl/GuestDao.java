/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao.impl;

import br.fai.lds.sgh.database.connection.ConnectionFactory;
import br.fai.lds.sgh.database.entity.Guest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.fai.lds.sgh.database.dao.IGuestDao;
import java.sql.Types;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcelo
 */
@Repository
public class GuestDao implements IGuestDao {

    @Override
    public void create(Guest guest) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO guest (id, id_room, _name, age, cpf, phone) VALUES(nextval('guest_id_seq'), ?, ?, ?, ?, ?)";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setNull(1, Types.BIGINT);
            stmt.setString(2, guest.getName().toUpperCase());
            stmt.setInt(3, guest.getAge());
            stmt.setString(4, guest.getCpf());
            stmt.setString(5, guest.getPhone());

            stmt.execute();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                conn.rollback();
            } catch (SQLException ex) {
            }

        } finally {

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public List<Guest> readAll() {

        List<Guest> guestList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM guest");

            rs = stmt.executeQuery();

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

        } catch (SQLException ex) {
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return guestList;
    }

    @Override
    public Guest readById(Long id) {

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
                guest.setCpf(rs.getString("cpf"));
                guest.setPhone(rs.getString("phone"));
            }

        } catch (SQLException ex) {
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return guest;
    }

    @Override
    public void update(Guest guest) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE guest SET id_room = ?, _name = ?, age = ?, cpf = ?, phone = ? WHERE id = ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);

            if (guest.getIdRoom() != null) {

                stmt.setLong(1, guest.getIdRoom());
            } else {

                stmt.setNull(1, Types.BIGINT);
            }

            stmt.setString(2, guest.getName().toUpperCase());
            stmt.setInt(3, guest.getAge());
            stmt.setString(4, guest.getCpf());
            stmt.setString(5, guest.getPhone());
            stmt.setLong(6, guest.getId());

            stmt.execute();
            conn.commit();
        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
            }

        } finally {

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public void delete(Long id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM guest WHERE id = ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);

            stmt.execute();
            conn.commit();
        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
            }

        } finally {
            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public List<Guest> readByName(String name) {

        List<Guest> guestList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            if (name != null && !name.isEmpty()) {

                stmt = conn.prepareStatement("SELECT * FROM guest WHERE _name LIKE ?");
                stmt.setString(1, '%' + name.toUpperCase() + '%');
                
            } else {

                stmt = conn.prepareStatement("SELECT * FROM guest");
            }

            rs = stmt.executeQuery();

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

        } catch (SQLException ex) {
            
            ex.printStackTrace();
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return guestList;

    }
}
