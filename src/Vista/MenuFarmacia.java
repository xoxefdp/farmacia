package Vista;

import Control.CerrarVentana;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.security.auth.callback.ConfirmationCallback.YES;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
/**
 *
 * @author José Diaz
 */
public class MenuFarmacia extends JFrame implements ActionListener, CerrarVentana{
    private JMenuBar menubar;
    private JMenu archivos, procesos, reportes, sistema;
    private JMenuItem laboratorio, medicamento, unidadesdemedida, componente, productos, sesion;
        
    public MenuFarmacia(){
        super("Sistema de Farmacia");
        setLayout(new BorderLayout()); 
        
        menubar = new JMenuBar(); // se crea la barra de menus        
        //setJMenuBar(menubar);
        
            archivos = new JMenu("Archivos"); //se crea un elemento del menu
            menubar.add(archivos);
            
                laboratorio = new JMenuItem("Laboratorio");// se crea la opcion Laboratorio en el menu
                laboratorio.addActionListener(this);
                archivos.add(laboratorio);// se agrega el JMenuItem laboratorio al JMenuBar menubar
                
                medicamento = new JMenuItem("Medicamento");// se crea la opcion Medicamento en el menu
                medicamento.addActionListener(this);
                archivos.add(medicamento);// se agrega el JMenuItem medicamento al JMenuBar menubar
                
                unidadesdemedida = new JMenuItem("Unidades De Medida");// se crea la opcion Unidades De Medida en el menu
                unidadesdemedida.addActionListener(this);
                archivos.add(unidadesdemedida);// se agrega el JMenuItem unidadesdemedida al JMenuBar menubar
                
                componente = new JMenuItem("Componente");// se crea la opcion Componente en el menu
                componente.addActionListener(this);
                archivos.add(componente);// se agrega el JMenuItem componente al JMenuBar menubar

            procesos = new JMenu("Procesos"); //se crea un elemento del menu
            menubar.add(procesos);
            
                productos = new JMenuItem("Productos");// se crea la opcion Laboratorios en el menu
                productos.addActionListener(this);
                procesos.add(productos);// se agrega el JMenuItem productos al JMenuBar menubar

            reportes = new JMenu("Reportes"); //se crea un elemento del menu
            menubar.add(reportes);
            
            sistema = new JMenu("Sistema"); //se crea un elemento del menu
            menubar.add(sistema);
            
                sesion = new JMenuItem("Cerrar Sesion");// se crea la opcion Cerrar Sesion en el menu
                sesion.addActionListener(this);
                sistema.add(sesion);// se agrega el JMenuItem sesion al JMenuBar menubar                
                
        add(BorderLayout.NORTH, menubar);
        setVisible(true);
        setSize(800, 600);
        formWindowOpened(null);
    }

    private void formWindowOpened (java.awt.event.WindowEvent evt){
        ContenidoFondo fondoFarmacia = new ContenidoFondo();
        add(fondoFarmacia, BorderLayout.CENTER);
        fondoFarmacia.repaint();
    }         
    
    /*verificar si puedo generar una estructura que pueda reutilizarse para el evento de apertura de ventanas*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == laboratorio) {
            new VistaLaboratorioManejo();
        }
        if (e.getSource() == medicamento) {
            new VistaMedicamentoManejo();
        }
        if (e.getSource() == unidadesdemedida) {
            new VistaUnidadesDeMedidaManejo();
        }
        if (e.getSource() == componente) {
            new VistaComponenteManejo();
        }
        if (e.getSource() == productos) {
            new VistaProductoManejo();
        }
        if (e.getSource() == sesion) {
            cerrarVentana();
        }
    }

    @Override
    public void cerrarVentana() {
        //JOptionPane.showConfirmDialog(null, "Desea salir del sistema de farmacia?", "Salir de sistema farmacia", WIDTH);
        int confirmarSalida = JOptionPane.showConfirmDialog(null, "Desea salir del sistema de farmacia?", "Saliendo de sistema de farmacia", YES_NO_OPTION);        
        if (confirmarSalida == JOptionPane.OK_OPTION){
            System.out.print("si");
            System.exit(0);            
        }else{
            System.out.print("no");
            this.dispose();
        }
    }

    public static void main(String[] args) {
        MenuFarmacia ventana = new MenuFarmacia();
    }
}