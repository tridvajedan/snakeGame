import java.awt.*;
import java.util.ArrayList;

public class Snake {
    public ArrayList<BodyPart> bodyParts = new ArrayList<>();
    public GameStateManager manager;
    public AppleManager appleManager;
    Snake(GameStateManager manager, AppleManager appleManager)
    {
        this.manager = manager;
        this.appleManager = appleManager;
    }

    public void addHead(BodyPart bodyPart)
    {
        bodyPart.color = new Color(84, 42, 143);
        bodyParts.add(bodyPart);
    }

    public void addPart() {
        BodyPart lastPart = bodyParts.get(bodyParts.size() - 1);
        BodyPart newPart;
        if (lastPart.direction == Direction.UP) {
            newPart = new BodyPart(lastPart.x, lastPart.y + lastPart.height, lastPart.width, lastPart.height);
        } else if (lastPart.direction == Direction.DOWN)
        {
            newPart = new BodyPart(lastPart.x, lastPart.y - lastPart.height, lastPart.width, lastPart.height);
        }
        else if(lastPart.direction == Direction.LEFT)
        {
            newPart = new BodyPart(lastPart.x + lastPart.width, lastPart.y, lastPart.width, lastPart.height);
        }
        else
        {
            newPart = new BodyPart(lastPart.x - lastPart.width, lastPart.y, lastPart.width, lastPart.height);
        }
        newPart.setDirection(lastPart.direction);
        bodyParts.add(newPart);
    }


    public BodyPart getHead()
    {
        return bodyParts.get(0);
    }

    public HitType checkCollision()
    {
        BodyPart head = getHead();
        for(int i = 1; i < bodyParts.size();i++)
        {
            BodyPart part = bodyParts.get(i);
            Rectangle headRect = new Rectangle(head.x  ,head.y ,head.width,head.height);
            Rectangle partRect = new Rectangle(part.x  ,part.y ,part.width,part.height);
            if(headRect.contains(partRect))
            {
                return HitType.SNAKE_HIT;
            }
        }
        Apple apple = appleManager.apple;
        if(new Rectangle(head.x,head.y,head.width,head.height).contains(new Rectangle(apple.x,apple.y,apple.width,apple.height)))
        {
            return HitType.APPLE_HIT;
        }
        return HitType.NONE;
    }

    public BodyPart partMoved(BodyPart movablePart,Direction direction)
    {
        BodyPart part = movablePart;
        part.move(direction);
        return part;
    }

    public void draw(Graphics g)
    {
        for(int i = 0; i < bodyParts.size();i++)
        {
            BodyPart part = bodyParts.get(i);
            part.draw(g);
        }
    }

    public void move()
    {
        for(int i = 0; i < bodyParts.size();i++)
        {
            BodyPart part = bodyParts.get(i);
            part.move();
        }
        changePartDirection();
    }

    public void changePartDirection()
    {
        BodyPart lastChangedPart = getHead();
        for(int i =0 ;i < bodyParts.size();i++)
        {
            BodyPart part = bodyParts.get(i);
            if(lastChangedPart.direction != part.direction)
            {
                Direction newDirection = lastChangedPart.direction;
                lastChangedPart.direction = part.direction;
                part.direction = newDirection;
            }
        }
            }
        }

