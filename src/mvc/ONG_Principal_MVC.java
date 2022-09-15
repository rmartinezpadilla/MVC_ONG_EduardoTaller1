/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.ONG_Controlador;
import modelo.ONG_Modelo;
import vista.VistaONG;

/**
 *
 * @author Equipo
 */
public class ONG_Principal_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //importamos el modelo
        ONG_Modelo miModelo = new ONG_Modelo();
        //importamos la vista
        VistaONG miVista= new VistaONG();
        //importamos el controlador
        ONG_Controlador miControlador = new ONG_Controlador(miModelo, miVista);
        miControlador.Iniciar();                
        miVista.setVisible(true);
    }
    
}
