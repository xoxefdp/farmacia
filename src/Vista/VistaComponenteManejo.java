package Vista;

import Control.CerrarVentana;
import Control.IncluirActualizarEliminar;
import Control.OyenteEliminar;
import Control.OyenteIncluir;
import Control.OyenteActualizar;
import Vista.Formatos.Botonera;
import Vista.Tablas.TablaDeComponentes;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author José Diaz
 */
public class VistaComponenteManejo extends JFrame implements ActionListener, CerrarVentana, IncluirActualizarEliminar{
    
    private TablaDeComponentes tablaComp;
    private Botonera botoneraComp;    
   
    public VistaComponenteManejo(){
        crearVentana();
    }
    
    final void crearVentana(){
        setTitle("Actualizar Componentes");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        tablaComp = new TablaDeComponentes();
        botoneraComp = new Botonera(3);
        botoneraComp.adherirEscucha(0, new OyenteIncluir (this));
        botoneraComp.adherirEscucha(1, new OyenteActualizar (this));
        botoneraComp.adherirEscucha(2, new OyenteEliminar (this));
        add(BorderLayout.CENTER, tablaComp);
        add(BorderLayout.SOUTH,  botoneraComp);

        pack();
        setVisible(true);
    }
    
    @Override
    public void incluir() {
        new VistaComponente();
    }

    @Override
    public void actualizar() {
        new VistaComponente();
    }

    @Override
    public void eliminar() {
        new VistaComponente();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarVentana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
public class Materias extends JFrame{
    TablaMaterias tabla;
    private Botonera botones;
    private String [] nombreBotones = {"Incluir","Modificar", "Eliminar"};
    
    public Materias(){
        super("Materias");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,250);
        setResizable(false);
        setLocationRelativeTo(null);
        crearGui();
        setVisible(true);
    }
    final void crearGui(){
        JPanel panel = new JPanel(new FlowLayout());
        tabla = new TablaMaterias();
        panel.add(tabla);
        
        botones = new Botonera(nombreBotones);
        botones.asignarOyente(0, new OyenteIncluirM(this));
        botones.asignarOyente(1, new OyenteModificarM(this));
        botones.asignarOyente(2, new OyenteEliminarM(this));
        
        add(BorderLayout.CENTER, panel);
        add(BorderLayout.SOUTH, botones);
    }
    public void incluir(){
        System.out.println("Incluye");
    }
    public void modificar(){
        System.out.println("Modifica");
    }
    public void eliminar(){
        System.out.println("Elimina");
    }
    public static void main(String[] args) {
        new Materias();
    }
}
*/