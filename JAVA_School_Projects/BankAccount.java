
import java.util.*;

import java.io.IOException;

import java.io.PrintWriter;

import java.io.FileOutputStream;

public class BankAccount extends Account {

    private static String FirstName;
    
    private static String LastName;
    
    private static int AccountID;
    
    protected static double Balance;
    
    private static Scanner scnr = new Scanner(System.in);

    public BankAccount(){
        super();
    }
    

    public Double constructor(){
    
        Balance = 0;
        
        return Balance;
    
    }
    
    public void deposit(Double amount){
    
        Balance += amount;
        super.Balance = Balance;
        
        
        System.out.println(Balance);
    
    }
    
    public void withdrawal(Double amount){
    
        if (Balance >= amount) {
        
        Balance -= amount;
        
        System.out.println("Your New Balance is "+ Balance);
        
        }
        
        else if (Balance < amount){
            // CheckingAccount.processWithdrawal(amount);
            withdrawal(amount);
        
        }
    }
}