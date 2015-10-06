package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
/**
 *
 * @author José Diaz
 */
public class Producto {
    private int idMedicamento, idComponente, idUnidadDeMedida;
    private double cantidadDelComponente;
    ResultSet resultado;
    
    public boolean incluirProducto(int idMedicamento, int idComponente, double cantidadDelComponente, int idUnidadDeMedida){
        /* int idMedicamento, 
        * int idComponente, 
        * double cantidadDelComponente, 
        * int idUnidadDeMedida     
        */
        boolean ok = false;
        return ok;
    }
    public boolean modificarProducto(int idMedicamento, int idComponente, double nuevCantidadDeComponente, int idNuevaUnidadDeMedida){
        /* int idMedicamento, 
        * int idComponente, 
        * double nuevCantidadDeComponente, 
        * int idNuevaUnidadDeMedida
        */
        boolean ok = false;
        return ok;
    }
    public boolean eliminarProducto(int idMedicamento, int idDelComponente){
        /* idMedicamento:Int,
        * idDelComponente:Int
        */
        boolean ok = false;
        return ok;
    }
    
    public ResultSet consultarProducto(int idMedicamento, int idComponente){
        /* idMedicamento:Int,
        * idComponente:Int     
        */
        return resultado;
    }
    public ResultSet consultarProductos(){
        return resultado;
    }
    
    
    public static void main(String args[]) {
        try {
            DBPointer dba = new DBPointer();
            dba.insertData();
            dba.retrieveData();
        }
        // Fin del bloque try

        catch (SQLException e) {
            //System.out.println(e);
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        // Fin del bloque catch SQLException

        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NamingException e) {
            //System.out.println(e);
            System.out.println("Exception: " + e.getMessage());

        }
        // Fin del bloque catch Exception
    }
}