/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import paneles.PanelCargaInicial;
import conexiones.Datosalmacenados;
import javax.swing.UIManager;


/**
 *
 * @author raulsantiago
 */
public class Principal {
    
       static  Datosalmacenados datos = new Datosalmacenados();
    
        public static void main(String args[]) {
            
            	try {
			//Forma de los componentes modificial, instanciados con MotifLookandFeel. Contiene las barras y formas de los componentes
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
                
                PanelCargaInicial pci = new PanelCargaInicial(datos);
                
              
  
            
                pci.setVisible(true);
     
         }
    
}
