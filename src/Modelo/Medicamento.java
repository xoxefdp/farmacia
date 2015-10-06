package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
/**
 *
 * @author José Diaz
 */
public class Medicamento {
    private BigInteger idMedicamento;
    private int idLaboratorio;
    private String nombreComercial;
    private ResultSet result_med;
    
    public boolean incluirMedicamento(String nombreMedicamento, int IdLaboratorio){ 
         boolean ok = false;
    return ok;   
    }
    
    public boolean modificarMedicamento(String nuevoNombre, int idLaboratorio){
            boolean ok = false;
    return ok;
    }
    public boolean eliminarMedicamento(int idMedicamento){
    boolean ok = false;
    return ok;
    }
    public ResultSet consultarMedicamento(int idMedicamento){
        return result_med;
    }
    public ResultSet consultarMedicamentos(){
        return result_med;
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
