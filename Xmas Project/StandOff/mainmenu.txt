import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StandOff{
    public static void main(String[] args) throws IOException {





            JPanel panel = new JPanel ( );
            JFrame frame = new JFrame ( );
            JLabel label = new JLabel (new ImageIcon ("images//MainMenu.jpg"));
            label.setSize (1970,1200);
            label.setLocation (-50,0);

            frame.setSize (1920, 1200);
            frame.setResizable (false);
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            frame.add(label);
            frame.setLayout (null);


            panel.setLayout (new FlowLayout ( ));
            frame.setBackground (Color.blue);
            frame.setVisible (true);
            panel.setVisible (true);
            label.setVisible (true);

            JButton startGame = new JButton ("Play Game");

            startGame.setFont (new Font ("Impact", Font.PLAIN, 30));
            startGame.setSize (300, 100);
            startGame.setLocation (810, 300);

            frame.add (startGame);
            startGame.setBackground (Color.LIGHT_GRAY);

            //frame.add (this);


            startGame.addActionListener (new ActionListener ( ) {
                @Override
                public void actionPerformed(ActionEvent e) {

                frame.setVisible (false);

                    try {
                        GooEee game = new GooEee ( );
                    } catch (IOException e1) {
                        e1.printStackTrace ( );
                    }


                }
            });



    }

//    public void paint(Graphics g)
//    {
//        Image MainMenu  = new ImageIcon("images/MainMenu.jpg").getImage();
//        g.drawImage(MainMenu, 0, 0, null);
//    }

}
