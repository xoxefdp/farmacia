package Modelo;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author José Diaz
 */
public class Farmacia {
    
    public static void main(String[] args){
        try {
            ConexionDB dba = new ConexionDB();
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
    }
}
