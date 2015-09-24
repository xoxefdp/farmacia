package Control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author José Diaz
 */
public class OyenteAbrirVentana extends WindowAdapter{
    AbrirVentana ventanaLlamada;
    
    public OyenteAbrirVentana(AbrirVentana objetoEventoApertura){
        ventanaLlamada = objetoEventoApertura;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        ventanaLlamada.abrirVentana();
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}