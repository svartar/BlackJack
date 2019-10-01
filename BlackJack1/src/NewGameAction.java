/**
 * klasa reprezentuje ponowne otwarcie programu po wywołaniu takiej opcji z menu wstążki lub za pomocą skrótu klawiaturowego
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameAction implements ActionListener{
    JFrame frame;

    public NewGameAction (JFrame jframe){
        frame = jframe;
    }

    public void actionPerformed (ActionEvent e){
        frame.setVisible(false);
        frame.dispose();
        new GameFrame();
    }
}
