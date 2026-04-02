package ui;

import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard(int userId) {

        setTitle("Dashboard");
        setSize(300,250);
        setLayout(null);

        JButton view = new JButton("View Buses");
        JButton book = new JButton("Book Ticket");

        view.setBounds(50,50,200,30);
        book.setBounds(50,100,200,30);

        add(view); add(book);

        view.addActionListener(e -> new ViewBuses());
        book.addActionListener(e -> new BookTicket(userId));

        setVisible(true);
    }
}