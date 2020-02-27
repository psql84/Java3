package ru.gb.chat.client;

import java.sql.*;

public class Registry {
    public static Connection conn;
    public static Statement statmt;

    public static void Conn () throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:chat.db");

        System.out.println("База Подключена!");

    }
    public static void CreateDB () throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('login' STRING, 'password' STRING, 'nickname' STRING);");

        System.out.println("Таблица создана или уже существует.");

    }
    public static void WriteDB (String login,String password,String nickname) throws SQLException
    {
        statmt.execute("INSERT INTO 'users' ('login', 'password','nickname') VALUES ('"+ login +"', '"+ password +"', '"+ nickname +"'); ");

        System.out.println("Таблица заполнена");
    }
    public static void updаtеnick(String login,String password,String nickname) throws SQLException {
        statmt.execute("UPDATE users SET nickname = ' "+nickname+"' " +
                "WHERE login = '"+login+"' password = '"+password+"';");
    }
    public static void CloseDB () throws ClassNotFoundException, SQLException
    {
        statmt.close();
        conn.close();
        System.out.println("Соединения закрыты");
    }

}
