import java.awt.*;
import java.util.Random;

public class AppleManager {
    public Apple apple;
    public GameStateManager manager;
    public AppleManager(GameStateManager manager)
    {
        this.manager = manager;
        spawnApple();
    }

    public void draw(Graphics g)
    {
        apple.draw(g);
    }

    public void spawnApple()
    {
        Random r = new Random();
        int x = r.nextInt(1000);int y = r.nextInt(1000);
        while(x % 25 != 0)
        {
            x = r.nextInt(1000);
        }
        while(y % 25 != 0)
        {
            y = r.nextInt(1000);
        }
        apple = new Apple(x,y);
    }
}
