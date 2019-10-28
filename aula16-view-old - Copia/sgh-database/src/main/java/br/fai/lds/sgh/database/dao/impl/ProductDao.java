/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao.impl;

import br.fai.lds.sgh.database.connection.ConnectionFactory;
import br.fai.lds.sgh.database.dao.IProductDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.fai.lds.sgh.database.entity.Product;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcelo
 */
@Component
public class ProductDao implements IProductDao {

    @Override
    public void create(Product product) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO product (id, _code, _name) VALUES(nextval('product_id_seq'), ?, ?)";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getCode());
            stmt.setString(2, product.getName());

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
    public List<Product> readAll() {

        List<Product> productList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM product");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setCode(rs.getString("_code"));
                product.setName(rs.getString("_name"));

                productList.add(product);
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

        return productList;
    }

    @Override
    public Product readById(Long id) {

        Product product = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setId(rs.getLong("id"));
                product.setCode(rs.getString("_code"));
                product.setName(rs.getString("_name"));
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

        return product;
    }

    @Override
    public void update(Product product) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE product SET _code = ?, _name = ? WHERE id = ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getCode());
            stmt.setString(2, product.getName());
            stmt.setLong(3, product.getId());

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

        String sql = "DELETE FROM product WHERE id = ?";

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
    public List<Product> readByName(String name) {

        List<Product> productList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            if (name != null && !name.isEmpty()) {

                stmt = conn.prepareStatement("SELECT * FROM product WHERE _name LIKE ?");
                stmt.setString(1, '%' + name + '%');
            } else {

                stmt = conn.prepareStatement("SELECT * FROM product");
            }

            rs = stmt.executeQuery();

            while (rs.next()) {

                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setCode(rs.getString("_code"));
                product.setName(rs.getString("_name"));

                productList.add(product);
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

        return productList;

    }
}
