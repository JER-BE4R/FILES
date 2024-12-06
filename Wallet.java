
public class Wallet
{
    private int balance;
    
    public Wallet()
    {
        balance = 100;
    }
    
    public String toString()
    {
        String fin = new String("Money in your wallet: $" + balance);
        
        return fin;
    }
    
    public int getWallet()
    {
        return balance; 
    }
    
    public void changeMoney(int earnings)
    {
        balance = balance + earnings;
        
    }
}
