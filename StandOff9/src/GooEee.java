import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GooEee extends JPanel implements ActionListener, KeyListener, Runnable{



    int XjumpDistance = 150;
    int YjumpDistance = 170;

    boolean readyToFire, shot = false;
    boolean readyToFire2, shot2 = false;

    int bulletX, bulletY;
    int bulletX2, bulletY2;

    Rectangle bullet;
    Rectangle bullet2;

    int BLUElivesRemaining = 5;
    int REDlivesRemaining = 5;

    int x;



    Graphics g;
    Thread theThread;
    boolean gameOn;



    private JFrame frame = new JFrame("StandOff(TM)");
    private JPanel panel = new JPanel();

    private JFrame winFrame = new JFrame("StandOff(TM)");
    private JPanel winPanel = new JPanel();



    public Player leftPlayer = new Player("Jack", 160, 350,ImageIO.read(new File("images/leftPlayer.png")));
    public Player rightPlayer = new Player("Bob", 1450, 350,ImageIO.read(new File("images/rightPlayer.png")));
//  public Bullet leftBullet = new Bullet("Jack", 160, 350,ImageIO.read(new File("images/leftPlayer.png")));
//  public Bullet rightBullet = new Bullet("Bob", 1450, 350,ImageIO.read(new File("images/rightPlayer.png")));


    Image background  = new ImageIcon("images/background1.png").getImage();
    Image leftBullet  = new ImageIcon("images/blueBullet.png").getImage();
    Image rightBullet = new ImageIcon("images/redBullet.png").getImage();
    ImageIcon electricBlue = new ImageIcon("images/lightningBlue.png");
    ImageIcon electricRed = new ImageIcon("images/lightningRed.png");
    ImageIcon REDHIT = new ImageIcon("images/redHit.png");
    ImageIcon BLUEHIT = new ImageIcon("images/blueHit.png");
   // ImageIcon icon = new ImageIcon(GooEee.class.getResource("images/electricBlue.png"));

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




    }





    public void paint(Graphics g)
    {

        g.drawImage(background,0,0,null);
        // g.drawImage(leftPlayer2,Bullet.getLeftPlayerX(),Bullet.getLeftPlayerY(),null);
        // g.drawImage(rightPlayer2,Bullet.getLeftPlayerX(),Bullet.getRightPlayerY(),null);
        leftPlayer.drawPlayer(g);
        rightPlayer.drawPlayer(g);
        start();



        if(shot)
        {
            g.drawImage(leftBullet,bulletY+200,bulletX+7,null);
            bulletY+= 75;

        }


        if(shot2)
        {
           g.drawImage(rightBullet,bulletY2-80,bulletX2+25,null);
            bulletY2 -= 75;
        }

        rightPlayerBulletLand();
        leftPlayerBulletLand();
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
            leftPlayer.setyPosition(leftPlayer.getyPosition() - YjumpDistance);


        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            leftPlayer.setyPosition(leftPlayer.getyPosition() + YjumpDistance);


        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            rightPlayer.setyPosition(rightPlayer.getyPosition() - YjumpDistance);


        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            rightPlayer.setyPosition(rightPlayer.getyPosition() + YjumpDistance);


        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            leftPlayer.setxPosition(leftPlayer.getxPosition() - XjumpDistance);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            leftPlayer.setxPosition(leftPlayer.getxPosition() + XjumpDistance);


        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rightPlayer.setxPosition(rightPlayer.getxPosition() - XjumpDistance);


        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPlayer.setxPosition(rightPlayer.getxPosition() + XjumpDistance);


        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {


            try {
                MusicFilePlayer.player2Sound("audio/p2gun.wav");
            } catch (Exception e1) {
                e1.printStackTrace();
            }



            if (bullet2 == null)
                readyToFire2 = true;

            if (readyToFire2 == true)
                bulletY2 = rightPlayer.getxPosition();
            bulletX2 = rightPlayer.getyPosition();
            bullet2 = new Rectangle(bulletY2 + 65, bulletX2 + 45, 50, 5);
            shot2 = true;



        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            try {
                MusicFilePlayer.player1Sound("audio/p1gun.wav");
            } catch (Exception e1) {
                e1.printStackTrace();
            }


            if (bullet == null)
                readyToFire = true;

            if (readyToFire == true)
                bulletY = leftPlayer.getxPosition();
            bulletX = leftPlayer.getyPosition();
            bullet = new Rectangle(bulletY + 265, bulletX + 45, 50, 5);
            shot = true;






    }



        leftPlayerWallHit();
        rightPlayerWallHit();
      //  leftPlayerBulletLand();




        repaint();

    }






    public void shoot()
    {
     if(shot)
         bullet.x += 100;
    }

    public void shoot2()
    {
        if(shot2)
            bullet2.x -= 100;
    }





    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W) {}
        else if(e.getKeyCode() == KeyEvent.VK_S) {}

        else if(e.getKeyCode() == KeyEvent.VK_UP) {}
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){}

        else if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {

        }

    }

    public void leftPlayerWallHit(){
        if(leftPlayer.getxPosition() < -1  || leftPlayer.getxPosition() >= 750  || leftPlayer.getyPosition() < -100 || leftPlayer.getyPosition() >= 800)
        {
            try {
                MusicFilePlayer.electricFence("audio/ESPARK1.wav");
            } catch (Exception e) {
                e.printStackTrace();
            }
           ;
            JOptionPane.showMessageDialog(null,"Blue has hit the wall...\n\nRed Player wins!","ERROR 404: DeathByElectrocution.yolo",JOptionPane.PLAIN_MESSAGE,electricBlue);
            frame.setVisible(false);
            redWinScreenGUI();
        }
    }


    public void rightPlayerWallHit()
    {
        if(rightPlayer.getxPosition() > 1650  || rightPlayer.getxPosition() <= 850  || rightPlayer.getyPosition() < -100 || rightPlayer.getyPosition() >= 800)
        {
            try {
                MusicFilePlayer.electricFence("audio/ESPARK1.wav");
            } catch (Exception e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Red has hit the wall...\n\nBlue Player wins!","ERROR 404: DeathByElectrocution.yolo", JOptionPane.PLAIN_MESSAGE,electricRed);
            frame.setVisible(false);
           blueWinScreenGUI();


        }
    }


    public void leftPlayerBulletLand()
    {
        //JB - has the left players bullet hit the right player?
        if(bullet!=null && bullet.getX() >= rightPlayer.getxPosition()+250 && bullet.getX() <= frame.getWidth()         &&       bullet.getY() <= rightPlayer.getyPosition() +300 && bullet.getY() >= rightPlayer.getyPosition()) {


            try {
                MusicFilePlayer.playerHit1("audio/Shout1.wav");
            } catch (Exception e) {
                e.printStackTrace();
            }

            REDlivesRemaining --;


            JOptionPane.showMessageDialog(null,"Red has taken a hit!\n\nHe has:\n"+REDlivesRemaining+" lives remaining...","HIT!",JOptionPane.PLAIN_MESSAGE,REDHIT);

            bullet = null; //now the bullet (Rectangle) reference is set to null so we don't keep getting the same message
            shot = false; //now we set shot to false to make sure the bullet stops getting drawn on screen


            if(REDlivesRemaining ==0)
            {frame.setVisible(false);
                blueWinScreenGUI(); }
        }
    }


    public void rightPlayerBulletLand()
    {
        //JB - has the left players bullet hit the right player?
        if(bullet2!=null && bullet2.getX() <= leftPlayer.getxPosition()+250 && bullet2.getX() <= frame.getWidth()         &&       bullet2.getY() <= leftPlayer.getyPosition() +300 && bullet2.getY() >= leftPlayer.getyPosition()) {


            try {
                MusicFilePlayer.playerHit2("audio/Shout2.wav");
            } catch (Exception e) {
                e.printStackTrace();
            }

            BLUElivesRemaining --;


            JOptionPane.showMessageDialog(null,"Blue has taken a hit!\n\nHe has:\n"+BLUElivesRemaining+" lives remaining...","HIT!",JOptionPane.PLAIN_MESSAGE,BLUEHIT);

            bullet2 = null; //now the bullet (Rectangle) reference is set to null so we don't keep getting the same message
            shot2 = false; //now we set shot to false to make sure the bullet stops getting drawn on screen

            if(BLUElivesRemaining ==0)
            {
                frame.setVisible(false);
                redWinScreenGUI();}
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
                shoot();
                shoot2();
                paint(g);

                Thread.sleep(40);
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



    public void MainGUI()
    {
        JPanel panel = new JPanel ( );
        JFrame frame = new JFrame ( );
        JLabel picture = new JLabel (new ImageIcon ("images//MainMenu.jpg"));
        picture.setSize (1920,1200);
        picture.setLocation (0,0);

        frame.setSize (1920, 1200);
        frame.setResizable (false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.add(picture);
        frame.setLayout (null);


        panel.setLayout (new FlowLayout ( ));
        frame.setBackground (Color.blue);
        frame.setVisible (true);
        panel.setVisible (true);
        picture.setVisible (true);

        JButton startGame = new JButton ("Play Game");
        JButton howToPlay = new JButton ("How to Play...");
        JButton quitting = new JButton ("Quit Game");


        startGame.setFont (new Font ("Impact", Font.PLAIN, 35));
        startGame.setSize (300, 75);
        startGame.setLocation (825, 275);
        startGame.setForeground(Color.cyan);


        howToPlay.setFont (new Font ("Impact", Font.PLAIN, 35));
        howToPlay.setSize (300, 75);
        howToPlay.setLocation (825, 375);
        howToPlay.setForeground(Color.cyan);

        quitting.setFont (new Font ("Impact", Font.PLAIN, 35));
        quitting.setSize (300, 75);
        quitting.setLocation (825, 475);
        quitting.setForeground(Color.cyan);


        frame.add (startGame);
        frame.add (howToPlay);
        frame.add (quitting);

        startGame.setBackground (Color.DARK_GRAY);
        howToPlay.setBackground (Color.DARK_GRAY);
        quitting.setBackground (Color.DARK_GRAY);

        //frame.add (this);


        startGame.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setVisible (false);



                try {
                    GooEee game = new GooEee();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });






        howToPlay.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {



                JOptionPane.showMessageDialog(null,"STAND-OFF\n\nA two Player competitive shooter where the aim of the game is to hit your enemy while avoiding oncoming bullets... \nfirst person to land 3 hits on the oponent wins the game..." +
                        "\n\n\n\n\nBLUE PLAYER CONTROLS\n\nUP : W\nDOWN : S\nLEFT : A\nRIGHT : D\nSHOOT : SPACEBAR\n\n\n\n\nRED PLAYER CONTROLS\n\nUP : UP-ARROW\nDOWN : DOWN-ARROW\nLEFT : LEFT-ARROW\nRIGHT : RIGHT-ARROW\nSHOOT : NUMPAD 0","How to Play",JOptionPane.PLAIN_MESSAGE);

            }
        });




        quitting.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {

                int answer = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?","Quitter",JOptionPane.YES_NO_OPTION);

                if(answer == 0)
                {
                    System.exit(0);
                }

                else {


                }
            }
        });
    }



    public void redWinScreenGUI()
    {
        JLabel picture = new JLabel (new ImageIcon ("images//redWinbackground.png"));
        picture.setSize (1920,1200);
        picture.setLocation (0,0);

        winFrame.setSize (1920, 1200);
        winFrame.setResizable (false);
        winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        winFrame.add(picture);
        winFrame.setLayout (null);


        winPanel.setLayout (new FlowLayout ( ));
        winFrame.setBackground (Color.blue);
        winFrame.setVisible (true);
        winPanel.setVisible (true);
        picture.setVisible (true);


        JButton backToGame = new JButton ("Return to main menu...");

        backToGame.setFont (new Font ("Impact", Font.PLAIN, 100));
        backToGame.setSize (1000, 150);
        backToGame.setLocation (500, 600);
        backToGame.setForeground(Color.red);

        winFrame.add(backToGame);
        backToGame.setBackground (Color.DARK_GRAY);

        backToGame.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {

                winFrame.setVisible (false);

                MainGUI();



            }
        });

    }



    public void blueWinScreenGUI()
    {
        JLabel picture = new JLabel (new ImageIcon ("images//blueWinbackground.png"));
        picture.setSize (1920,1200);
        picture.setLocation (0,0);

        winFrame.setSize (1920, 1200);
        winFrame.setResizable (false);
        winFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        winFrame.add(picture);
        winFrame.setLayout (null);


        winPanel.setLayout (new FlowLayout ( ));
        winFrame.setBackground (Color.blue);
        winFrame.setVisible (true);
        winPanel.setVisible (true);
        picture.setVisible (true);

        JButton backToGame = new JButton ("Return to main menu...");

        backToGame.setFont (new Font ("Impact", Font.PLAIN, 120));
        backToGame.setSize (500, 75);
        backToGame.setLocation (725, 700);
        backToGame.setForeground(Color.cyan);

        winFrame.add(backToGame);
        backToGame.setBackground (Color.DARK_GRAY);

        backToGame.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {

                winFrame.setVisible (false);

                MainGUI();



            }
        });
    }



}