/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.hacktown.database.dao.impl;

import br.fai.lds.hacktown.database.connection.ConnectionFactory;
import br.fai.lds.hacktown.database.entity.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.fai.lds.hacktown.database.dao.IScheduleDao;
import br.fai.lds.hacktown.database.enumerator.EType;

/**
 *
 * @author Marcelo
 */
@Repository
public class ScheduleDao implements IScheduleDao {

    @Override
    public void create(Schedule schedule) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO schedule (id, _type, theme, speaker, place, date_time) VALUES(nextval('schedule_id_seq'), ?, ?, ?, ?, ?)";
        
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, schedule.getType().get());
            stmt.setString(2, schedule.getTheme());
            stmt.setString(3, schedule.getSpeaker());
            stmt.setString(4, schedule.getPlace());
            stmt.setTimestamp(5, schedule.getDateTime());

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
    public List<Schedule> readAll() {

        List<Schedule> scheduleList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * from schedule");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setType(EType.valueOf(rs.getString("_type")));
                schedule.setTheme(rs.getString("theme"));
                schedule.setSpeaker(rs.getString("speaker"));
                schedule.setPlace(rs.getString("place"));                
                schedule.setDateTime(rs.getTimestamp("date_time"));

                scheduleList.add(schedule);
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

        return scheduleList;
    }

    @Override
    public Schedule readById(Long id) {

        Schedule schedule = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM schedule WHERE id = ?");
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                
                schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setType(EType.valueOf(rs.getString("_type")));
                schedule.setTheme(rs.getString("theme"));
                schedule.setSpeaker(rs.getString("speaker"));
                schedule.setPlace(rs.getString("place"));                
                schedule.setDateTime(rs.getTimestamp("date_time"));
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

        return schedule;
    }

    @Override
    public void update(Schedule schedule) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE schedule SET _type = ?, theme = ?, speaker = ?, place = ?, date_time = ? WHERE id = ?";
        
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, schedule.getType().get());
            stmt.setString(2, schedule.getTheme());
            stmt.setString(3, schedule.getSpeaker());
            stmt.setString(4, schedule.getPlace());
            stmt.setTimestamp(5, schedule.getDateTime());
            stmt.setLong(6, schedule.getId());

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

        String sql = "DELETE FROM schedule WHERE id = ?";

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
}
