/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author josediaz
 */
public interface EntornoDB {
    
    public final static String BASE_DE_DATOS = "farmacia";
    public final static String USER = "root";
    public final static String PASS = "mysqlroot";
    public final static String DRIVER = "com.mysql.jdbc.Driver";
    public final static String URL_SERVIDOR = "localhost";
    public final static String URL_CONEXION = "jdbc:mysql://"+URL_SERVIDOR+"/"+BASE_DE_DATOS;
    
}
