package Principal;

import paneles.PanelCargaInicial;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Clase Principal
 *
 * Contiene el main principal donde se ejecutara la clase que muestra el Panel
 * principal
 *
 * @author Raul Santiago Prieto
 * @version 1.0
 */
public class Principal {

    /**
     * Método principal de la clase
     *
     * @param args
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.InstantiationException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, UnsupportedLookAndFeelException {

        //Forma de los componentes modificial, instanciados con MotifLookandFeel. Contiene las barras y formas de los componentes
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

       
        /**
         * Instanciación de la clase que mostrará el panel principal
         */
        PanelCargaInicial pci = new PanelCargaInicial();
        pci.setVisible(true);

    }

}
