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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author José Diaz
 */
public class VistaMedicamento extends JDialog implements AceptarCancelar, ActionListener, CerrarVentana{

    private JPanel meds, labs;
    private JTextField text;
    private JComboBox opciones;
    private Botonera botonera;
    
    //referencia declarada
    private String[] opcionesLab; //de aqui vendran las opciones que se veran en laboratorio //atributo a ser relocado a CONTROL    
    
    public VistaMedicamento(){
        setTitle("Medicamento");
        setModal(true);
        
        meds = new JPanel();
        meds.setBorder(BorderFactory.createTitledBorder("Nombre"));
            text = new JTextField(15);
            meds.add(text);
        add(meds, BorderLayout.NORTH);
        
        //referencia creada
        opcionesLab = new String[]{"Seleccione...","Pfizer","Bayer","Novartis", "Genven"}; //elemento que se generara 
        //a partir de los elementos almacenados en la base de datos
        
        labs = new JPanel();
        labs.setBorder(BorderFactory.createTitledBorder("Laboratorio"));
            opciones = new JComboBox(opcionesLab); //**//
            labs.add(opciones);
        add(labs, BorderLayout.CENTER);
        
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