package Vista.Formatos;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author José Diaz
 */
public class Botonera extends JPanel{    
    JButton[] botones;
    JPanel cuadroBotonera;
    
    public Botonera(int botonesBotonera){
        cuadroBotonera = new JPanel();
            cuadroBotonera.setLayout(new FlowLayout());
        
        if (botonesBotonera == 2) {
            botones = new JButton[2];
            botones[0] = new JButton("Aceptar");
            cuadroBotonera.add(botones[0]);
            botones[1] = new JButton("Cancelar");
            cuadroBotonera.add(botones[1]);
        }
        if (botonesBotonera == 3) {
            botones = new JButton[3];
            botones[0] = new JButton("Incluir"); 
            cuadroBotonera.add(botones[0]);            
            botones[1] = new JButton("Modificar");
            cuadroBotonera.add(botones[1]);            
            botones[2] = new JButton("Eliminar");
            cuadroBotonera.add(botones[2]);
        }
        add(cuadroBotonera);
    }

    public void adherirEscucha(int posBoton, ActionListener escucha){
        if (posBoton >= 0 && posBoton <= 2){
            botones[posBoton].addActionListener(escucha);        
        }
        if (posBoton >= 0 && posBoton <= 1){
            botones[posBoton].addActionListener(escucha);
        }
    }
}
/*
public class Botonera extends JPanel{    
    JButton [] botones;
    
    public Botonera(String [] nombres){
        botones = new JButton[nombres.length];
        for (int i = 0; i < nombres.length; i++){
            botones[i] = new JButton(nombres[i]);
            add(botones[i]);
        }  
    }    
    public void asignarOyente(int boton, ActionListener oyente){
        if (boton >= 0 && boton < botones.length)
            botones[boton].addActionListener(oyente);
    }
}
*/