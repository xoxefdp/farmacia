package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author José Diaz
 */
public class OyenteActualizar implements ActionListener{
    IncluirActualizarEliminar eventoActualizar;
    
    public OyenteActualizar(IncluirActualizarEliminar accionActualizar){
        eventoActualizar = accionActualizar;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        eventoActualizar.actualizar();
    }
    
    //El oyente debe manejar un elemento seleccionado por mouse
}