/**
 * Klasa reprezentuje pojedynczego gracza
 */
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player (String playerName){
        name = playerName;
        hand = new ArrayList<Card>();
    }

    public String getName(){
        return name;
    }

    public void addCardToHand(Card newCard){
        hand.add(newCard);
    }

    public int getHandSum(){
        int sumOfPoints=0;
        int cardPoints;
        int numberOfAces=0;

        for(int i=0;i<hand.size();i++){
            cardPoints=hand.get(i).getCardValue().getValue();

            if(cardPoints==11){
                numberOfAces++;
            }
            sumOfPoints=sumOfPoints+cardPoints;
        }
        while(sumOfPoints>21&&numberOfAces>0){
            sumOfPoints=sumOfPoints-10;
            numberOfAces--;
        }

        return sumOfPoints;
    }

    public String getCardsText(boolean showFirstHand){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<hand.size();i++){
            if(i==0&&!showFirstHand){
                sb.append("<br>[Ukryta]");
            }
            else{
                sb.append("<br>"+hand.get(i).toString());
            }
        }
        return sb.toString();
    }

    public String getCardsOnHand(boolean showFirstHand){
        StringBuilder sb = new StringBuilder();
        sb.append("<html> <b>");
        sb.append("<u>"+name+": </u> <br>");
        sb.append(getCardsText(showFirstHand)+"<br>");

        if(showFirstHand){
            sb.append("Punkty: ["+getHandSum()+"] <br>");
        }
        else{
            sb.append("Punkty: [?] <br>");
        }
        sb.append("</b> </html>");

        return sb.toString();
    }

    public boolean checkIfBusted(){
        return getHandSum()>21;
    }
}


