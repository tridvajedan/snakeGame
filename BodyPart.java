import java.awt.*;

public class BodyPart  {
    public Color color = new Color(57, 194, 21);
    public int x,y,width,height;
    public Direction direction;

    BodyPart(int x, int y,int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height =height;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }

    public void move() {
        if (direction == Direction.LEFT) {
            x -= width;
        } else if (direction == Direction.RIGHT) {
            x += width ;
        } else if (direction == Direction.UP) {
            y -= height;
        } else
        {
            y += height;
        }
    }

    public void move(Direction direction1)
    {
        if (direction1 == Direction.LEFT) {
            x -= width;
        } else if (direction1 == Direction.RIGHT) {
            x += width ;
        } else if (direction1 == Direction.UP) {
            y -= height;
        } else
        {
            y += height;
        }
    }
}
