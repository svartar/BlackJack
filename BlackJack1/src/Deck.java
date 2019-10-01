/**
 * Klasa reprezentuje talię 52 kart
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();

        for(int suit=0;suit<4;suit++){
            for(int value=0;value<13;value++){
                cards.add(new Card(Suit.values()[suit],Value.values()[value]));
            }
        }
    }

    public void shuffle(){ //potasuj talię kart
        Collections.shuffle(cards);
    }

    public Card handOutCard(){ //usuń i zwróć z talii pierwszą kartę
        return cards.remove(0);
    }
}
