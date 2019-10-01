/**
 * klasa reprezentuje okienko w którym wyświetlany będzie program
 */
import javax.swing.JFrame;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(){

        setTitle("Black Jack");
        setLocation(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel);

        setIconImage(Toolkit.getDefaultToolkit().getImage("images/black-jack-icon.png"));
        setJMenuBar(new MenuBar(this));

        pack();
        setVisible(true);

        gamePanel.runGame();
    }
}
