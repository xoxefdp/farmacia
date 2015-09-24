package Vista.Formatos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author José Diaz
 */
public class ModeloDeTabla extends DefaultTableModel{
    
    private ArrayList <Object> data;
    private Object[] nombreColumnas;
    private Object[] claseColumnas;
    
    public ModeloDeTabla(Object[] nombresCampos, Object[] claseColumnas){
        nombreColumnas = nombresCampos;
        data = new ArrayList<>();
        setColumnIdentifiers(nombreColumnas);
    }

    @Override
    public Class getColumnClass(int c) {
        return claseColumnas[c].getClass();
    }
}