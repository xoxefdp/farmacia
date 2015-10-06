package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
/**
 *
 * @author José Diaz
 */
public class UnidadDeMedida {
    
    private BigInteger idDeUnidadDeMedida;
    private String nombreDeLaUnidadDeMedida;
    private ResultSet result_udm;

    public boolean incluirUnidadDeMedida(String nombreDeLaUnidadDeMedida){
	boolean ok = false;
    return ok;
    }
    
    public boolean modificarUnidadDeMedida(int idDeUnidadDeMedida, String nuevoNombre){
	boolean ok = false;
    return ok;
    }
    
    public boolean eliminarLaboratorio(int idDeUnidadDeMedida){
    boolean ok = false;
    return ok;
    }
    
    public ResultSet consultarLaboratorio(int idDeUnidadDeMedida){
        return result_udm;
    }
        
    public ResultSet consultarLaboratorios(){
	return result_udm;
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
