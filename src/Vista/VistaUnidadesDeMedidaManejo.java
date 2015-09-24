package Vista;

import Control.IncluirActualizarEliminar;
import Control.OyenteEliminar;
import Control.OyenteIncluir;
import Control.OyenteActualizar;
import Vista.Formatos.Botonera;
import Vista.Tablas.TablaDeUnidadesDeMedida;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 *
 * @author José Diaz
 */
public class VistaUnidadesDeMedidaManejo extends JFrame implements IncluirActualizarEliminar{
    
    private TablaDeUnidadesDeMedida tablaUnidadDeMedida;
    private Botonera botones;
   
    public VistaUnidadesDeMedidaManejo(){
        crearVentana();
    }
    final void crearVentana(){
        setTitle("Manejo Unidades de Medida");
        setResizable(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        tablaUnidadDeMedida = new TablaDeUnidadesDeMedida();
        
        botones = new Botonera(3);
        botones.adherirEscucha(0, new OyenteIncluir (this));
        botones.adherirEscucha(1, new OyenteActualizar (this));
        botones.adherirEscucha(2, new OyenteEliminar (this));
        add(BorderLayout.CENTER, tablaUnidadDeMedida);
        add(BorderLayout.SOUTH,  botones);
        
        pack();
        setVisible(true);
    }
    
    @Override
    public void incluir() {
        new VistaUnidadesDeMedida();
    }

    @Override
    public void actualizar() {
        new VistaUnidadesDeMedida();
    }

    @Override
    public void eliminar() {
        new VistaUnidadesDeMedida();
    }
}
