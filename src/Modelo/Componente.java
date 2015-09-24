package Modelo;

import java.math.BigInteger;
import java.sql.ResultSet;
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
}