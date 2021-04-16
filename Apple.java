import java.awt.*;

public class Apple {
    public int x,y,width=25,height=25;
    public Color color = new Color(205, 22, 22);

    public Apple(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
