package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
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
}
