/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparc1;

/**
 *
 * @author Flores López Angel Raymundo
 */
public class cConvertidor {
    double valor;
    /**
     * Constructor de la clase donde se ingresa un Dato de texto para convertirlo de pesos a dolares
     * @param Dato 
     */
    public cConvertidor(String Dato){
        try{
            valor = Double.parseDouble(Dato);
        }catch(NumberFormatException xD){
            valor=0;
        }
        valor=valor/17;
    }
    /**
     * Metodo get para el valor convertido
     * @return 
     */
    public double getValor() {
        return valor;
    }
    
}
