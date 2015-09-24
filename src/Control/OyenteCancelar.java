package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author José Diaz
 */
public class OyenteCancelar implements ActionListener{
    
    AceptarCancelar eventoCancelar;
    
    public OyenteCancelar(AceptarCancelar accionCancelar){
        eventoCancelar = accionCancelar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        eventoCancelar.cancelar();
    }
}