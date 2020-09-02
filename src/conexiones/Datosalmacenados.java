/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;
import java.util.ArrayList;

/**
 *
 * @author raulsantiago
 */
public class Datosalmacenados {
    

    public ArrayList <Libros> listado = new ArrayList<>(new MySQL().listadolibros());
 
    
}
