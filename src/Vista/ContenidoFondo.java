package Vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 *
 * @author José Diaz
 */
public class ContenidoFondo extends javax.swing.JPanel{
    
    public ContenidoFondo(){
        
    }
     
    @Override
    public void paint(Graphics g){
        Dimension Tamaño = getSize();
        ImageIcon ImagenFondo = new ImageIcon (getClass().getResource("Fondo.jpg"));
        g.drawImage(ImagenFondo.getImage(),0,0, Tamaño.width, Tamaño.height, null);
        setOpaque(false);
        paintComponent(g);
    }    
}