/**
 * klasa reprezentuje rdzeń gry
 * zawiera główną metodę runGame, która steruje grą
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private Deck deck;
    private Player player;
    private Player computer;

    private final Dimension panelSize = new Dimension (600,400);
    private final Color backgroundColor = Color.white;

    private PlayerPanel playerPanel;
    private PlayerPanel computerPanel;
    private LowerButtonPanel lowerPanel;

    private boolean playerInGame;
    private boolean computerInGame;

    public GamePanel(){
        deck = new Deck();
        deck.shuffle();

        player = new Player("Ja");
        computer = new Player("Krupier");

        setPreferredSize(panelSize);
        setBackground(backgroundColor);
        setLayout(new BorderLayout());

        playerPanel = new PlayerPanel (300,150);
        computerPanel = new PlayerPanel (300,150);
        lowerPanel = new LowerButtonPanel (600,50, this);

        add(playerPanel, BorderLayout.WEST);
        add(computerPanel, BorderLayout.EAST);
        add(lowerPanel, BorderLayout.SOUTH);

    }

    public void runGame(){
        player.addCardToHand(deck.handOutCard());
        computer.addCardToHand(deck.handOutCard());
        player.addCardToHand(deck.handOutCard());
        computer.addCardToHand(deck.handOutCard());

        playerPanel.setText(player.getCardsOnHand(true));
        computerPanel.setText(computer.getCardsOnHand(false));

        playerInGame=true;
        computerInGame=true;

    }

    public void finishGame(){

        lowerPanel.disableButtons();

        int playerSum = player.getHandSum();
        int computerSum = computer.getHandSum();

        if(playerSum>computerSum&&playerSum<=21){
            playerPanel.setWinnerLabelText("<html> <b> Wygrałeś! </b> </html>");
        }
        else if(computerSum>21&&playerSum<=21){
            playerPanel.setWinnerLabelText("<html> <b> Wygrałeś! </b> </html>");
        }
        else{
            computerPanel.setWinnerLabelText("<html> <b> Krupier wygrał! </b> </html>");
        }

        playerPanel.setText(player.getCardsOnHand(true));
        computerPanel.setText(computer.getCardsOnHand(true));
    }

    public void round(){
        if(playerInGame&&computerInGame){
            playerTurn();
            computerTurn();
            if(!computerInGame&&!playerInGame){
                finishGame();
            }
            if(!playerInGame&&computerInGame){
                round();
            }
        }
        else if(!playerInGame&&computerInGame){
            while(computerInGame){
                computerTurn();
            }
            if(!computerInGame&&!playerInGame){
                finishGame();
            }
        }
        else if(playerInGame&&!computerInGame){
            playerTurn();
            if(!computerInGame&&!playerInGame){
                finishGame();
            }
        }
        else{
            finishGame();
        }
    }

    public void computerTurn(){
        if(computer.getHandSum()<17){
            computer.addCardToHand(deck.handOutCard());
            computerPanel.setText(computer.getCardsOnHand(false));
            computerInGame=!computer.checkIfBusted();
        }
        else{
            computerInGame=false;
            computerPanel.setWinnerLabelText("<html> <b> Krupier zrezygnował z pobrania karty </b> </html>");
        }
    }

    public void playerTurn(){
        player.addCardToHand(deck.handOutCard());
        playerPanel.setText(player.getCardsOnHand(true));
        playerInGame=!player.checkIfBusted();
    }

    public Player getPlayer(){
        return player;
    }
    public Player getComputer(){
        return computer;
    }
    public Deck getDeck(){
        return deck;
    }
    public PlayerPanel getPlayerPanel(){
        return playerPanel;
    }
    public PlayerPanel getComputerPanel(){
        return computerPanel;
    }
    public void setPlayerInGame(boolean trueOrFalse){
        playerInGame=trueOrFalse;
    }
}
