/**
 * klasa reprezentuje wydarzenia po kliknęciu przycisku: "Weź nową kartę".
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TakeCardAction implements ActionListener {
    private GamePanel game;

    public TakeCardAction(GamePanel game){
        this.game=game;
    }
    public void actionPerformed(ActionEvent e){
        game.round();
    }
}

