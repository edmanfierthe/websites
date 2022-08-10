public class Main{

    public static void main(String[] args) {
        
        CheckingAccount obj = new CheckingAccount();
        
        obj.setAccountID(1);
        obj.setFirstName("Lionel");
        
        obj.setLastName("Messi");
        
        obj.deposit(500.0);
        
        System.out.println(obj.accountSummary());
        
        obj.processWithdral(300);
        
        obj.displayAccount();
    
    }
}