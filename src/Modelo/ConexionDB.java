/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author josediaz
 */
public class ConexionDB implements EntornoDB{
    Connection connect;
    Statement query;

    // Constructor DBAccessor comienza aquí
    ConexionDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NamingException {

        // Para PostgreSQL sería
            // Class.forName("org.postgresql.Driver");
            // conn = DriverManager.getConnection("jdbc:postgresql:sample","db2admin", "123");
        // Para MySQL sería
        
            // Class.forName("com.mysql.jdbc.Driver");
            // conn = DriverManager.getConnection("jdbc:mysql://localhost/Sample", "db2admin", "123");
            // conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbctest?" + "user=root&password=");
            // conn = DriverManager.getConnection("jdbc:mysql://localhost/farmacia?" + "user=root&password=mysqlroot");
        
        // Para ibm??? sería
            //Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
            // conn = DriverManager.getConnection("jdbc:db2:Sample","db2admin", "123");

        Class.forName(DRIVER).newInstance();
        connect = DriverManager.getConnection(URL+DB, USER, PASS);
        query = connect.createStatement();
    }

}
