package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author José Diaz
 */
public class OyenteIncluir implements ActionListener{
    IncluirActualizarEliminar eventoIncluir;

    public OyenteIncluir(IncluirActualizarEliminar accionIncluir){
        eventoIncluir = accionIncluir;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        eventoIncluir.incluir();
    }    
}