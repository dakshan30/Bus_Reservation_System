package dao;

import java.sql.*;
import config.DBConnection;

public class BusDAO {

    public static ResultSet getBuses() {
        try {
            Connection con = DBConnection.getConnection();
            return con.createStatement().executeQuery("SELECT * FROM buses");
        } catch (Exception e) {
            return null;
        }
    }
}