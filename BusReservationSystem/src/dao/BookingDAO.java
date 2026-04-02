package dao;

import java.sql.*;
import config.DBConnection;

public class BookingDAO {

    public static boolean bookTicket(int userId, int busId, int seats) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement check = con.prepareStatement(
                "SELECT available_seats FROM buses WHERE id=?"
            );
            check.setInt(1, busId);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                int available = rs.getInt("available_seats");

                if (available < seats) return false;

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bookings(user_id,bus_id,seats_booked) VALUES(?,?,?)"
                );
                ps.setInt(1, userId);
                ps.setInt(2, busId);
                ps.setInt(3, seats);
                ps.executeUpdate();

                PreparedStatement update = con.prepareStatement(
                    "UPDATE buses SET available_seats = available_seats - ? WHERE id=?"
                );
                update.setInt(1, seats);
                update.setInt(2, busId);
                update.executeUpdate();

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}