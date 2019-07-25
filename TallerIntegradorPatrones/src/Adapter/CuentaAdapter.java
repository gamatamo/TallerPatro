/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import Patrones.Account;
import java.util.Currency;

/**
 *
 * @author CltControl
 */
public class CuentaAdapter implements Cuenta{
    protected Account cuenta;
    protected Currency moneda;
    
    public CuentaAdapter(int id, double monto){
        
    }
    
    @Override
    public double balance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retirar(double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean depositar(int n, double denominacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
