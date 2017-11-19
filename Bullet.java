import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {

    private int x;
    private int y;
    BufferedImage redShot;

    public Bullet(int x, int y, String shot)
    {
        this.x = x;
        this.y = y;


    }

    public void tick()
    {
        x += 10;
    }

    public void draw(Graphics g)
    {
        g.drawImage(redShot, x, y, null);
    }
}


