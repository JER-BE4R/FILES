import java.util.*;

/*
 * ACES APPEAR TO BE WORKING
 * SOME KIND OF INFINITE LOOP AFTER BUSTING OUT
 */

public class BlackJack
{
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private int phVal;
    private int dhVal;
    private int wager;
    
    private Wallet yourWallet;

    public BlackJack()
    {
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
        phVal = 0;
        dhVal = 0;
        wager = 0;
        
        yourWallet = new Wallet();
    }

    public Wallet playBlackjack(Wallet wallet)
    {
        Scanner sc = new Scanner(System.in);
        int running = 0;
        
        yourWallet = wallet;
        
        Deck d = new Deck();
        d.shuffleDeck();

        while ( running == 0 )
        {
            playerHand = new ArrayList<Card>();
            dealerHand = new ArrayList<Card>();
            phVal = 0;
            dhVal = 0;
            wager = 0; 

            if (d.size() < 20) {
                System.out.println("Reshuffling the deck... \n");
                d = new Deck();
                d.shuffleDeck();

                try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    System.out.println("Reshuffle interrupted! \n");
                }
            }

            dealerHand.add(d.playCard());
            dealerHand.add(d.playCard());
            
            playerHand.add(d.playCard());
            playerHand.add(d.playCard());
            
            phVal = handValuePlayer();
            
            System.out.println(playerHand);
            
            System.out.println("The value of your hand is " + phVal + "\n");

            System.out.println("The dealer is showing " + dealerHand.get(0) + "\n");

            System.out.println("How much would you like to wager?\n");
            wager = sc.nextInt();
            
            
            String SACRIFICE = sc.nextLine();
            playerTurn(d);
            if ( phVal > 21 ) {
                System.out.println("You lost!\n");
                yourWallet.changeMoney(-wager);
                System.out.println(yourWallet);
            }
            else {
                dealerTurn(d);

                if( phVal > dhVal && (phVal <= 21) ) {
                    System.out.println("You win! Dealer loses!\n");
                    yourWallet.changeMoney(wager);
                    System.out.println(yourWallet);
                }
                else if ( phVal == dhVal && (phVal <= 21) ) {
                    System.out.println("Its a tie!\n");
                    
                    System.out.println(yourWallet);
                }
                else if ( phVal < dhVal && (phVal <= 21) && (dhVal > 21) ) {
                    System.out.println("You win! Dealer loses!\n");
                    yourWallet.changeMoney(wager);
                    System.out.println(yourWallet);
                }
                else if ( phVal < dhVal && (phVal <= 21) ) {
                    System.out.println("You lose! Dealer wins!\n");
                    yourWallet.changeMoney(-wager);
                    System.out.println(yourWallet);
                }
            }
            
            if ( yourWallet.getWallet() <= 0 )
            {
                System.out.println("NO MO MONEY!");
                break;
            }

            System.out.println("Would you like to play again? [YES] [NO]\n");

            String ans = sc.nextLine();

            ans = ans.toUpperCase();
            int typo = 0;
            while (typo == 0) {
                if ( ans.equals("YES") ) {
                    running = 0;
                    typo = 1;
                    
                    System.out.println("-----------------------------------------");
                }
                else if( ans.equals("NO") ) {
                    running = 1;
                    typo = 1;
                }
                else {
                    System.out.println("Please try again. [YES] [NO]\n");
                    ans = sc.nextLine();

                    ans = ans.toUpperCase();
                }
            }

        }
        return yourWallet;
    }

    public Deck playerTurn( Deck in )
    {

        Scanner sc = new Scanner(System.in);

        System.out.println(playerHand);

        phVal = handValuePlayer();

        System.out.println("The value of your hand is " + phVal + "\n");
        while ( phVal <= 21 ) {
            if( phVal == 21 ) {
                System.out.println("You have BlackJack!\n");
                return in;
            }
            System.out.println("Would you like to [HIT], [STAND], or [DOUBLE DOWN]\n"); 

            String cc = sc.nextLine();
            cc = cc.toUpperCase();
            int helpMe = 0;
            while ( helpMe == 0 ) {

                if (cc.equals("HIT")) {
                    Card select = in.playCard();

                    playerHand.add(select);

                    phVal = handValuePlayer();

                    System.out.println(playerHand);
                    System.out.println("The value of your hand is " + phVal + "\n");
                    helpMe = 1;
                }
                else if (cc.equals("STAND")) {
                    System.out.println(playerHand);
                    System.out.println("You stood with " + phVal + "\n");
                    helpMe = 2;
                    break;
                }
                else if (cc.equals("DOUBLE DOWN")) {
                    wager = wager*2;
                    Card select = in.playCard();
                    playerHand.add(select);

                    phVal = handValuePlayer();

                    System.out.println(playerHand);
                    System.out.println("You chose to double down! Your total is " + phVal + "\n");
                    helpMe = 2;
                    break;
                }
                else {
                    System.out.println("TRY AGAIN [HIT] [STAND] [DOUBLE DOWN]\n");
                    cc = sc.nextLine();
                    
                    cc = cc.toUpperCase();
                }

                if( phVal > 21) {
                    System.out.println(playerHand);
                    System.out.println("You busted with " + phVal + "\n");
                    return in;
                }
            }

            if (helpMe == 2) {
                break;
            }
        }

        return in;
    }

    public Deck dealerTurn( Deck in )
    {
        while (handValueDealer() < 17) {
            Card select = in.playCard();

            dealerHand.add(select);

            System.out.println(dealerHand);
            try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    System.out.println("Reshuffle interrupted! \n");
                }
        }

        dhVal = handValueDealer();

        System.out.println("The dealer's total is " + dhVal + "\n");
        
        try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    System.out.println("Reshuffle interrupted! \n");
                }

        return in;
    }

    public int handValuePlayer()
    {
        int aceCount = 0;
        int temp = 0;

        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).getValue() <= 10) {
                temp += playerHand.get(i).getValue();
            }
            else if(playerHand.get(i).getValue() > 10 && playerHand.get(i).getValue() < 14 ) {
                temp += 10;
            }
            else if (playerHand.get(i).getValue() == 14) {
                temp += 1;
                aceCount++;
            }
        }

        while (temp <= 21 && aceCount > 0) {
            if ((temp + 10) <= 21) {
                temp += 10; // Convert Ace from 1 to 11
                aceCount--;
            } else {
                break;
            }
        }

        return temp;
    }

    public int handValueDealer()
    {
        int aceCount = 0;
        int temp = 0;

        for (int i = 0; i < dealerHand.size(); i++) {
            if (dealerHand.get(i).getValue() <= 10) {
                temp += dealerHand.get(i).getValue();
            }
            else if(dealerHand.get(i).getValue() > 10 && dealerHand.get(i).getValue() < 14 ) {
                temp += 10;
            }
            else if (dealerHand.get(i).getValue() == 14) {
                temp += 1;
                aceCount++;
            }
        }

        while (temp <= 21 && aceCount > 0) {
            if ((temp + 10) <= 21) {
                temp += 10; // Convert Ace from 1 to 11
                aceCount--;
            } else {
                break;
            }
        }

        return temp;
    }

    
    //test the ace scenarios
    public void testAce()
    {
        playerHand.clear();
        playerHand.add(new Card(14, "Hearts")); // Ace
        playerHand.add(new Card(6, "Spades")); // Six
        phVal = handValuePlayer();
        System.out.println("Initial hand value (Ace + Six): " + phVal); // Should print 17

        playerHand.add(new Card(5, "Diamonds")); // Five
        phVal = handValuePlayer();
        System.out.println("Updated hand value (Ace + Six + Five): " + phVal); // Should print 12
    }
}
