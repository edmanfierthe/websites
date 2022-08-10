

public class CheckingAccount extends BankAccount{
    
    int fees;
    
    double rate;
    
    public void processWithdral(double amount){
    
        int fees = 30;
    
        if(amount+fees <= Balance){
            super.Balance = super.Balance - amount - fees;
            
            System.out.println("New Balance: "+ Balance);
            
            System.out.println("You Have being Charged:"+fees+"$");
            
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public String displayAccount(){
    
        double rate = 5.50;
        
        String Interest = " Interest: "+rate+"%";
        
        String Display = accountSummary() + Interest;
        
        return Display;
    
    }

}