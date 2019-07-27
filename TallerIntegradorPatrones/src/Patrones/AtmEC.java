/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patrones;
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
    private ArrayList <Manejador> manejador;    
    
    private AtmEC() {
        manejador = new ArrayList<>();

    }



    public AtmEC getInstance() {
        return instance;
    }
      



       public boolean sacarDinero(double dinero){
            manejador.retirar(m);
           if(dinero<Balance.getAmount()){
               Balance.setAmout(Balance.getAmount()-dinero);
               return true;
           }
               return false;
       }

       public boolean ingresarDinero(int n, double denominacion){
           double dineroIngresar=n*denominacion;
            Balance.setAmout(Balance.getAmount()+dineroIngresar);
           return true;
       }

       
        public void addManejador(Manejador m){
        manejador.add(m);
        }
        
        public Manejador removeManejador(int i){
        return manejador.remove(i);
        }
       
      //Dentro de las transacciones se debe llamar al ATM para hacer el retiro o deposito de la cuenta correspondiente
        public static void transaction(Account cuenta){
        // here is where most of the work is
        int choice; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select an option"); 
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Balance ATM");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                float amount; 
                System.out.println("Please enter amount to withdraw: "); 
                amount = sc.nextFloat();
                if(amount > cuenta.getAmount() || amount == 0){
                    System.out.println("You have insufficient funds\n\n"); 
                    anotherTransaction(cuenta); // ask if they want another transaction
                } else {
                    // Todo: verificar que se puede realizar el retiro del atm

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
                    deposit = sc.nextFloat();
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
            Scanner sc= new Scanner(System.in);
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        int anotherTransaction = sc.nextInt();
        switch (anotherTransaction) {
            case 1:
                transaction(cuenta); // call transaction method
                break;
            case 2:
                System.out.println("Thanks for choosing us. Good Bye!");
                break;
            default:
                System.out.println("Invalid choice\n\n");
                anotherTransaction(cuenta);
                break;
        }
    }

}