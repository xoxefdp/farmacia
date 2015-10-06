package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
/**
 *
 * @author José Diaz
 */
public class Componente {
    private BigInteger idComponente;
    private String nombreDelComponente;
    private ResultSet result_comp;
    
    public boolean incluirComponente(String nombreComponente){
        boolean ok = false;
        return ok;
    }
    public boolean modificarComponente(String nuevoComponente){
        boolean ok = false;
        return ok;
    }
    public boolean eliminarComponente(int idComponente){
        boolean ok = false;
        return ok;
    }
    public ResultSet consultarComponente(int idComponente){
        return result_comp;
    }
    public ResultSet consultarComponentes(){
        return result_comp;
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