import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameStateManager extends JPanel implements ActionListener, KeyListener {
    public int width,height;
    public Direction nextDirection = Direction.LEFT;
    public AppleManager appleManager = new AppleManager(this);
    public Snake snake = new Snake(this,appleManager);
    public boolean running = false;
    private Timer gameTimer = new Timer(250,this);

    GameStateManager(int width,int height)
    {
        running = true;
        this.width = width;
        this.height = height;
        snake.addHead(new BodyPart(500,500,25,25));
        snake.getHead().direction = Direction.LEFT;
        this.setFocusable(true);
        this.grabFocus();
        this.requestFocus();
        this.addKeyListener(this);
        gameTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(68, 54, 54));
        g.fillRect(0,0,width,height);
        appleManager.draw(g);
        snake.draw(g);

    }

    public void checkGameOver(HitType hitType)
    {
        if(running) {
            if (hitType == HitType.APPLE_HIT) {
                System.out.println(hitType);
                appleManager.spawnApple();
                snake.addPart();
                snake.addPart();
            } else if (hitType == HitType.SNAKE_HIT) {
                System.out.println(hitType);
                gameOver();
            } else ;
        }
    }

    public void autoMove()
    {
        Direction snakeDirection = snake.getHead().direction;
        if(snake.getHead().x < appleManager.apple.x)
        {
                nextDirection = Direction.RIGHT;
        }
        else if(snake.getHead().x > appleManager.apple.x)
        {
                nextDirection = Direction.LEFT;

        }
        else if(snake.getHead().y > appleManager.apple.y)
        {
                nextDirection = Direction.UP;
        }
        else if(snake.getHead().y < appleManager.apple.y)
        {
                nextDirection = Direction.DOWN;
        }
    }


    public void gameOver()
    {
        running = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            System.out.println(nextDirection);
            checkGameOver(snake.checkCollision());
            autoMove();
            snake.getHead().direction = nextDirection;
            snake.move();
            repaint();
        }
        BodyPart head = snake.getHead();
        if(head.x > 1000 || head.y > 1000 || head.x < 25 || head.y < 25)
        {
            checkGameOver(HitType.SNAKE_HIT);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
      /*  char key = e.getKeyChar();
        if (key == 'w') {
            if (snake.getHead().direction != Direction.DOWN) {
                nextDirection = Direction.UP;
                System.out.println(key);
            }
        } else if (key == 's') {
            if (snake.getHead().direction != Direction.UP) {
                nextDirection = Direction.DOWN;
                System.out.println(key);
            }
        } else if (key == 'd') {
            if(snake.getHead().direction != Direction.LEFT) {
            nextDirection = Direction.RIGHT;
                System.out.println(key);
        }
    }
        else if(key == 'a') {
            if (snake.getHead().direction != Direction.RIGHT) {
                nextDirection = Direction.LEFT;
                System.out.println(key);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }
        else;*/
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
