/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao.impl;

import br.fai.lds.sgh.database.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.fai.lds.sgh.database.dao.IRoomDao;
import br.fai.lds.sgh.database.entity.Room;
import br.fai.lds.sgh.database.enumerator.EStatus;
import br.fai.lds.sgh.database.enumerator.EType;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcelo
 */
@Component
public class RoomDao implements IRoomDao {

    @Override
    public void create(Room room) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO room (id, num, _type, _status, date_checkin, date_checkout) VALUES(nextval('room_id_seq'), ?, ?, ?, ?, ?)";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, room.getNum());
            stmt.setString(2, room.getType().get());
            stmt.setString(3, room.getStatus().get());
            stmt.setTimestamp(4, room.getDateCheckIn());
            stmt.setTimestamp(5, room.getDateCheckOut());

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
    public List<Room> readAll() {

        List<Room> roomList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM room");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Room room = new Room();
                room.setId(rs.getLong("id"));
                room.setNum(rs.getString("num"));
                room.setType(EType.valueOf(rs.getString("_type")));
                room.setStatus(EStatus.valueOf(rs.getString("_status")));
                room.setDateCheckIn(rs.getTimestamp("date_checkin"));
                room.setDateCheckOut(rs.getTimestamp("date_checkout"));

                roomList.add(room);
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

        return roomList;
    }

    @Override
    public Room readById(Long id) {

        Room room = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM room WHERE id = ?");
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                room = new Room();
                room.setId(rs.getLong("id"));
                room.setNum(rs.getString("num"));
                room.setType(EType.valueOf(rs.getString("_type")));
                room.setStatus(EStatus.valueOf(rs.getString("_status")));
                room.setDateCheckIn(rs.getTimestamp("date_checkin"));
                room.setDateCheckOut(rs.getTimestamp("date_checkout"));
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

        return room;
    }

    @Override
    public void update(Room room) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE room SET num = ?, _type = ?, _status = ?, date_checkin = ?, date_checkout = ? WHERE id = ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, room.getNum());
            stmt.setString(2, room.getType().get());
            stmt.setString(3, room.getStatus().get());
            stmt.setTimestamp(4, room.getDateCheckIn());
            stmt.setTimestamp(5, room.getDateCheckOut());
            stmt.setLong(6, room.getId());

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

        String sql = "DELETE FROM room WHERE id = ?";

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
    public List<Room> readByNum(String num) {

        List<Room> roomList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            if (num != null && !num.isEmpty()) {

                stmt = conn.prepareStatement("SELECT * FROM room WHERE num LIKE ?");
                stmt.setString(1, '%' + num + '%');
            } else {

                stmt = conn.prepareStatement("SELECT * FROM room");
            }

            rs = stmt.executeQuery();

            while (rs.next()) {

                Room room = new Room();
                room.setId(rs.getLong("id"));
                room.setNum(rs.getString("num"));
                room.setType(EType.valueOf(rs.getString("_type")));
                room.setStatus(EStatus.valueOf(rs.getString("_status")));
                room.setDateCheckIn(rs.getTimestamp("date_checkin"));
                room.setDateCheckOut(rs.getTimestamp("date_checkout"));

                roomList.add(room);
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

        return roomList;

    }
}
