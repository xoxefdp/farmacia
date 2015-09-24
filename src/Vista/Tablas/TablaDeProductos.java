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
public class TablaDeProductos extends JPanel {

    private Object[] nombreCamposProd, claseCamposProd;
    private ModeloDeTabla tablaPentaColumnaModelo;
    private JTable tablaProd;
    private TableColumn columNombreComponente, columUnidadMedida, columCantidadComponente, columIdComponente, columIdUnidadDeMedida;
    private Object[] datos = new Object[5];
    private JTextField campo;
    private ResultSet resultado;

    public TablaDeProductos(){

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Producto"));
        setOpaque(false);
        crearTabla();
    }

    final void crearTabla(){

        Object[] nombreCamposProd = {"Componente", "Cantidad", "Medida", "", ""};
        Object[] claseCamposProd = {new String(), new String(), new String(), 0, 0};
        tablaPentaColumnaModelo = new ModeloDeTabla(nombreCamposProd, claseCamposProd);
        campo = new JTextField();
        campo.setEditable(false);

        tablaProd = new JTable(tablaPentaColumnaModelo);
        tablaProd.setPreferredScrollableViewportSize(new Dimension(300,100));
        tablaProd.setFillsViewportHeight(false);
        columNombreComponente  = tablaProd.getColumnModel().getColumn(0);
        columUnidadMedida   = tablaProd.getColumnModel().getColumn(1);
        columCantidadComponente   = tablaProd.getColumnModel().getColumn(2);
        columIdUnidadDeMedida = tablaProd.getColumnModel().getColumn(3);
        columIdComponente = tablaProd.getColumnModel().getColumn(4);

        columNombreComponente.setMinWidth(100);
        columNombreComponente.setMaxWidth(100);
        columNombreComponente.setCellEditor(new DefaultCellEditor(campo));

        columUnidadMedida.setMinWidth(100);
        columUnidadMedida.setMaxWidth(100);
        columUnidadMedida.setCellEditor(new DefaultCellEditor(campo));

        columCantidadComponente.setMinWidth(100);
        columCantidadComponente.setMaxWidth(100);
        
        columIdUnidadDeMedida.setMinWidth(0);
        columIdUnidadDeMedida.setMaxWidth(0);

        columIdComponente.setMinWidth(0);
        columIdComponente.setMaxWidth(0);

        JScrollPane scrollPanel = new JScrollPane(tablaProd);
        add(scrollPanel);
    }

    public void cargarTabla(){
        int filas = tablaProd.getRowCount();

        for (int i = 0; i < filas; i++)
            tablaPentaColumnaModelo.removeRow(0);

        datos[0] = "Carga inicial";
        datos[1] = "0";
        datos[2] = "0";
        datos[3] = "0";
        datos[4] = "0";
        tablaPentaColumnaModelo.addRow(datos);
    }

    public boolean agregarFila(String nombreProducto){
        boolean salidaLimpia = false;
        datos[0] = nombreProducto;
        datos[1] = "0";
        datos[2] = "0";
        datos[3] = "0";
        datos[4] = "0";
        salidaLimpia = true;
        tablaPentaColumnaModelo.addRow(datos);
        return salidaLimpia;
    }

    public boolean modificarFila(String nombreProducto){
        boolean salidaLimpia = false;
        int fila = tablaProd.getSelectedRow();
        
        if (fila >= 0){
            datos[0] = nombreProducto;
            tablaPentaColumnaModelo.setValueAt(nombreProducto, fila, 0);
            salidaLimpia = true;
        }
        return salidaLimpia;
    }

    public boolean eliminarFila(){
        int fila = tablaProd.getSelectedRow();
        boolean salidaLimpia = false;
        if (fila >= 0){
            int respuesta = JOptionPane.showConfirmDialog(this,
                                               "¿Seguro quiere eliminar a: "+
                                               tablaPentaColumnaModelo.getValueAt(fila, 0));
            if (respuesta == JOptionPane.OK_OPTION){
                tablaPentaColumnaModelo.removeRow(fila);
                salidaLimpia = true;
            }
        }
        return salidaLimpia;
    }

    public String obtenerDescripcion(){
        int fila = tablaProd.getSelectedRow();
        if (fila >= 0)
            return (String)tablaProd.getValueAt(fila, 0);
        else
            return null;
    }

    public String obtenerId(){
        int fila = tablaProd.getSelectedRow();
        if (fila >= 0)
            return (String)tablaProd.getValueAt(fila, 1);
        else
            return null;
    }
}