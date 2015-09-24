package Control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author José Diaz
 */
public class OyenteSeleccionar extends MouseAdapter{
    SeleccionarDeseleccionar objetoClickeado;
    
    public OyenteSeleccionar(SeleccionarDeseleccionar objetoEvento){
        objetoClickeado = objetoEvento;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        objetoClickeado.seleccionar();
    }
}
