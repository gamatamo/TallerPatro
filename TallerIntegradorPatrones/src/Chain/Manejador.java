/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chain;

/**
 *
 * @author gus
 */
public interface Manejador {
    //Manejador manejador(int n,double denominacion);
    void setNext(Manejador manejador);
    boolean retirar(double monto);
    boolean depositar(int n, double denominacion);
    
}