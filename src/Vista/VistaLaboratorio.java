package Vista;

import Control.AceptarCancelar;
import Control.CerrarVentana;
import Control.OyenteAceptar;
import Control.OyenteCancelar;
import Vista.Formatos.Botonera;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author José Diaz
 */
public class VistaLaboratorio extends JDialog implements AceptarCancelar, ActionListener, CerrarVentana{
    
    private JPanel labs;
    private JTextField text;
    private Botonera botonera;

    public VistaLaboratorio(){
        setTitle("Laboratorios");
        setModal(true);
        
        labs = new JPanel();
        labs.setBorder(BorderFactory.createTitledBorder("Nombre"));        
            text = new JTextField(20);
            labs.add(text);
        add(labs, BorderLayout.NORTH);
        
        botonera = new Botonera(2);
        add(botonera, BorderLayout.SOUTH);        
        botonera.adherirEscucha(0,new OyenteAceptar(this));
        botonera.adherirEscucha(1,new OyenteCancelar(this));
                
        pack();
        setVisible(true);
    }
    
    @Override
    public void aceptar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelar() {
        cerrarVentana();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarVentana() {
        dispose();
    }
}