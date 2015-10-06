/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author josediaz
 */
public class DBPointer {
    Connection conn;
    Statement stmt;

    // Constructor DBAccessor comienza aquí
    DBPointer() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NamingException {
        // Obtener conexión a base de datos
        // Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");

        // Para MySQL sería
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        // Para PostgreSQL sería
        // Class.forName("org.postgresql.Driver");
        // conn = DriverManager.getConnection("jdbc:db2:Sample","db2admin", "123");

        // Para MySQL sería
        // conn = DriverManager.getConnection("jdbc:mysql://localhost/Sample", "db2admin", "123");
        //conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbctest?" + "user=root&password=");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/farmacia?" + "user=root&password=mysqlroot");

        // Para PostgreSQL sería
        // conn = DriverManager.getConnection("jdbc:postgresql:sample","db2admin", "123");
        stmt = conn.createStatement();
    }
    // Constructor DBAccessor termina aquí

    // Método insertData comienza aquí
    void insertData() throws SQLException {
        // Insertar datos en las tablas
        // Insertar datos en la tabla products
        
        // para 4 productos
        stmt.executeUpdate("INSERT INTO products "+"(pid, pname, pprice, pcolor) "+"VALUES (1000, 'Pen', 44.50, 'Blue')");
        stmt.executeUpdate("INSERT INTO products "+"(pid, pname, pprice, pcolor) "+"VALUES (1001, 'Paper', 4.00,'White')");
        stmt.executeUpdate("INSERT INTO products "+"(pid, pname, pprice, pcolor) "+"VALUES (1002, 'Pen', 49.75, 'Green')");
        stmt.executeUpdate("INSERT INTO products "+"(pid, pname, pprice, pcolor) "+"VALUES (1003, 'Pencil', 12.00, 'Blue')");

        // Insertar datos en la tabla suppliers
        // para 2 proveedores
        stmt.executeUpdate("INSERT INTO suppliers "+"(sid, sname, sregion, sdescription) "+"VALUES (100, 'Archie', 'London', 'Deals with only paper products')");
        stmt.executeUpdate("INSERT INTO suppliers "+"(sid, sname, sregion, sdescription) "+"VALUES (101, 'Scooby', 'New Delhi', 'Deals with all products')");

        // Insertar datos en la tabla product_supplier
        stmt.executeUpdate("INSERT INTO product_supplier "+"(pid, sid, quantity) "+"VALUES (1000, 101, 100)");
        stmt.executeUpdate("INSERT INTO product_supplier "+"(pid, sid, quantity) "+"VALUES (1001, 100, 2000)");
        stmt.executeUpdate("INSERT INTO product_supplier "+"(pid, sid, quantity) "+"VALUES (1001, 101, 500)");
        stmt.executeUpdate("INSERT INTO product_supplier "+"(pid, sid, quantity) "+"VALUES (1002, 101, 400)");
        stmt.executeUpdate("INSERT INTO product_supplier "+"(pid, sid, quantity) "+"VALUES (1003, 101, 250)");

        stmt.close();
        
    }
    // Metodo insertData termina aqui

    // Metodo retrieveData comienza aqui
    void retrieveData() throws SQLException {
        
        ResultSet rs;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM products ");
        System.out.println("Products table ...\n");
        while (rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
                //"VALUES (1000, 'Pen', 44.50, 'Blue')"
        }
        // Fin del while
        System.out.println("...\n");
        
        rs = stmt.executeQuery("SELECT * FROM suppliers");
        System.out.println("Suppliers table ...\n");
        while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
                //"VALUES (100, 'Archie', 'London', 'Deals with only paper products')"
        }
        rs = stmt.executeQuery("SELECT * FROM product_supplier");
        System.out.println("\n");
        System.out.println("Product_supplier table...\n");
        while (rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                //"VALUES (1000, 101, 100)"
        }
        // Fin del while
        System.out.println("...\n");
        
        
        System.out.println("\n");
        rs.close();
        
    }
    // Método retrieveData termina aquî
}
