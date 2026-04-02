package ui;

import javax.swing.*;
import java.sql.*;
import dao.BusDAO;

public class ViewBuses extends JFrame {

    JTextArea area;

    public ViewBuses() {
        setTitle("Buses");
        setSize(400,300);

        area = new JTextArea();
        add(new JScrollPane(area));

        load();
        setVisible(true);
    }

    void load() {
        try {
            ResultSet rs = BusDAO.getBuses();

            while (rs.next()) {
                area.append(
                    rs.getInt("id") + " | " +
                    rs.getString("bus_name") + " | " +
                    rs.getString("source") + " -> " +
                    rs.getString("destination") + "\n"
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}