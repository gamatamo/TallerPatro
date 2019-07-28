/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;

import Adapter.Cuenta;
import Adapter.CuentaAdapter;
import Chain.ManejadorDinero;
import java.util.Currency;
import java.util.Locale;
import Chain.Manejador;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Crear un único cajero Automático de dólares con 100 billetes de 20, 100 de 10, 
        // 10 monedas de 0.50, 10 de 0.25 y 1000 de 0.05
        Manejador b100 = new ManejadorDinero(100,100);
        Manejador b20 = new ManejadorDinero(100,20);
        Manejador b10 = new ManejadorDinero(100,10);
        Manejador m50 = new ManejadorDinero(10,0.50);
        Manejador m25 = new ManejadorDinero(10,0.25);
        Manejador m5 = new ManejadorDinero(1000,0.05);
        b100.setNext(b20);
        b20.setNext(b10);
        b10.setNext(m50);
        m50.setNext(m25);
        m25.setNext(m5);
        
        
        // Crear 10 cuentas nuevas en dólares locale.US con un saldo inicial entre 100.00 y 1000.00 USD cada una.
        ArrayList<Cuenta>cuentas=new ArrayList<>();
        Cuenta cuenta1=new CuentaAdapter(1,104.25);        cuentas.add(cuenta1);
        Cuenta cuenta2=new CuentaAdapter(2,200);        cuentas.add(cuenta2);
        Cuenta cuenta3=new CuentaAdapter(3,500);        cuentas.add(cuenta3);
        Cuenta cuenta4=new CuentaAdapter(4,550);        cuentas.add(cuenta4);
        Cuenta cuenta5=new CuentaAdapter(5,900);        cuentas.add(cuenta5);
        Cuenta cuenta6=new CuentaAdapter(6,700);        cuentas.add(cuenta6);
        Cuenta cuenta7=new CuentaAdapter(7,1000);        cuentas.add(cuenta7);
        Cuenta cuenta8=new CuentaAdapter(8,505);        cuentas.add(cuenta8);
        Cuenta cuenta9=new CuentaAdapter(9,100.50);        cuentas.add(cuenta9);
        Cuenta cuenta10=new CuentaAdapter(10,120);      cuentas.add(cuenta10);
        
// Menú principal para seleccionar una de las 10 cuentas solo con el id
        
   Scanner sc= new Scanner(System.in);   
       System.out.print("Enter ID Account:");
       int id=sc.nextInt();
       sc.nextLine();
       Cuenta cuenta=null;
       for(Cuenta c:cuentas){
           if(c.getId()==id){
               cuenta=c;
               break;
           }
       }
        // Mostrar el menú para realizar transacciones en el cajero automático
        AtmEC atm = AtmEC.getInstance();
        atm.addManejador(b100);
        if(cuenta != null){
            AtmEC.transaction(cuenta);
        }else{
            System.out.printf("There is not such Account with ID %d\n", id);
        }
    }

    
}
