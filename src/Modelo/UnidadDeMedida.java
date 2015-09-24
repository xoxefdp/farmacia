package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
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
}
