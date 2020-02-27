package ru.gb.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegistrationWindow extends JFrame  {
    private static final String STR_WIN_TITLE = "Registration";


    public static void  windows() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setTitle(STR_WIN_TITLE);
        frame.setAlwaysOnTop(true);
        JPanel panelReg = new JPanel(new GridLayout(4, 2));
        JTextArea text1 = new JTextArea("Login");
        JTextArea text2 = new JTextArea("Password");
        JTextArea text3 = new JTextArea("Nickname");
        JTextField rLogin = new JTextField();
        JTextField rPassword = new JTextField();
        JTextField rNickname = new JTextField();
        panelReg.add(text1);
        panelReg.add(rLogin);
        panelReg.add(text2);
        panelReg.add(rPassword);
        panelReg.add(text3);
        panelReg.add(rNickname);
        frame.add(panelReg,BorderLayout.NORTH);
        JButton button = new JButton("Регистрация");
        JButton button1 = new JButton("Смена ника");
       button.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            Registry.Conn();
                                        } catch (ClassNotFoundException ex) {
                                            ex.printStackTrace();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                        try {
                                            Registry.CreateDB();
                                        } catch (ClassNotFoundException ex) {
                                            ex.printStackTrace();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                        try {
                                            Registry.WriteDB(rLogin.getText(),rPassword.getText(),rNickname.getText());
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }

                                        try {
                                            Registry.CloseDB();
                                        } catch (ClassNotFoundException ex) {
                                            ex.printStackTrace();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }

                                    }
                                });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Registry.Conn();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    Registry.CreateDB();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    Registry.updаtеnick(rLogin.getText(),rPassword.getText(),rNickname.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    Registry.CloseDB();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button1);
        frame.add(panel,BorderLayout.SOUTH );

        frame.setResizable(true);
        frame.setVisible(true);

   }


}
