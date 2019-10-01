/**
 * Ta klasa reprezentuje panel z przyciskami znajdujący się w dolnej części okna
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class LowerButtonPanel extends JPanel{
    private JButton takeCardButton = new JButton("Weź nową kartę");
    private JButton passButton = new JButton("Nic nie rób");
    private final Color backgroundColor = new Color(0,128,0);

    public LowerButtonPanel(int w, int h, GamePanel game){
        setPreferredSize(new Dimension(w,h));
        setBackground(backgroundColor);
        setBorder(new EmptyBorder(10,10,10,10));

        takeCardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        passButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        takeCardButton.addActionListener(new TakeCardAction(game));
        passButton.addActionListener(new PassCardAction(game));

        add(takeCardButton);
        add(passButton);
    }
    public void disableButtons(){
        takeCardButton.setEnabled(false);
        passButton.setEnabled(false);
    }
}
