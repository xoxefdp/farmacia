package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
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
}