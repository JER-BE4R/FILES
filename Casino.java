import java.util.*;

public class Casino
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int go = 0;
        
        BlackJack test = new BlackJack();
        
        Poker tests = new Poker();
        
        Wallet yourWallet = new Wallet();
        
        
        System.out.println("Welcome to the Casino!\n" + yourWallet);
        
        while (go == 0) //main loop
        {
            if ( yourWallet.getWallet() <= 0 )
            {
                System.out.println("Keep the change ya filthy animal! Come back when you aren't poorer than Patrick Star!");
                break;
            }
            System.out.println("Would you like to play [Blackjack],[Poker],or [Exit] the Casino");
            
            String c = sc.nextLine();
            
            c = c.toUpperCase();
            
            if ( c.equals("EXIT") ) {
                System.out.println("Thank you for visiting! You leave the casino with $" + yourWallet.getWallet());
                break;
            }
            else if ( c.equals("BLACKJACK") ) {
                yourWallet = test.playBlackjack(yourWallet);
                System.out.println("Thanks for playing Blackjack!\n");
            }
            else if (c.equals("POKER") ) {
                yourWallet = tests.playPoker(yourWallet);
                System.out.println("Thanks for playing Poker!\n");
            }
            
        
        }
    }
    
    
}
