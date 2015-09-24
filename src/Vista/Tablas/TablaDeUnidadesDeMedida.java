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
public class TablaDeUnidadesDeMedida extends JPanel {

    private Object[] nombreCamposUDM, claseCamposUDM;
    private ModeloDeTabla tablaModelo;
    private JTable tabla;
    private TableColumn colNombre, colIdUnidadDeMedida;
    private Object[] datos = new Object[2];
    private JTextField campo;
    private ResultSet resultado;

    public TablaDeUnidadesDeMedida(){

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Unidad De Medida"));
        setOpaque(false);
        crearTabla();
    }

    final void crearTabla(){

        Object[] nombreCamposUDM = {"Descripcion", ""};
        Object[] claseCamposUDM = {new String(), 0};
        tablaModelo = new ModeloDeTabla(nombreCamposUDM, claseCamposUDM);
        campo = new JTextField();
        campo.setEditable(false);

        tabla = new JTable(tablaModelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(100,100));
        tabla.setFillsViewportHeight(false);
        colNombre   = tabla.getColumnModel().getColumn(0);
        colIdUnidadDeMedida = tabla.getColumnModel().getColumn(1);

        colNombre.setMinWidth(100);
        colNombre.setMaxWidth(100);
        colNombre.setCellEditor(new DefaultCellEditor(campo));
        colIdUnidadDeMedida.setMinWidth(0);
        colIdUnidadDeMedida.setMaxWidth(0);

        JScrollPane scrollPanel = new JScrollPane(tabla);
        add(scrollPanel);
    }

    public void cargarTabla(){
        int filas = tabla.getRowCount();

        for (int i = 0; i < filas; i++)
            tablaModelo.removeRow(0);

        datos[0] = "Carga inicial";
        datos[1] = "0";
        tablaModelo.addRow(datos);
    }

    public boolean agregarFila(String nombreUnidad){
        boolean salidaLimpia = false;
        datos[0] = nombreUnidad;
        datos[1] = "0";
        salidaLimpia = true;
        tablaModelo.addRow(datos);
        return salidaLimpia;
    }

    public boolean modificarFila(String nombreUnidad){
        boolean salidaLimpia = false;
        int fila = tabla.getSelectedRow();

        if (fila >= 0){
            datos[0] = nombreUnidad;
            tablaModelo.setValueAt(nombreUnidad, fila, 0);
            salidaLimpia = true;
        }
        return salidaLimpia;
    }

    public boolean eliminarFila(){
        int fila = tabla.getSelectedRow();
        boolean salidaLimpia = false;
        if (fila >= 0){
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro quiere eliminar a: " + tablaModelo.getValueAt(fila, 0));
            if (respuesta == JOptionPane.OK_OPTION){
                tablaModelo.removeRow(fila);
                salidaLimpia = true;
            }
        }
        return salidaLimpia;
    }

    public String obtenerDescripcion(){
        int fila = tabla.getSelectedRow();
        if (fila >= 0)
            return (String)tabla.getValueAt(fila, 0);
        else
            return null;
    }

    public String obtenerId(){
        int fila = tabla.getSelectedRow();
        if (fila >= 0)
            return (String)tabla.getValueAt(fila, 1);
        else
            return null;
    }
}