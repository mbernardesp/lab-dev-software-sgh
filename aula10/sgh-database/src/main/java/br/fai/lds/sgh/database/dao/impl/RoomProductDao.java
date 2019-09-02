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
import br.fai.lds.sgh.database.dao.IRoomProductDao;
import br.fai.lds.sgh.database.entity.RoomProduct;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcelo
 */
@Component
public class RoomProductDao implements IRoomProductDao {

    @Override
    public void create(RoomProduct roomProduct) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO room (id_room, id_product, amount) VALUES(?, ?, ?)";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, roomProduct.getId_room());
            stmt.setLong(2, roomProduct.getId_product());
            stmt.setInt(3, roomProduct.getAmount());

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
    public List<RoomProduct> readAll() {

        List<RoomProduct> roomProductList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * from room_product");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                RoomProduct roomProduct = new RoomProduct();
                roomProduct.setId_room(rs.getLong("id_room"));
                roomProduct.setId_product(rs.getLong("id_product"));
                roomProduct.setAmount(rs.getInt("amount"));                

                roomProductList.add(roomProduct);
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

        return roomProductList;
    }

    @Override
    public RoomProduct readById(long idRoom, long idProduct) {

        RoomProduct roomProduct = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM room_product WHERE id_room = ? AND id_product = ?");
            stmt.setLong(1, idRoom);
            stmt.setLong(2, idProduct);

            rs = stmt.executeQuery();

            if (rs.next()) {
                roomProduct = new RoomProduct();
                roomProduct.setId_room(rs.getLong("id_room"));
                roomProduct.setId_product(rs.getLong("id_product"));
                roomProduct.setAmount(rs.getInt("amount"));                
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

        return roomProduct;
    }

    @Override
    public void update(RoomProduct roomProduct) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE room_product SET amount = ? WHERE id_room = ? AND id_product = ?";
       
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roomProduct.getAmount());
            stmt.setLong(2, roomProduct.getId_room());
            stmt.setLong(3, roomProduct.getId_product());

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
    public void delete(long idRoom, long idProduct) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM room_product WHERE id_room = ? AND id_product = ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idRoom);
            stmt.setLong(2, idProduct);

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
}
