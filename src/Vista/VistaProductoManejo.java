package Vista;

import Control.IncluirActualizarEliminar;
import Control.OyenteEliminar;
import Control.OyenteIncluir;
import Control.OyenteActualizar;
import Vista.Formatos.Botonera;
import Vista.Tablas.TablaDeMedicamentos;
import Vista.Tablas.TablaDeProductos;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 *
 * @author José Diaz
 */
public class VistaProductoManejo extends JFrame implements IncluirActualizarEliminar{
    
    private TablaDeMedicamentos tablaMed;
    private TablaDeProductos tablaProd;
    private Botonera botoneraProd;
   
    public VistaProductoManejo(){
        crearVentana();
    }
    
    final void crearVentana(){
        setTitle("Actualizar Producto");
        setLayout(new BorderLayout());
       
        tablaMed = new TablaDeMedicamentos();  
        tablaProd = new TablaDeProductos();        
        botoneraProd = new Botonera(3);
        botoneraProd.adherirEscucha(0, new OyenteIncluir (this));
        botoneraProd.adherirEscucha(1, new OyenteActualizar (this));
        botoneraProd.adherirEscucha(2, new OyenteEliminar (this));
        
        add(BorderLayout.NORTH, tablaMed);
        add(BorderLayout.CENTER,tablaProd);
        add(BorderLayout.SOUTH, botoneraProd);
        
        pack();
        setVisible(true);
    }
    
    @Override
    public void incluir() {
        new VistaProducto();
    }

    @Override
    public void actualizar() {
        new VistaProducto();
    }

    @Override
    public void eliminar() {
        new VistaProducto();
    }
}