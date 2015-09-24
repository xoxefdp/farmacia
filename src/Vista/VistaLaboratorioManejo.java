package Vista;

import Vista.Formatos.Botonera;
import Control.CerrarVentana;
import Control.IncluirActualizarEliminar;
import Control.OyenteActualizar;
import Control.OyenteEliminar;
import Control.OyenteIncluir;
import Vista.Tablas.TablaDeLaboratorios;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author José Diaz
 */
public class VistaLaboratorioManejo extends JFrame implements ActionListener, CerrarVentana, IncluirActualizarEliminar{    
    
    private TablaDeLaboratorios tablaLab;
    private Botonera botoneraLab;
    
    public VistaLaboratorioManejo(){
        crearVentana();
    }
    
    final void crearVentana(){        
        setTitle("Manejo de Laboratorios");
        setLayout(new BorderLayout());
        
        tablaLab = new TablaDeLaboratorios();
        botoneraLab = new Botonera(3);
        botoneraLab.adherirEscucha(0, new OyenteIncluir(this));
        botoneraLab.adherirEscucha(1, new OyenteActualizar(this));
        botoneraLab.adherirEscucha(2, new OyenteEliminar(this));
        add(BorderLayout.CENTER, tablaLab);
        add(BorderLayout.SOUTH,  botoneraLab);

        pack();
        setVisible(true);       
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarVentana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incluir() {
        new VistaLaboratorio();
    }

    @Override
    public void actualizar() {
        new VistaLaboratorio();
    }

    @Override
    public void eliminar() {
        new VistaLaboratorio();
    }
}