package Vista.Tablas;

import Vista.Formatos.ModeloDeTabla;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
/**
 *
 * @author José Diaz
 */
public class TablaDeComponentes extends JPanel{

    private Object[] nombreCamposComp, claseCamposComp;
    private ModeloDeTabla tablaCompDobleColumna;
    private JTable tablaComp;
    private TableColumn colNombre, colIdComponente;
    private Object[] datosComp = new Object[2];
    private JTextField campoComp;
    private ResultSet resultado;

    public TablaDeComponentes(){

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Componentes"));
        setOpaque(false);
        crearTabla();
    }

    final void crearTabla(){

        Object[] nombreCamposComp = {"Descripcion", ""};
        Object[] claseCamposComp = {new String(), 0};
        
        tablaCompDobleColumna = new ModeloDeTabla(nombreCamposComp, claseCamposComp);
        campoComp = new JTextField();
        campoComp.setEditable(false);

        tablaComp = new JTable(tablaCompDobleColumna);
        tablaComp.setPreferredScrollableViewportSize(new Dimension(100,100));
        tablaComp.setFillsViewportHeight(false);
        colNombre   = tablaComp.getColumnModel().getColumn(0);
        colIdComponente = tablaComp.getColumnModel().getColumn(1);

        colNombre.setMinWidth(100);
        colNombre.setMaxWidth(100);
        colNombre.setCellEditor(new DefaultCellEditor(campoComp));
        colIdComponente.setMinWidth(0);
        colIdComponente.setMaxWidth(0);

        JScrollPane scrollPanel = new JScrollPane(tablaComp);
        add(scrollPanel);
    }

    public void cargarTabla(){
        int filas = tablaComp.getRowCount();

        for (int i = 0; i < filas; i++)
            tablaCompDobleColumna.removeRow(0);

        datosComp[0] = "Carga inicial";
        datosComp[1] = "0";
        tablaCompDobleColumna.addRow(datosComp);
    } 

    public boolean agregarFila(String nombreComponente){
        boolean salidaLimpia = false;
        datosComp[0] = nombreComponente;
        datosComp[1] = "0";
        salidaLimpia = true;
        tablaCompDobleColumna.addRow(datosComp);
        return salidaLimpia;
    }

    public boolean modificarFila(String nombreComponente){
        boolean salidaLimpia = false;
        int fila = tablaComp.getSelectedRow();

        if (fila >= 0){
            datosComp[0] = nombreComponente;
            tablaCompDobleColumna.setValueAt(nombreComponente, fila, 0);
            salidaLimpia = true;
        }
        return salidaLimpia;
    }  

    public boolean eliminarFila(){
        int fila = tablaComp.getSelectedRow();
        boolean salidaLimpia = false;
        if (fila >= 0){
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro quiere eliminar a: " + tablaCompDobleColumna.getValueAt(fila, 0));
            if (respuesta == JOptionPane.OK_OPTION){
                tablaCompDobleColumna.removeRow(fila);
                salidaLimpia = true;
            }
        }
        return salidaLimpia;
    }

    public String obtenerDescripcion(){
        int fila = tablaComp.getSelectedRow();
        if (fila >= 0)
            return (String)tablaComp.getValueAt(fila, 0);
        else
            return null;
    }

    public String obtenerId(){
        int fila = tablaComp.getSelectedRow();
        if (fila >= 0)
            return (String)tablaComp.getValueAt(fila, 1);
        else
            return null;
    }
}