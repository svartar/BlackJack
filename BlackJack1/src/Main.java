/**
 * Klasa zawiera tylko główną metodę, "Look and Feel" oraz służy do uruchomienia programu
 */
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(UnsupportedLookAndFeelException e){
            //do nothing
        }
        catch(ClassNotFoundException e){
            //do nothing
        }
        catch(InstantiationException e){
            //do nothing
        }
        catch(IllegalAccessException e){
            //do nothing
        }

        new GameFrame();
    }
}
