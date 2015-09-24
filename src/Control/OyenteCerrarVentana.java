package Control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author José Diaz
 */
public class OyenteCerrarVentana extends WindowAdapter{
    CerrarVentana ventanaCerrar;
    
    public OyenteCerrarVentana(CerrarVentana objetoEventoCerrar){
        ventanaCerrar = objetoEventoCerrar;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ventanaCerrar.cerrarVentana();
    }
}
