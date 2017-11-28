import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;



public class Bullet{

private String type;
private int bulletXCo;
private int bulletYCo;
private BufferedImage bullet;

    public String getType()
    { return type; }
    public void setType(String type)
    { this.type = type; }



    public int getBulletX()
    { return bulletXCo; }
    public void setBulletX(int bulletX)
    { this.bulletXCo = bulletX; }



    public int getBulletY()
    { return bulletYCo; }
    public void setBulletY(int bulletY)
    { this.bulletYCo = bulletY; }



    public BufferedImage getBullet()
    { return bullet; }
    public void setBullet(BufferedImage bullet)
    { this.bullet = bullet; }



    public Bullet()
        {this("Unknown",0,0,null);}


public Bullet(String type, int bulletX, int bulletY, BufferedImage bullet) {
        setType(type);
        setBulletX(bulletX);
        setBulletY(bulletY);
        setBullet(bullet);
        }



public void drawBullet(Graphics g){
        ImageIcon img = new ImageIcon(bullet);
        g.drawImage(img.getImage(),getBulletX(),getBulletY(),null);
        }
}