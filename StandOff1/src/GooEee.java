import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GooEee extends JPanel implements ActionListener, KeyListener{

    int BupJumpDistance = 150;
    int BdownJumpDistance = 150;
    int BleftJumpDistance = 150;
    int BrightJumpDistance = 150;

    int RupJumpDistance = 150;
    int RdownJumpDistance = 150;
    int RleftJumpDistance = 150;
    int RrightJumpDistance = 150;

    int NumberOfBullets = 0;

    int x=50;

    int leftBulletX[]  = new int[10];
    int leftBulletY[]  = new int[10];
    int rightBulletX[] = new int[10];
    int rightBulletY[] = new int[10];

    private JFrame frame = new JFrame("StandOff(TM)");


    boolean isShot[] = new boolean[10];





    public Player leftPlayer = new Player("Jack", 10, 50,ImageIO.read(new File("images/leftPlayer.png")));
    public Player rightPlayer = new Player("Bob", 1000, 50,ImageIO.read(new File("images/rightPlayer.png")));


    //BufferedImage BG = new BufferedImage(ImageIO.read(new File("images/background.png")));



  /*  Graphics g;
    Thread theThread;
    boolean gameOn;*/

    Image background  = new ImageIcon("images/background.jpg").getImage();
    Image leftBullet  = new ImageIcon("images/blueBullet.png").getImage();
    Image rightBullet = new ImageIcon("images/redBullet.png").getImage();


    public GooEee() throws IOException {
        frame.setSize(1920,1200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        frame.add(this);

        setLayout(new FlowLayout());
        frame.setBackground(new Color(52, 46, 47));

        frame.addKeyListener(this);



        for(int i=0; i<leftBulletX.length; i++){
            isShot[i] = false;
            leftBulletX[i] = Bullet.getLeftPlayerX()+50;
            leftBulletY[i] = Bullet.getLeftPlayerY()+10;
        }

        for(int i=0; i<rightBulletX.length; i++){
            isShot[i] = false;
            rightBulletX[i] = Bullet.getRightPlayerX()+50;
            rightBulletY[i] = Bullet.getRightPlayerY()+10;


        }

    }





    public void paint(Graphics g)
    {
        g.drawImage(background,0,0,null);

        for(int i = 0; i< leftBulletX.length; i++)
        {
            if(isShot[i])
            {
                g.drawImage(leftBullet,leftBulletX[i],leftBulletY[i],null);
            }
        }

        for(int i = 0; i< rightBulletX.length; i++)
        {
            if(isShot[i])
            {
                g.drawImage(rightBullet,rightBulletX[i],rightBulletY[i],null);
            }
        }

        //g.drawImage(leftPlayer2,Bullet.getLeftPlayerX(),Bullet.getLeftPlayerY(),null);
        //g.drawImage(rightPlayer2,Bullet.getLeftPlayerX(),Bullet.getRightPlayerY(),null);
        leftPlayer.drawPlayer(g);
        rightPlayer.drawPlayer(g);
        //g.setColor(Color.RED);
        //  g.fillOval( x + 200,x,25,25);
        //  x+=50;

    }








    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            leftPlayer.setyPosition(leftPlayer.getyPosition() - BupJumpDistance);



        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            leftPlayer.setyPosition(leftPlayer.getyPosition() + BdownJumpDistance);

            //hitBottomWall();


        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            rightPlayer.setyPosition(rightPlayer.getyPosition() - RupJumpDistance);
            //hitTopWall();


        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            rightPlayer.setyPosition(rightPlayer.getyPosition() + RdownJumpDistance);
            //hitBottomWall();


        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            leftPlayer.setxPosition(leftPlayer.getxPosition() - BleftJumpDistance);
            }

        else if (e.getKeyCode() == KeyEvent.VK_D) {
            leftPlayer.setxPosition(leftPlayer.getxPosition() + BrightJumpDistance);

            //wallHitDetection();


        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rightPlayer.setxPosition(rightPlayer.getxPosition() - RleftJumpDistance);

            //wallHitDetection();


        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPlayer.setxPosition(rightPlayer.getxPosition() + RrightJumpDistance);


            //wallHitDetection();
        }


        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {

            isShot[NumberOfBullets] = true;
            leftBulletX[NumberOfBullets] = Bullet.getLeftPlayerX()+220;
            leftBulletY[NumberOfBullets] = Bullet.getLeftPlayerY() +26;
            NumberOfBullets++;

            if(NumberOfBullets>leftBulletX.length -1)
                NumberOfBullets = 0;
        }

        else if (e.getKeyCode() == KeyEvent.VK_NUMPAD0)
        {

            isShot[NumberOfBullets] = true;
            rightBulletX[NumberOfBullets] = Bullet.getRightPlayerX()+220;
            rightBulletY[NumberOfBullets] = Bullet.getRightPlayerY() +26;
            NumberOfBullets++;

            if(NumberOfBullets>leftBulletX.length -1)
                NumberOfBullets = 0;
        }


        checkLEFTwall();
        repaint();
    }



    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W) {}
        else if(e.getKeyCode() == KeyEvent.VK_S) {}

        else if(e.getKeyCode() == KeyEvent.VK_UP) {}
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){}

    }

    public void checkLEFTwall()
    {
        while(leftPlayer.getxPosition() < -1 )
        {
        BleftJumpDistance = 0;
        BupJumpDistance = 150;
        BdownJumpDistance = 150;
        BrightJumpDistance = 150;

        RupJumpDistance = 150;
        RdownJumpDistance = 150;
        RleftJumpDistance = 150;
        RrightJumpDistance = 150;

}
    }}



    //  public void paint(Graphics graphics){
    //      graphics.drawImage(background.getImage(),0,0,null);
    //   }

    //JB - called automatically by the start() method below. Because the game needs to draw information onto the screen
    //and listen for keyboard/other events at the same time, an extra thread of execution is recommended. The run()
    //method basically ensures that the pane of the JFrame window gets painted/updated every 20 milliseconds
    //giving us 50 frames per second as such. The thread sleeps in between these updates meaning that the rest
    //of the time events can be listened for and handled without any conflict

    //thread really needed only because we need it to continually repaint() the screen if we want to draw the bullets moving as well
    //as the enemy invaders, otherwise we could have done without it as the key press actions could be set up to make calls to paint() as they go





    //   public void run()
    ///{
    //   while(true)
    //  {
    //     for(int i=0; i<leftBulletX.length; i++) {
    //        if (isShot[i])
    //          leftBulletX[i] += 20;

    //  if (leftBulletX[i] > frameW) {
    //        isShot[i] = false;
//
    //     }
    //      }


    //    for(int i=0; i<rightBulletX.length; i++) {
    //      if (isShot[i])
    //         rightBulletX[i] -= 20;

    //      if (rightBulletX[i] > frameW) {
    //        isShot[i] = false;

    //        }
    //     }



    //   try{
    //      Thread.sleep(30);
    //   }catch (InterruptedException e){}
    //   repaint();
    // }


    //JB - As the class implements the Runnable interface, this method will be called automatically when an instance of it is created
    //in the main() above. It basically creates a new Thread object, links it with the game instance and sets the thread in motion
    //with the call to start() on the thread reference






