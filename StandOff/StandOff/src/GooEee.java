import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GooEee extends JPanel implements ActionListener, KeyListener{





    private File shoot1 = new File("p1gun.wav");
    private File shoot2 = new File("p2gun.wav");

    private JFrame frame = new JFrame("Game");
    private JFrame MainMenuFrame = new JFrame("StandOff(TM)");

    private JPanel panel = new JPanel();


    public Player leftPlayer = new Player("Jack",10,10,"images//leftPlayer.png");
    public Player rightPlayer = new Player("Bob",1600,10,"images//rightPlayer.png");







    public GooEee()
    {
        MainMenuFrame.setSize(1920,1200);
        MainMenuFrame.setResizable(false);
        MainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuFrame.setVisible(true);

        MainMenuFrame.add(this);

        setLayout(new FlowLayout());
        MainMenuFrame.setBackground(Color.blue);

        MainMenuFrame.addKeyListener(this);



        frame.setSize(1920,1200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(this);

        setLayout(new FlowLayout());
        frame.setBackground(new Color(52, 46, 47));

        frame.addKeyListener(this);
    }



    public void paint(Graphics graphics)
    {graphics.setColor(new Color(52, 46, 47));
     graphics.fillRect(0,0,1920,1800);
        leftPlayer.drawModel(graphics);
        rightPlayer.drawModel(graphics);
    }



     static void shooting1(File shoot1)
    {
       try{
           Clip clip = AudioSystem.getClip();
           clip.open(AudioSystem.getAudioInputStream(shoot1));
           clip.start();

           Thread.sleep(clip.getMicrosecondLength()/1000);
       }catch(Exception e)
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
        }



        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {

        }

        else if (e.getKeyCode() == KeyEvent.VK_NUMPAD0)
        {

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





}

