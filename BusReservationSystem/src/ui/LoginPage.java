package ui;

import javax.swing.*;
import dao.UserDAO;

public class LoginPage extends JFrame {

    JTextField username;
    JPasswordField password;

    public LoginPage() {
        setTitle("Login");
        setSize(300,200);
        setLayout(null);

        username = new JTextField();
        password = new JPasswordField();

        username.setBounds(80,30,150,25);
        password.setBounds(80,70,150,25);

        JButton login = new JButton("Login");
        JButton register = new JButton("Register");

        login.setBounds(40,120,100,30);
        register.setBounds(150,120,100,30);

        add(new JLabel("User")).setBounds(20,30,60,25);
        add(new JLabel("Pass")).setBounds(20,70,60,25);

        add(username); add(password);
        add(login); add(register);

        login.addActionListener(e -> {
            int id = UserDAO.login(username.getText(), password.getText());
            if (id != -1) {
                new Dashboard(id);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }
        });

        register.addActionListener(e -> {
            UserDAO.register(username.getText(), password.getText());
            JOptionPane.showMessageDialog(this, "Registered");
        });

        setVisible(true);
    }
}