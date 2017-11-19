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

public class GooEee extends JPanel implements ActionListener, KeyListener, Runnable{

    int x=50;

    private JFrame frame = new JFrame("StandOff(TM)");
    private JPanel panel = new JPanel();



        public Player leftPlayer = new Player("Jack", 10, 100,ImageIO.read(new File("images/leftPlayer.png")));
        public Player rightPlayer = new Player("Bob", 1000, 100,ImageIO.read(new File("images/rightPlayer.png")));
        BufferedImage BG = new BufferedImage(ImageIO.read(new File("images/background.png")));


    Graphics g;
    Thread theThread;
    boolean gameOn;





    public GooEee() throws IOException {
        frame.setSize(1920,1200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        frame.add(this);

        setLayout(new FlowLayout());
        frame.setBackground(new Color(52, 46, 47));

        frame.addKeyListener(this);
        gameOn = true;
        start();


    }





    public void paint(Graphics graphics)
    {graphics.drawImage(BG,0,0,null);
     leftPlayer.drawPlayer(graphics);
     rightPlayer.drawPlayer(graphics);
        graphics.setColor(Color.RED);
        graphics.fillOval(x + 200,x + 35,25,25);
        x+=2;
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
            leftPlayer.setyPosition(leftPlayer.getyPosition() - 200);



        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            leftPlayer.setyPosition(leftPlayer.getyPosition() + 200);

            //hitBottomWall();


        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            rightPlayer.setyPosition(rightPlayer.getyPosition() - 200);
            //hitTopWall();


        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            rightPlayer.setyPosition(rightPlayer.getyPosition() + 200);
            //hitBottomWall();


        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            leftPlayer.setxPosition(leftPlayer.getxPosition() - 150);

            //wallHitDetection();


        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            leftPlayer.setxPosition(leftPlayer.getxPosition() + 150);

            //wallHitDetection();


        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rightPlayer.setxPosition(rightPlayer.getxPosition() - 150);

            //wallHitDetection();


        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPlayer.setxPosition(rightPlayer.getxPosition() + 150);


            //wallHitDetection();
        }


        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            run();
            start();
        }



        repaint();
    }



    @Override
    public void keyReleased(KeyEvent e) {

             if(e.getKeyCode() == KeyEvent.VK_W) {}
        else if(e.getKeyCode() == KeyEvent.VK_S) {}

        else if(e.getKeyCode() == KeyEvent.VK_UP) {}
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){}

    }

    public void hitTopwall()
    {
        while(leftPlayer.getyPosition() < -1)
        {
        //leftPlayer.setyPosition(leftPlayer.getyPosition() == 0);
        }
    }



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

    public void run()
        {
        g = getGraphics();

        while(gameOn)
        {
            try
            {
                paint(g);

                Thread.sleep(15);
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
        System.out.println("Game now over!");

    }

    //JB - As the class implements the Runnable interface, this method will be called automatically when an instance of it is created
    //in the main() above. It basically creates a new Thread object, links it with the game instance and sets the thread in motion
    //with the call to start() on the thread reference

    public void start()
    {
        if (theThread == null)
        {
            System.out.println("Creating new thread");
            theThread = new Thread(this);
            theThread.start();
        }
    }



}
