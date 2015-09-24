package Control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author José Diaz
 */
public class OyenteCerrarSistema extends WindowAdapter{
    CerrarSistema quienllama;
    
    public OyenteCerrarSistema(CerrarSistema llamante){
        quienllama = llamante;
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        quienllama.cerrarSistema();
    }
}
