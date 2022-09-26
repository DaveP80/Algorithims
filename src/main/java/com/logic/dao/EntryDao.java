package com.logic.dao;

import com.logic.model.Entry;
import com.logic.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntryDao implements IEntryDao {
    @Override
    public int insert(Entry a) {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "INSERT INTO fibonacci (NodeValue) values (?) RETURNING fibonacci.id";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, String.valueOf(a.toString()));

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null) {

                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    @Override
    public void delete() {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "DROP TABLE IF EXISTS fibonacci";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int create() {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "CREATE TABLE fibonacci (id SERIAL PRIMARY KEY, NodeValue varchar)";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    @Override
    public int read() {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "SELECT * FROM fibonacci";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs;
            if ((rs = stmt.executeQuery()) != null) {
                //if we return data, we can iterate over it
                if (!rs.next()) {
                    return -2;
                }
                return rs.getInt(1);
            }

        } catch (SQLException e) {

            return 0;
        }
        return -1;
    }

    public int storeValues(Entry a) {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "INSERT INTO store_sequence (NodeValue) values (?) RETURNING store_sequence.id";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, String.valueOf(a.toString()));

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null) {

                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public int readStorage() {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "SELECT * FROM store_sequence";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs;
            if ((rs = stmt.executeQuery()) != null) {
                //if we return data, we can iterate over it
                if (!rs.next()) {
                    return -2;
                }

                return rs.getInt(1);
            }

        } catch (SQLException e) {
            return -1;
        }
        return 0;
    }

    public int deleteStorage() {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "DROP TABLE IF EXISTS store_sequence";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int createStorage() {
        Connection conn = ConnectionUtil.getConnection();

        String sql = "CREATE TABLE store_sequence (id SERIAL PRIMARY KEY, NodeValue varchar)";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}

