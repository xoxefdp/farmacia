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
public class TablaDeLaboratorios extends JPanel{

    private Object[] nombreCamposLab, claseCamposLab;
    private ModeloDeTabla tablaLabDobleColumna;
    private JTable tablaLab;
    private TableColumn colDescripcion, colIdLaboratorio;
    private Object[] datosLab = new Object[2];
    private JTextField campoLab;
    private ResultSet resultado;

    public TablaDeLaboratorios(){

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Laboratorios"));
        setOpaque(false);
        crearTabla();
    }

    final void crearTabla(){

        Object[] nombreCamposLab = {"Descripcion", ""};
        Object[] claseCamposLab = {new String(), 0};
        tablaLabDobleColumna = new ModeloDeTabla(nombreCamposLab, claseCamposLab);
        campoLab = new JTextField();
        campoLab.setEditable(false);

        tablaLab = new JTable(tablaLabDobleColumna);
        tablaLab.setPreferredScrollableViewportSize(new Dimension(100,100));
        tablaLab.setFillsViewportHeight(false);
        colDescripcion   = tablaLab.getColumnModel().getColumn(0);
        colIdLaboratorio = tablaLab.getColumnModel().getColumn(1);

        colDescripcion.setMinWidth(100);
        colDescripcion.setMaxWidth(100);
        colDescripcion.setCellEditor(new DefaultCellEditor(campoLab));
        colIdLaboratorio.setMinWidth(0);
        colIdLaboratorio.setMaxWidth(0);

        JScrollPane scrollPanel = new JScrollPane(tablaLab);
        add(scrollPanel);
    }

    public void cargarTabla(){
        int filas = tablaLab.getRowCount();

        for (int i = 0; i < filas; i++)
            tablaLabDobleColumna.removeRow(0);

        datosLab[0] = "Carga inicial";
        datosLab[1] = "0";
        tablaLabDobleColumna.addRow(datosLab);
    }

    public boolean agregarFila(String nombreLaboratorio){
        boolean salidaLimpia = false;
        datosLab[0] = nombreLaboratorio;
        datosLab[1] = "0";
        salidaLimpia = true;
        tablaLabDobleColumna.addRow(datosLab);
        return salidaLimpia;
    }

    public boolean modificarFila(String nombreLaboratorio){
        boolean salidaLimpia = false;
        int fila = tablaLab.getSelectedRow();

        if (fila >= 0){
            datosLab[0] = nombreLaboratorio;
            tablaLabDobleColumna.setValueAt(nombreLaboratorio, fila, 0);
            salidaLimpia = true;
        }
        return salidaLimpia;
    }

    public boolean eliminarFila(){
        int fila = tablaLab.getSelectedRow();
        boolean salidaLimpia = false;
        if (fila >= 0){
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro quiere eliminar a: " + tablaLabDobleColumna.getValueAt(fila, 0));
            if (respuesta == JOptionPane.OK_OPTION){
                tablaLabDobleColumna.removeRow(fila);
                salidaLimpia = true;
            }
        }
        return salidaLimpia;
    }

    public String obtenerDescripcion(){
        int fila = tablaLab.getSelectedRow();
        if (fila >= 0)
            return (String)tablaLab.getValueAt(fila, 0);
        else
            return null;
    }

    public String obtenerId(){
        int fila = tablaLab.getSelectedRow();
        if (fila >= 0)
            return (String)tablaLab.getValueAt(fila, 1);
        else
            return null;
    }
}