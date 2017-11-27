import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bullet extends JFrame implements KeyListener, Runnable{


    int NumberOfBullets = 0;


    int frameW = 1920, frameH = 1200;



    int leftPlayerX = 70;
    int leftPlayerY = 100;
    int rightPlayerX = 700;
    int rightPlayerY = 700;



    Thread thread = new Thread(this);


    public Bullet()
    {
        setSize(frameW,frameH );
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            isShot[NumberOfBullets] = true;
            leftBulletX[NumberOfBullets] = leftPlayerX+220;
            leftBulletY[NumberOfBullets] = leftPlayerY +26;
            NumberOfBullets++;

            if(NumberOfBullets>leftBulletX.length -1)
                NumberOfBullets = 0;
        }



        else if(e.getKeyCode() == KeyEvent.VK_NUMPAD0)
        {
            isShot[NumberOfBullets] = true;
            rightBulletX[NumberOfBullets] = rightPlayerX-65;
            rightBulletY[NumberOfBullets] = rightPlayerY + 45;
            NumberOfBullets++;

            if(NumberOfBullets>rightBulletX.length -1)
                NumberOfBullets = 0;
        }



        else if(e.getKeyCode() == KeyEvent.VK_W)
        {leftPlayerY -=150;
            leftBulletY[NumberOfBullets] = leftPlayerY;}

        else if(e.getKeyCode() == KeyEvent.VK_S)
        {leftPlayerY +=150;
            leftBulletY[NumberOfBullets] = leftPlayerY;}


        else if(e.getKeyCode() == KeyEvent.VK_A)
        {leftPlayerX -=150;
            leftBulletY[NumberOfBullets] = leftPlayerY;}

        else if(e.getKeyCode() == KeyEvent.VK_D)
        {leftPlayerX +=150;
            leftBulletY[NumberOfBullets] = leftPlayerY;}





        else if(e.getKeyCode() == KeyEvent.VK_UP)
        {rightPlayerY -=150;
            rightBulletY[NumberOfBullets] = rightPlayerY;}

        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {rightPlayerY +=150;
            rightBulletY[NumberOfBullets] = rightPlayerY;}


        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {rightPlayerX -=150;
            rightBulletY[NumberOfBullets] = rightPlayerY;}

        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {rightPlayerX +=150;
            rightBulletY[NumberOfBullets] = rightPlayerY;}


    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }







    @Override







    public static void main(String[] args)
    {
        new Bullet();
    }


}