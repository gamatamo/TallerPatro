/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;
import Adapter.CuentaAdapter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

/**
 *
 * @author CltControl
 */
public class AtmEC {
    private static AtmEC instance = new AtmEC();
    private Currency moneda;
    private double dinero;
    private static ArrayList <Manejador> manejadores;
    private static CuentaAdapter cuentaAdap;
  
    
    
    private AtmEC() {


    }



    public AtmEC getInstance() {
        return instance;
    }
      



       public boolean sacarDinero(double dinero){
           if(dinero<cuentaAdap.balance()){
               cuentaAdap.retirar(cuentaAdap.balance()-dinero);
               return true;
           }
               return false;
       }

       public boolean ingresarDinero(int n, double denominacion){
           double dineroIngresar=n*denominacion;
            cuentaAdap.depositar(n, cuentaAdap.balance()+dineroIngresar);
           return true;
       }

       
       public void addManejador(Manejador m){
           manejadores.add(m);
       }
       
       
       public Manejador removeManejador(Manejador m){
           for(int i=0; i<=manejadores.size();i++){
               return manejadores.remove(i);
           }
           return null;
       }
       
       public static void transaction(Account cuenta){
        // here is where most of the work is
        Scanner in= new Scanner(System.in);
        int choice; 
        System.out.println("Please select an option"); 
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Balance ATM");
        choice = in.nextInt();
        in.next();
        switch(choice){
            case 1:
                float amount; 
                System.out.println("Por favor ingrese el monto a retirar: "); 
                amount = in.nextFloat();
                in.next();
                if(amount > cuenta.getAmount() || amount == 0){
                    System.out.println("Su saldo es insuficiente!!\n\n"); 
  
                    anotherTransaction(cuenta); // ask if they want another transaction
                } else {
                    // Todo: verificar que se puede realizar el retiro del atm
                    if(amount<cuenta.getAmount()){
                        cuentaAdap.retirar(amount);
                    }    
                    // Todo: actualizar tanto la cuenta como el atm y de los manejadores
                    // cuenta.retirar(amount);
                    // AtmUK.sacarDinero(amount);

                    // Todo: Mostrar resumen de transacción o error
                    // "You have withdrawn "+amount+" and your new balance is "+balance;
                    anotherTransaction(cuenta); 
                }
            break; 
            case 2:
                    // option number 2 is depositing 
                    float deposit; 
                    System.out.println("Please enter amount you would wish to deposit: "); 
                    deposit = in.nextFloat();
                    // Todo: actualizar tanto la cuenta como el atm
                    
                    // Todo: Mostrar resumen de transacción o error
                    // "You have withdrawn "+amount+" and your new balance is "+balance;
                    anotherTransaction(cuenta);
            break; 
            case 3:
                    // Todo: mostrar el balance de la cuenta
                    // "Your balance is "+balance
                    anotherTransaction(cuenta); 
            break;
            case 4:
                    // Todo: mostrar el balance del ATM con los billetes en cada manejador
                    anotherTransaction(cuenta); 
            break;
            default:
                    System.out.println("Invalid option:\n\n"); 
                    anotherTransaction(cuenta);
            break;
        }
    }

       public static void anotherTransaction(Account cuenta){

          Scanner in = new Scanner(System.in);
        int op;
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        op = in.nextInt();
        if (op == 1) {
            transaction(cuenta); // call transaction method
        } else if (op == 2) {
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction(cuenta);
        }
    }

       }

