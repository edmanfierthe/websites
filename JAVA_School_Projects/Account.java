public class Account {
    String FirstName;
    String LastName;
    int AccountID;
    Double Balance;

    //Creating constructor with arguments
    public Account( String FirstName, String LastName, int AccountID, Double Balance){
        this.FirstName = FirstName;
        this.LastName  = LastName;
        this.AccountID = AccountID;
        this.Balance   = Balance;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }

    public int getAccountID(){
        return AccountID;
    }
    public void setAcountID(int AccountID){
        this.AccountID = AccountID;
    }

    public Double getBalance(){
        return Balance;
    }
    public void setBalance(Double Balance){
        this.Balance = Balance;
    }
    // public static void getBalance(){
    
    // System.out.println("The balance is: "+ Balance);
    
    // }
    
    public String accountSummary(){
    
        String name = "Name: " + FirstName + " " + LastName;
        
        String account = name + ", Account: " + AccountID + ", Balance: $" + Balance;
        
        return account;
    
    }
}
