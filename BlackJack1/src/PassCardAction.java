/**
 * Ta klasa reprezentuje akcję, która wykona się po wciśnęciu przycisku "Nic nie rób"
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassCardAction implements ActionListener {
    private GamePanel game;

    public PassCardAction(GamePanel game){
        this.game=game;
    }

    public void actionPerformed(ActionEvent e){
        game.setPlayerInGame(false);
        game.round();
    }

}
