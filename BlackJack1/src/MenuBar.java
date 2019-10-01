/**
 * klasa reprezentuje wstążkę w programie
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar{
    JFrame frame;
    JMenu menu;
    JMenuItem newGameMenuItem;
    JMenuItem quitGameMenuItem;

    public MenuBar(JFrame jframe){
        frame = jframe;

        menu = new JMenu("Menu");
        add(menu);

        newGameMenuItem = new JMenuItem("Nowa gra");
        newGameMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newGameMenuItem.addActionListener(new NewGameAction(frame));
        menu.add(newGameMenuItem);

        quitGameMenuItem = new JMenuItem("Wyjdź z gry");
        quitGameMenuItem.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)));
        quitGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(quitGameMenuItem);
    }
}