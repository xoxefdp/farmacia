package Vista;

import Control.CerrarVentana;
import Control.AceptarCancelar;
import Control.OyenteAceptar;
import Control.OyenteCancelar;
import Vista.Formatos.Botonera;
import java.awt.BorderLayout;
import java.awt.Container;
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
public class VistaUnidadesDeMedida extends JDialog implements AceptarCancelar, ActionListener, CerrarVentana{

    private Container contenedor;
    private JPanel udm;
    private JTextField text;
    private Botonera botonera;
    
    public VistaUnidadesDeMedida(){
        setTitle("Unidad de Medida");        
        setModal(true);        
        
        udm = new JPanel();
        udm.setBorder(BorderFactory.createTitledBorder("Descripcion"));
            text = new JTextField(20);
            udm.add(text);
        add(udm, BorderLayout.NORTH);
        
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