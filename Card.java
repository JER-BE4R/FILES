import java.util.*;

public class Card
{
    private int value;
    private String suit;

    public Card( int vIn, String sIn ) 
    {
        value = vIn;
        suit = sIn;
    }

    public int getValue() 
    {
        return value;
    }

    public String getSuit()
    {
        return suit;
    }

    public String toString()
    {
        String finale = new String();
        if (getValue() <= 10 ){

            finale = new String(value + " of " + suit);
        }
        else if (getValue() == 11) {
            finale = new String("Jack of " + suit);
        }
        else if (getValue() == 12) {
            finale = new String("Queen of " + suit);
        }
        else if (getValue() == 13) {
            finale = new String("Queen of " + suit);
        }
        else if (getValue() == 14) {
            finale = new String("Ace of " + suit);
        }

        return finale;
    }

    
}
