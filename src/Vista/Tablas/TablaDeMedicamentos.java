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
public class TablaDeMedicamentos extends JPanel{

    private Object[] nombreCamposMed, claseCamposMed;
    private ModeloDeTabla tablaMedCuadrupleColumna;
    private JTable tablaMed;
    private TableColumn columNombre, columNombreLaboratorio, columIdLaboratorio, columIdMedicamento;
    private Object[] datos = new Object[4];
    private JTextField campoMed;
    private ResultSet resultado;

    public TablaDeMedicamentos(){

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Medicamento"));
        setOpaque(false);
        crearTabla();
    }

    final void crearTabla(){

        Object[] nombreCamposMed = {"Nombre", "Laboratorio", "", ""};
        Object[] claseCamposMed = {new String(), new String(), 0, 0};
        tablaMedCuadrupleColumna = new ModeloDeTabla(nombreCamposMed, claseCamposMed);
        campoMed = new JTextField();
        campoMed.setEditable(false);

        tablaMed = new JTable(tablaMedCuadrupleColumna);
        tablaMed.setPreferredScrollableViewportSize(new Dimension(200,100));
        tablaMed.setFillsViewportHeight(false);
        columNombre   = tablaMed.getColumnModel().getColumn(0);
        columNombreLaboratorio = tablaMed.getColumnModel().getColumn(1);
        columIdLaboratorio = tablaMed.getColumnModel().getColumn(2);
        columIdMedicamento = tablaMed.getColumnModel().getColumn(3);

        columNombre.setMinWidth(100);
        columNombre.setMaxWidth(100);
        columNombre.setCellEditor(new DefaultCellEditor(campoMed));
        columNombreLaboratorio.setMinWidth(100);
        columNombreLaboratorio.setMaxWidth(100);
        columNombreLaboratorio.setCellEditor(new DefaultCellEditor(campoMed));

        columIdLaboratorio.setMinWidth(0);
        columIdLaboratorio.setMaxWidth(0);
        columIdMedicamento.setMinWidth(0);
        columIdMedicamento.setMaxWidth(0);

        JScrollPane scrollPanel = new JScrollPane(tablaMed);
        add(scrollPanel);
    }

    public void cargarTabla(){
        int filas = tablaMed.getRowCount();

        for (int i = 0; i < filas; i++)
            tablaMedCuadrupleColumna.removeRow(0);

        datos[0] = "Carga inicial";
        datos[1] = "Carga inicial";
        datos[2] = "0";
        datos[3] = "0";
        tablaMedCuadrupleColumna.addRow(datos);
    }

    public boolean agregarFila(String nombreMedicamento){
        boolean salidaLimpia = false;
        datos[0] = nombreMedicamento;
        datos[1] = "0";
        datos[2] = "0";
        datos[3] = "0";
        salidaLimpia = true;
        tablaMedCuadrupleColumna.addRow(datos);
        return salidaLimpia;
    }

    public boolean modificarFila(String nombreMedicamento){
        boolean salidaLimpia = false;
        int fila = tablaMed.getSelectedRow();

        if (fila >= 0){
            datos[0] = nombreMedicamento;
            tablaMedCuadrupleColumna.setValueAt(nombreMedicamento, fila, 0);
            salidaLimpia = true;
        }
        return salidaLimpia;
    }

    public boolean eliminarFila(){
        int fila = tablaMed.getSelectedRow();
        boolean salidaLimpia = false;
        if (fila >= 0){
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro quiere eliminar a: " + tablaMedCuadrupleColumna.getValueAt(fila, 0));
            if (respuesta == JOptionPane.OK_OPTION){
                tablaMedCuadrupleColumna.removeRow(fila);
                salidaLimpia = true;
            }
        }
        return salidaLimpia;
    }

    public String obtenerDescripcion(){
        int fila = tablaMed.getSelectedRow();
        if (fila >= 0)
            return (String)tablaMed.getValueAt(fila, 0);
        else
            return null;
    }

    public String obtenerId(){
        int fila = tablaMed.getSelectedRow();
        if (fila >= 0)
            return (String)tablaMed.getValueAt(fila, 1);
        else
            return null;
    }
}