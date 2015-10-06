package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
/**
 *
 * @author José Diaz
 */
public class Laboratorio {
    private BigInteger idLaboratorio;
    private String nombreDelLaboratorio;
    ResultSet result_lab;
    
    public boolean incluirLaboratorio(String nombreLaboratorio){
        boolean ok = false;
        return ok;
    } 
    public boolean modificarLaboratorio(int idLaboratorio, String nuevoNombre){
        boolean ok = false;
        return ok;
    }
    public boolean eliminarLaboratorio(int idLaboratorio){
        boolean ok = false;
        return ok;
    }
    public ResultSet consultarLaboratorio(int idLaboratorio){        
        return result_lab;
    }
    public ResultSet consultarLaboratorios(){        
        return result_lab;
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