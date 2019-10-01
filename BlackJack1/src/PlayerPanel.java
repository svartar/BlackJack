/**
 * klasa reprezentuje panel, który reprezentuje pojedynczego gracza (wyświetla info o jego kartach, punktach i ewentualnej wygranej)
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class PlayerPanel extends JPanel {
    private JLabel textLabel = new JLabel();
    private JLabel winnerLabel = new JLabel();
    private final Color backgroundColor = new Color(0,128,0);

    public PlayerPanel(int w,int h){
        setPreferredSize(new Dimension(w,h));
        setBackground(backgroundColor);
        setBorder(new EmptyBorder(10,10,10,10));

        setLayout(new BorderLayout());
        add(textLabel, BorderLayout.NORTH);
        add(winnerLabel, BorderLayout.SOUTH);
    }

    public void setText(String text){
        textLabel.setText(text);
    }

    public void setWinnerLabelText(String text){
        winnerLabel.setText(text);
    }
}
