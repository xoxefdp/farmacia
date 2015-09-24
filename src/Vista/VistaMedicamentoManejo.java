package Vista;

import Control.IncluirActualizarEliminar;
import Control.OyenteEliminar;
import Control.OyenteIncluir;
import Control.OyenteActualizar;
import Vista.Formatos.Botonera;
import Vista.Tablas.TablaDeMedicamentos;
import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 *
 * @author José Diaz
 */
public class VistaMedicamentoManejo extends JFrame implements IncluirActualizarEliminar{
    
    private TablaDeMedicamentos tablaMed;
    private Botonera botoneraMed;
   
    public VistaMedicamentoManejo(){
        crearVentana();
    }
    
    final void crearVentana(){
        setTitle("Actualizar Medicamento");
        setLayout(new BorderLayout());
        
        tablaMed = new TablaDeMedicamentos();
        botoneraMed = new Botonera(3);
        botoneraMed.adherirEscucha(0, new OyenteIncluir(this));
        botoneraMed.adherirEscucha(1, new OyenteActualizar(this));
        botoneraMed.adherirEscucha(2, new OyenteEliminar(this));
        add(BorderLayout.CENTER, tablaMed);
        add(BorderLayout.SOUTH, botoneraMed);

        pack();
        setVisible(true);
    }

    @Override
    public void incluir() {
        new VistaMedicamento();
    }

    @Override
    public void actualizar() {
        new VistaMedicamento();
    }

    @Override
    public void eliminar() {
        new VistaMedicamento();
    }
}