import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StandOff{
    public static void main(String[] args) throws IOException {

        //Background Music Code surrounded by a tryCatch
        try {MusicFilePlayer.mainSound("audio/WgameplayMusic.wav");}
        catch (Exception e) {e.printStackTrace();}



        JPanel panel = new JPanel ( );  //Creating the JPanel
        JFrame frame = new JFrame ( );  //Creating the JFrame
        JLabel picture = new JLabel (new ImageIcon ("images//MainMenu.jpg")); //Creating the Background Image Label


        picture.setSize (1920,1200);    //Sets the Image Size and Position
        picture.setLocation (0,0);



        //Sets up basic info about the frame
        frame.setSize (1920, 1200);
        frame.setResizable (false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.add(picture);
        frame.setLayout (null);
        frame.setVisible (true);


        //Creates the menu buttons
        JButton startGame = new JButton ("Play Game");
        JButton howToPlay = new JButton ("How to Play...");
        JButton quitting = new JButton ("Quit Game");


        //Sets up basic info on game button
        startGame.setFont (new Font ("Impact", Font.PLAIN, 35));
        startGame.setSize (300, 75);
        startGame.setLocation (825, 275);
        startGame.setForeground(Color.cyan);


        //Sets up basic info on instructions button
        howToPlay.setFont (new Font ("Impact", Font.PLAIN, 35));
        howToPlay.setSize (300, 75);
        howToPlay.setLocation (825, 375);
        howToPlay.setForeground(Color.cyan);


        //Sets up basic info on quitting button
        quitting.setFont (new Font ("Impact", Font.PLAIN, 35));
        quitting.setSize (300, 75);
        quitting.setLocation (825, 475);
        quitting.setForeground(Color.cyan);


        //Adds the buttons to the frame
        frame.add (startGame);
        frame.add (howToPlay);
        frame.add (quitting);

        //Changes the buttons background color
        startGame.setBackground (Color.DARK_GRAY);
        howToPlay.setBackground (Color.DARK_GRAY);
        quitting.setBackground (Color.DARK_GRAY);




        //ActionListeber for the start button
        startGame.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {

                //closes previous frame
                frame.setVisible (false);



                //Runs the main GUI
                    try {GooEee game = new GooEee();}
                    catch (IOException e1) {e1.printStackTrace();}


            }
        });






        //Acyion Listener for the instructions button
        howToPlay.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {



                //Displays instructions in a JOp on click
                JOptionPane.showMessageDialog(null,"STAND-OFF\n\nA two Player competitive shooter where the aim of the game is to hit your enemy while avoiding oncoming bullets... \nfirst person to land 3 hits on the oponent wins the game..." +
                        "\n\n\n\n\nBLUE PLAYER CONTROLS\n\nUP : W\nDOWN : S\nLEFT : A\nRIGHT : D\nSHOOT : SPACEBAR\n\n\n\n\nRED PLAYER CONTROLS\n\nUP : UP-ARROW\nDOWN : DOWN-ARROW\nLEFT : LEFT-ARROW\nRIGHT : RIGHT-ARROW\nSHOOT : NUMPAD 0","How to Play",JOptionPane.PLAIN_MESSAGE);

            }
        });




        //Action listener for the quit button
        quitting.addActionListener (new ActionListener ( ) {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Takes in your yes or no answer (1 or 0)
                int answer = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?","Quitter",JOptionPane.YES_NO_OPTION);


                //if the answer is yes, cancel, otherwise do nothing
                if(answer == 0)
                {
                    System.exit(0);
                }

            else { }

            }
        });
}}