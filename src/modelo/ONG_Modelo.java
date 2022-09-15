/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Equipo
 */
public class ONG_Modelo {
    
     private String nombres;
    private String apellidos;
    private double promedio;    
    private double valorSemestre;
    
    public ONG_Modelo(){
        
    }

    public ONG_Modelo(String nombres, String apellidos, double promedio, double valorSemestre) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
        this.valorSemestre = valorSemestre;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getValorSemestre() {
        return valorSemestre;
    }

    public void setValorSemestre(double valorSemestre) {
        this.valorSemestre = valorSemestre;
    }
    
    public double valorSubsiado(double promedio, double valorMatricula){        
        double valorSudsisio=0;          
        double vlrMatricula= valorMatricula;
        
        if (promedio>=3.0 && promedio<=3.5) {            
            valorSudsisio=((vlrMatricula*20)/100);                        
        }else if (promedio>3.6 && promedio<=3.9) {            
            valorSudsisio=((vlrMatricula*40)/100);           
        }else if (promedio>4.0 && promedio<=4.5) {            
            valorSudsisio=((vlrMatricula*60)/100);            
        }else if (promedio>4.6 && promedio<=5.0) {            
            valorSudsisio=((vlrMatricula*80)/100);            
        }else if (promedio<3.0) {            
            valorSudsisio=0;            
        }        
        return valorSudsisio;
    }
    
    public int porcentajeSubisidiado(double promedio){        
        int porcentajeSubsidiado=0;                         
        if (promedio>=3.0 && promedio<=3.5) {            
            porcentajeSubsidiado=1;
        }else if (promedio>3.6 && promedio<=3.9) {            
            porcentajeSubsidiado=2;         
        }else if (promedio>4.0 && promedio<=4.5) {            
            porcentajeSubsidiado=3;
        }else if (promedio>4.6 && promedio<=5.0) {            
            porcentajeSubsidiado=4;
        }else if (promedio<3.0) {            
            porcentajeSubsidiado=5;      
        }        
        return porcentajeSubsidiado;
    }
    
    public double damePorcentaje(int cantidadPorPorcentaje, int cantidadTotal){
        
        double temp;
        
        temp=(cantidadPorPorcentaje*100)/cantidadTotal;
        
        return temp;
    }
}
