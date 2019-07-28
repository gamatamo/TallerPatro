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
        cuenta = new Account(id, monto);
    }
    
    @Override
    public double balance() {
        //saldo total
        return cuenta.getAmount();
    }

    @Override
    public boolean retirar(double monto) {
       cuenta.withdraw(monto);
       return true;
        
    }

    @Override
    public boolean depositar(int n, double denominacion) {
        double monto = denominacion * n;
        cuenta.deposit(monto);
        return true;
    }

}
