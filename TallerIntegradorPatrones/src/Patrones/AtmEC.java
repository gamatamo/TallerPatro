/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;
import java.util.Currency;

/**
 *
 * @author CltControl
 */
public class AtmEC {
    private static AtmEC instance = new AtmEC();
    private Currency moneda;
    private double dinero;
    private Manejador manejador;
    
    
    private AtmEC() {


    }



    public AtmEC getInstance() {
        return instance;
    }
      



       public boolean sacarDinero(double dinero){


           return false;
       }

       public boolean ingresarDinero(int n, double denominacion){


           return false;
       }

       
       public void addManejador(Manejador m){
           
       }
       
       
       public Manejador removeManejador(Manejador i){
           return i;
       }
       
       public void transaction(){

       }

       public void anotherTransaction(){



       }

}