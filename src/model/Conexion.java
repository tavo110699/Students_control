/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gistavo
 * 
 */
public class Conexion {

    public static Connection codigo = null;
    public static String Url = "jdbc:mysql://localhost:3306/students_control";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            codigo = (Connection) DriverManager.getConnection(Url, "root", "");

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return codigo;
    }

}
