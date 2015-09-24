package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author José Diaz
 */
public class OyenteEliminar implements ActionListener{
    IncluirActualizarEliminar eventoEliminar;
    
    public OyenteEliminar(IncluirActualizarEliminar accionEliminar){
        eventoEliminar = accionEliminar;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        eventoEliminar.eliminar();
    }
    
    //El oyente debe manejar un elemento seleccionado por mouse
}