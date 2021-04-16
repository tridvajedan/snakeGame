import javax.swing.*;
import java.awt.*;

public class Launcher {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Snake");
        frame.setSize(new Dimension(1000,1000));
        frame.setResizable(false);
        GameStateManager gameManager = new GameStateManager(frame.getWidth(),frame.getHeight());
        gameManager.setSize(frame.getSize());
        frame.getContentPane().setPreferredSize(new Dimension(1000,1000));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(gameManager);
    }
}
