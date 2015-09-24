package Vista;

import Control.AceptarCancelar;
import Control.CerrarVentana;
import Control.OyenteAceptar;
import Control.OyenteCancelar;
import Vista.Formatos.Botonera;
import java.awt.GridLayout;
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
public class VistaProducto extends JDialog implements AceptarCancelar, ActionListener, CerrarVentana{

    private JPanel prodComp, prodUdm, prodCant;
    private JComboBox cajaComp, cajaUdm;
    private JTextField opcionesCant;
    private Botonera botonera;
    
    //referencia declarada
    private String[] opcionesComp; //de aqui vendran las opciones que se veran en componente //atributo a ser relocado a CONTROL
    private String[] opcionesUdm; //de aqui vendran las opciones que se veran en unidades de medida //atributo a ser relocado a CONTROL
    
    public VistaProducto(){
        setTitle("Producto");
        setModal(true);
        setLayout(new GridLayout(4,1));
        
        //referencia creada
        opcionesComp = new String[]{"Seleccione...","","","", ""}; //elemento que se generara 
        //a partir de los elementos almacenados en la base de datos
        
        prodComp = new JPanel();
        prodComp.setBorder(BorderFactory.createTitledBorder("Componente"));
            cajaComp = new JComboBox(opcionesComp); //**//
            prodComp.add(cajaComp);
        add(prodComp);        
        
        //referencia creada
        opcionesUdm = new String[]{"Seleccione...","ML","MG","GR", "UI"}; //elemento que se generara 
        //a partir de los elementos almacenados en la base de datos
        
        prodUdm = new JPanel();
        prodUdm.setBorder(BorderFactory.createTitledBorder("Unidad de Medida"));
            cajaUdm = new JComboBox(opcionesUdm); //**//
            prodUdm.add(cajaUdm);
        add(prodUdm);
        
        prodCant = new JPanel();
        prodCant.setBorder(BorderFactory.createTitledBorder("Cantidad"));
            opcionesCant = new JTextField(20);
            prodCant.add(opcionesCant);
        add(prodCant);        

        botonera = new Botonera(2);
        add(botonera);        
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