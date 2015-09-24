package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author José Diaz
 */
public class OyenteAceptar implements ActionListener{
    
    AceptarCancelar eventoAceptar;
    
    public OyenteAceptar(AceptarCancelar accionAceptar){
        eventoAceptar = accionAceptar;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        eventoAceptar.aceptar();
    }    
}