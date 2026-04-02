package ui;

import javax.swing.*;
import dao.BookingDAO;

public class BookTicket extends JFrame {

    JTextField busId, seats;

    public BookTicket(int userId) {

        setTitle("Book Ticket");
        setSize(300,200);
        setLayout(null);

        busId = new JTextField();
        seats = new JTextField();

        busId.setBounds(100,30,120,25);
        seats.setBounds(100,70,120,25);

        JButton book = new JButton("Book");
        book.setBounds(80,120,120,30);

        add(new JLabel("Bus ID")).setBounds(20,30,80,25);
        add(new JLabel("Seats")).setBounds(20,70,80,25);

        add(busId); add(seats); add(book);

        book.addActionListener(e -> {
            boolean success = BookingDAO.bookTicket(
                userId,
                Integer.parseInt(busId.getText()),
                Integer.parseInt(seats.getText())
            );

            if (success) {
                JOptionPane.showMessageDialog(this, "Booked");
            } else {
                JOptionPane.showMessageDialog(this, "Not enough seats");
            }
        });

        setVisible(true);
    }
}