import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StandOff{
    public static void main(String[] args) throws IOException {



        //BGmusic();

        JPanel panel = new JPanel ( );
        JFrame frame = new JFrame ( );
        JLabel picture = new JLabel (new ImageIcon ("images//MainMenu.jpg"));
        picture.setSize (1950,1200);
        picture.setLocation (-40,0);

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

        startGame.setFont (new Font ("Impact", Font.PLAIN, 35));
        startGame.setSize (300, 75);
        startGame.setLocation (810, 350);
        startGame.setForeground(Color.white);


        howToPlay.setFont (new Font ("Impact", Font.PLAIN, 35));
        howToPlay.setSize (300, 75);
        howToPlay.setLocation (810, 460);
        howToPlay.setForeground(Color.white);

        frame.add (startGame);
        frame.add (howToPlay);

        startGame.setBackground (Color.DARK_GRAY);
        howToPlay.setBackground (Color.DARK_GRAY);

        //frame.add (this);


        startGame.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setVisible (false);


                try {
                    GooEee game = new GooEee ( );
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



    }

//    public void paint(Graphics g)
//    {
//        Image MainMenu  = new ImageIcon("images/MainMenu.jpg").getImage();
//        g.drawImage(MainMenu, 0, 0, null);
//    }

}