/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.database.dao.impl;

import br.fai.lds.sgh.database.connection.ConnectionFactory;
import br.fai.lds.sgh.database.entity.User;
import br.fai.lds.sgh.database.enumerator.ELevel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.fai.lds.sgh.database.dao.IUserDao;

/**
 *
 * @author Marcelo
 */
@Repository
public class UserDao implements IUserDao {

    @Override
    public void create(User user) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO users(id, _user, pass, _name, email, _level) VALUES (nextval('users_id_seq'), ?, ?, ?, ?, ?)";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUser());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getName().toUpperCase());
            stmt.setString(4, user.getEmail().toLowerCase());
            stmt.setString(5, user.getLevel().get());

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
    public List<User> readAll() {

        List<User> userList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM users");

            rs = stmt.executeQuery();

            while (rs.next()) {

                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUser(rs.getString("_user"));
                user.setPass(rs.getString("pass"));
                user.setName(rs.getString("_name"));
                user.setEmail(rs.getString("email"));
                user.setLevel(ELevel.valueOf(rs.getString("_level")));

                userList.add(user);
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

        return userList;
    }

    @Override
    public User readById(Long id) {

        User user = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUser(rs.getString("_user"));
                user.setPass(rs.getString("pass"));
                user.setName(rs.getString("_name"));
                user.setEmail(rs.getString("email"));
                user.setLevel(ELevel.valueOf(rs.getString("_level")));
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

        return user;
    }

    @Override
    public User readByUserName(String userName) {

        User user = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM users WHERE _user = ?");
            stmt.setString(1, userName);

            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUser(rs.getString("_user"));
                user.setPass(rs.getString("pass"));
                user.setName(rs.getString("_name"));
                user.setEmail(rs.getString("email"));
                user.setLevel(ELevel.valueOf(rs.getString("_level")));
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

        return user;
    }

    @Override
    public void update(User user) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE users SET _user = ?, pass = ?, _name = ?, email = ?, _level = ? WHERE id ?";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getUser());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getName().toUpperCase());
            stmt.setString(4, user.getEmail().toLowerCase());
            stmt.setString(5, user.getLevel().get());
            stmt.setLong(6, user.getId());

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

        String sql = "DELETE FROM users WHERE id = ?";

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
    public List<User> readByName(String name) {

        List<User> userList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            if (name != null && !name.isEmpty()) {

                stmt = conn.prepareStatement("SELECT * FROM users WHERE _name LIKE ?");
                stmt.setString(1, '%' + name.toUpperCase() + '%');

            } else {

                stmt = conn.prepareStatement("SELECT * FROM users");
            }

            rs = stmt.executeQuery();

            while (rs.next()) {

                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUser(rs.getString("_user"));
                user.setPass(rs.getString("pass"));
                user.setName(rs.getString("_name"));
                user.setEmail(rs.getString("email"));
                user.setLevel(ELevel.valueOf(rs.getString("_level")));

                userList.add(user);
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

        return userList;

    }

    @Override
    public User readByUserNameAndPass(String userName, String pass) {
        
        User user = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM users WHERE _user = ? AND pass = ?");
            stmt.setString(1, userName);
            stmt.setString(2, pass);

            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUser(rs.getString("_user"));
                user.setPass(rs.getString("pass"));
                user.setName(rs.getString("_name"));
                user.setEmail(rs.getString("email"));
                user.setLevel(ELevel.valueOf(rs.getString("_level")));
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

        return user;

    }

}
