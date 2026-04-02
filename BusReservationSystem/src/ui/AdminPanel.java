package ui;

import javax.swing.*;
import java.sql.*;
import config.DBConnection;

public class AdminPanel extends JFrame {

    JTextField name, src, dest, seats;

    public AdminPanel() {

        setTitle("Admin");
        setSize(300,300);
        setLayout(null);

        name = new JTextField(); name.setBounds(100,20,150,25);
        src = new JTextField(); src.setBounds(100,60,150,25);
        dest = new JTextField(); dest.setBounds(100,100,150,25);
        seats = new JTextField(); seats.setBounds(100,140,150,25);

        JButton add = new JButton("Add");
        add.setBounds(80,200,120,30);

        add(new JLabel("Name")).setBounds(20,20,80,25);
        add(new JLabel("Source")).setBounds(20,60,80,25);
        add(new JLabel("Dest")).setBounds(20,100,80,25);
        add(new JLabel("Seats")).setBounds(20,140,80,25);

        add(name); add(src); add(dest); add(seats); add(add);

        add.addActionListener(e -> addBus());

        setVisible(true);
    }

    void addBus() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO buses(bus_name,source,destination,total_seats,available_seats) VALUES(?,?,?,?,?)"
            );

            int s = Integer.parseInt(seats.getText());

            ps.setString(1, name.getText());
            ps.setString(2, src.getText());
            ps.setString(3, dest.getText());
            ps.setInt(4, s);
            ps.setInt(5, s);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Bus Added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}