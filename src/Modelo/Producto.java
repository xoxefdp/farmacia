package Modelo;

import java.sql.ResultSet;
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
}