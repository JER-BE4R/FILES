import java.util.*;

public class Poker
{
    private ArrayList<Card> playerHand;

    private Wallet yourWallet;
    private int wager;

    public Poker()
    {
        playerHand = new ArrayList<Card>();
        yourWallet = new Wallet();
    }

    public Wallet playPoker(Wallet wallet)
    {
        Scanner sc = new Scanner(System.in);
        int running = 0;

        yourWallet = wallet;

        Deck d = new Deck();
        d.shuffleDeck();

        while (running == 0)
        {
            playerHand = new ArrayList<Card>();
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

            for (int i = 0; i < 5; i++) 
            {
                playerHand.add(d.playCard());
            }
            
            System.out.println("How much would you like to wager?");
            wager = sc.nextInt();
            String MORESACRIFICES = sc.nextLine();
            ArrayList<Card> temp = new ArrayList<Card>();
            System.out.println(playerHand + "\n This is your hand \n");
            int tre = 0;

            //start switching process
            while (tre == 0) {

                System.out.println(playerHand.get(0) + "\n Would you like to change this card?[YES][NO]");
                String choice = sc.nextLine();

                choice = choice.toUpperCase();

                if (choice.equals("YES") ) {
                    temp.add(d.playCard()); 
                    break;
                }
                else if (choice.equals("NO") ) {
                    temp.add(playerHand.get(0));
                    break;
                }
            }
            while (tre == 0) {

                System.out.println(playerHand.get(1) + "\n Would you like to change this card?[YES][NO]");
                String choice = sc.nextLine();

                choice = choice.toUpperCase();

                if (choice.equals("YES") ) {
                    temp.add(d.playCard()); 
                    break;
                }
                else if (choice.equals("NO") ) {
                    temp.add(playerHand.get(1));
                    break;
                }
            }
            while (tre == 0) {

                System.out.println(playerHand.get(2) + "\n Would you like to change this card?[YES][NO]");
                String choice = sc.nextLine();

                choice = choice.toUpperCase();

                if (choice.equals("YES") ) {
                    temp.add(d.playCard()); 
                    break;
                }
                else if (choice.equals("NO") ) {
                    temp.add(playerHand.get(2));
                    break;
                }
            }
            while (tre == 0) {

                System.out.println(playerHand.get(3) + "\n Would you like to change this card?[YES][NO]");
                String choice = sc.nextLine();

                choice = choice.toUpperCase();

                if (choice.equals("YES") ) {
                    temp.add(d.playCard()); 
                    break;
                }
                else if (choice.equals("NO") ) {
                    temp.add(playerHand.get(3));
                    break;
                }
            }
            while (tre == 0) {

                System.out.println(playerHand.get(4) + "\n Would you like to change this card?[YES][NO]");
                String choice = sc.nextLine();

                choice = choice.toUpperCase();

                if (choice.equals("YES") ) {
                    temp.add(d.playCard()); 
                    break;
                }
                else if (choice.equals("NO") ) {
                    temp.add(playerHand.get(4));
                    break;
                }
            }
            //end switching process 

            //sorting
            playerHand = temp;

            System.out.println(playerHand);

            Card sac = new Card(0,"null");

            for (int i = 0; i < temp.size()-1; i++) {
                for (int j = 0; j < temp.size()-1; j++) {
                    if( temp.get(j).getValue() > temp.get(j+1).getValue() ) {
                        sac = temp.get(j);
                        temp.set(j,temp.get(j+1));
                        temp.set(j+1,sac);
                    }
                }
            }
            System.out.println(temp);
            
            break;
        }

        
        return yourWallet;
    }

}

