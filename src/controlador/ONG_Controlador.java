/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ONG_Modelo;
import vista.VistaONG;

/**
 *
 * @author Equipo
 */
public class ONG_Controlador implements ActionListener{
    
    private ONG_Modelo miMOdelo;
    private VistaONG miVista;

    /* AQUI UBICAMOS LAS VARIABLES */
        Double dineroOchenta=0.0;
        Double dineroCuarenta=0.0;
        Double dineroSesenta=0.0;
        Double dineroVeinte=0.0;
        Double porcentajeOchenta=0.0;
        Double porcentajeCuarenta=0.0;
        Double porcentajeSesenta=0.0;
        Double porcentajeVeinte=0.0;
        Double totalDieroDonado=0.0;
        int subsidioochenta=0;
        int subsidiosesenta=0;
        int subsidiocuarenta=0;
        int subsidioveinte=0;
        int cantidadSubsidiados=0;
        int cantidadNoSubsidiados=0;        
        int cantidadTotalEstudiantes=0;        
        /* AQUI TERMINA EL BLOQUE DE LAS VARIABLES */
        
        
    public ONG_Controlador(ONG_Modelo miMOdelo, VistaONG miVista) {
        this.miMOdelo = miMOdelo;
        this.miVista = miVista;
        
        this.miVista.btnGuardar.addActionListener(this);
        this.miVista.btnCalcular.addActionListener(this);
        this.miVista.btnLimpiar.addActionListener(this);
        this.miVista.btnNuevo.addActionListener(this);
        this.miVista.btnSalir.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if (ae.getSource()==miVista.btnSalir) {
            System.exit(0);        
        }else if (ae.getSource()==miVista.btnCalcular) {
            
            miVista.btnCalcular.setEnabled(false);
            miVista.btnGuardar.setEnabled(false);
            miVista.btnLimpiar.setEnabled(true);
            miVista.lblSubsidio40.setText(String.valueOf(dineroCuarenta));
            miVista.lblSubsidio20.setText(String.valueOf(dineroVeinte));
            miVista.lblSubsidio60.setText(String.valueOf(dineroSesenta));
            miVista.lblSubsidio80.setText(String.valueOf(dineroOchenta));
           
            miVista.lblEstudiantesSinSubsidio.setText(String.valueOf(cantidadNoSubsidiados));
            miVista.lblTotalDineroDonado.setText(String.valueOf(totalDieroDonado));
            miVista.lblCantidadEstudiantesAfiliados.setText(String.valueOf(cantidadSubsidiados));
            miVista.lblcantidadTotalDeEstudiantes.setText(String.valueOf(cantidadTotalEstudiantes));            
            porcentajeVeinte=miMOdelo.damePorcentaje(subsidioveinte, cantidadTotalEstudiantes);
            porcentajeCuarenta=miMOdelo.damePorcentaje(subsidiocuarenta, cantidadTotalEstudiantes);
            porcentajeSesenta=miMOdelo.damePorcentaje(subsidiosesenta, cantidadTotalEstudiantes);
            porcentajeOchenta=miMOdelo.damePorcentaje(subsidioochenta, cantidadTotalEstudiantes);
            miVista.lblcantidadal20.setText(String.valueOf(subsidioveinte));
            miVista.lblcantidadal40.setText(String.valueOf(subsidiocuarenta));
            miVista.lblcantidadal60.setText(String.valueOf(subsidiosesenta));
            miVista.lblcantidadal80.setText(String.valueOf(subsidioochenta));
            
             miVista.lblPorcentaje20.setText(String.valueOf(porcentajeVeinte));
            miVista.lblPorcentaje40.setText(String.valueOf(porcentajeCuarenta));
            miVista.lblPorcentaje60.setText(String.valueOf(porcentajeSesenta));
            miVista.lblPorcentaje80.setText(String.valueOf(porcentajeOchenta));
            deshabilitarCampos();
          
        }else if (ae.getSource()==miVista.btnGuardar) {
            if (!estanVacios()) {
                JOptionPane.showMessageDialog(null, "Deben estar todos los campos llenos");
            }else{  

                double temp;
                double porcentajes;
                
                miMOdelo.setPromedio(Double.parseDouble(miVista.txtPromedio.getText()));
                miMOdelo.setValorSemestre(Double.parseDouble(miVista.txtValorSemestre.getText()));    
                
                miVista.lblSubsidioOtorgado.setText(String.valueOf(miMOdelo.valorSubsiado(miMOdelo.getPromedio(), miMOdelo.getValorSemestre())));
                miVista.lblValorAPagar.setText(String.valueOf(miMOdelo.getValorSemestre() - Double.parseDouble(miVista.lblSubsidioOtorgado.getText())));
                
                if (miMOdelo.porcentajeSubisidiado(miMOdelo.getPromedio())==1) {
                    temp=(miMOdelo.getValorSemestre()*20)/100;
                    dineroVeinte= dineroVeinte+temp;
                    totalDieroDonado=totalDieroDonado+dineroVeinte;
                    subsidioveinte++;                    
                    cantidadSubsidiados++;
                    cantidadTotalEstudiantes++;                    
                }else if (miMOdelo.porcentajeSubisidiado(miMOdelo.getPromedio())==2) {
                    temp=(miMOdelo.getValorSemestre()*40)/100;
                    dineroCuarenta= dineroCuarenta+temp;
                    totalDieroDonado=totalDieroDonado+dineroCuarenta;
                    subsidiocuarenta++;
                    cantidadSubsidiados++;
                    cantidadTotalEstudiantes++;
                }else if (miMOdelo.porcentajeSubisidiado(miMOdelo.getPromedio())==3) {
                    temp=(miMOdelo.getValorSemestre()*60)/100;
                    dineroSesenta= dineroSesenta+temp;
                    totalDieroDonado=totalDieroDonado+dineroSesenta;
                    subsidiosesenta++;
                    cantidadSubsidiados++; 
                    cantidadTotalEstudiantes++;
                }else if (miMOdelo.porcentajeSubisidiado(miMOdelo.getPromedio())==4) {
                     temp=(miMOdelo.getValorSemestre()*60)/100;
                    dineroOchenta= dineroOchenta+temp;
                    totalDieroDonado=totalDieroDonado+dineroOchenta;
                    subsidioochenta++;
                    cantidadSubsidiados++;
                    cantidadTotalEstudiantes++;
                }else if (miMOdelo.porcentajeSubisidiado(miMOdelo.getPromedio())==5) {
                    cantidadNoSubsidiados++;
                    cantidadTotalEstudiantes++;
                }
                
            }
            miVista.btnCalcular.setEnabled(true);
            limpiar();
            
        }else if (ae.getSource()==miVista.btnLimpiar) {
            limpiarTodo();
            miVista.btnNuevo.setEnabled(true);
             
        }else if (ae.getSource()==miVista.btnNuevo) {
            limpiarTodo();            
            habilitarCampos();
            miVista.btnNuevo.setEnabled(false);
        }
    }
    
    public boolean estanVacios() {
        return !miVista.txtNombres.getText().isEmpty()&& !miVista.txtApellidos.getText().isEmpty()&& !miVista.txtPromedio.getText().isEmpty()&&
                !miVista.txtValorSemestre.getText().isEmpty();
    }
    public void deshabilitarCampos(){
        miVista.txtNombres.setEnabled(false);
        miVista.txtApellidos.setEnabled(false);
        miVista.txtPromedio.setEnabled(false);
        miVista.txtValorSemestre.setEnabled(false);
        //miVista.cmbFormaDePago.setEnabled(false);
    }
    
    public void habilitarCampos(){
        miVista.txtNombres.setEnabled(true);
        miVista.txtApellidos.setEnabled(true);
        miVista.txtPromedio.setEnabled(true);
        miVista.txtValorSemestre.setEnabled(true);
        miVista.btnGuardar.setEnabled(true);
        //miVista.cmbFormaDePago.setEnabled(false);
    }
    
     public void limpiarTodo(){
        miVista.txtNombres.setText("");
        miVista.txtApellidos.setText("");
        miVista.txtPromedio.setText("");
        miVista.txtValorSemestre.setText("");
        miVista.lblSubsidio20.setText("");
        miVista.lblSubsidio40.setText("");        
        miVista.lblSubsidio80.setText("");
        miVista.lblValorAPagar.setText("");
        miVista.lblSubsidio60.setText("");        
        miVista.lblPorcentaje20.setText("");        
        miVista.lblPorcentaje40.setText("");
        miVista.lblPorcentaje60.setText("");
        miVista.lblPorcentaje80.setText("");
        miVista.lblSubsidioOtorgado.setText("");
        miVista.lblcantidadal80.setText("");
        miVista.lblcantidadal60.setText("");
        miVista.lblcantidadal40.setText("");
        miVista.lblcantidadal20.setText("");
        miVista.lblEstudiantesSinSubsidio.setText("");
        miVista.lblTotalDineroDonado.setText("");
        miVista.lblCantidadEstudiantesAfiliados.setText("");
        miVista.lblcantidadTotalDeEstudiantes.setText("");
        
        dineroOchenta=0.0;
        dineroCuarenta=0.0;
        dineroSesenta=0.0;
        dineroVeinte=0.0;
        porcentajeOchenta=0.0;
        porcentajeCuarenta=0.0;
        porcentajeSesenta=0.0;
        porcentajeVeinte=0.0;
        totalDieroDonado=0.0;
        subsidioochenta=0;
        subsidiosesenta=0;
        subsidiocuarenta=0;
        subsidioveinte=0;
        cantidadSubsidiados=0;
        cantidadNoSubsidiados=0;        
        cantidadTotalEstudiantes=0;
        miVista.btnLimpiar.setEnabled(false);       
    }
     
     public void limpiar(){
         miVista.txtNombres.setText("");
         miVista.txtApellidos.setText("");
         miVista.txtPromedio.setText("");
         miVista.txtValorSemestre.setText("");
         
     }
    
    public void Iniciar(){
        miVista.setTitle("ONG 'LA BENDICIÓN'");
        miVista.setLocationRelativeTo(null);
        
    }
    
}

