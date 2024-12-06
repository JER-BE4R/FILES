import java.util.*;

public class Deck
{
    private ArrayList<Card> deck;

    public Deck()
    {
        deck = new ArrayList<Card>();

        //clubs

        deck.add(new Card(2,"Clubs"));
        deck.add(new Card(3,"Clubs"));
        deck.add(new Card(4,"Clubs"));
        deck.add(new Card(5,"Clubs"));
        deck.add(new Card(6,"Clubs"));
        deck.add(new Card(7,"Clubs"));
        deck.add(new Card(8,"Clubs"));
        deck.add(new Card(9,"Clubs"));
        deck.add(new Card(10,"Clubs"));
        deck.add(new Card(11,"Clubs"));
        deck.add(new Card(12,"Clubs"));
        deck.add(new Card(13,"Clubs"));
        deck.add(new Card(14,"Clubs"));

        //spades

        deck.add(new Card(2,"Spades"));
        deck.add(new Card(3,"Spades"));
        deck.add(new Card(4,"Spades"));
        deck.add(new Card(5,"Spades"));
        deck.add(new Card(6,"Spades"));
        deck.add(new Card(7,"Spades"));
        deck.add(new Card(8,"Spades"));
        deck.add(new Card(9,"Spades"));
        deck.add(new Card(10,"Spades"));
        deck.add(new Card(11,"Spades"));
        deck.add(new Card(12,"Spades"));
        deck.add(new Card(13,"Spades"));
        deck.add(new Card(14,"Spades"));

        //diamonds

        deck.add(new Card(2,"Diamonds"));
        deck.add(new Card(3,"Diamonds"));
        deck.add(new Card(4,"Diamonds"));
        deck.add(new Card(5,"Diamonds"));
        deck.add(new Card(6,"Diamonds"));
        deck.add(new Card(7,"Diamonds"));
        deck.add(new Card(8,"Diamonds"));
        deck.add(new Card(9,"Diamonds"));
        deck.add(new Card(10,"Diamonds"));
        deck.add(new Card(11,"Diamonds"));
        deck.add(new Card(12,"Diamonds"));
        deck.add(new Card(13,"Diamonds"));
        deck.add(new Card(14,"Diamonds"));

        //hearts

        deck.add(new Card(2,"Hearts"));
        deck.add(new Card(3,"Hearts"));
        deck.add(new Card(4,"Hearts"));
        deck.add(new Card(5,"Hearts"));
        deck.add(new Card(6,"Hearts"));
        deck.add(new Card(7,"Hearts"));
        deck.add(new Card(8,"Hearts"));
        deck.add(new Card(9,"Hearts"));
        deck.add(new Card(10,"Hearts"));
        deck.add(new Card(11,"Hearts"));
        deck.add(new Card(12,"Hearts"));
        deck.add(new Card(13,"Hearts"));
        deck.add(new Card(14,"Hearts"));
    }

    public void shuffleDeck()
    {
        ArrayList<Card> temp = new ArrayList<Card>();

        while ( deck.size() > 0 ) {
            int spot = (int)(deck.size()*Math.random());

            temp.add(deck.get(spot));

            deck.remove(spot);
        }

        deck = temp;
    }

    public Card playCard()
    {
        Card temp = new Card(0,"blank");
        temp = deck.get(0);
        deck.remove(0);

        return temp;
    }

    public Card getCard(int index)
    {
        return deck.get(index);
    }

    public int size() {
        return deck.size();
    }

    public String toString()
    {
        return deck.toString();
    }
}
