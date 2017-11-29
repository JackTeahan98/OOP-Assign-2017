import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WinScreen {
    public static void main(String[] args) throws IOException {


        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        JLabel picture = new JLabel(new ImageIcon("images//MainMenu.jpg"));
        picture.setSize(1920, 1200);
        picture.setLocation(0, 0);

        frame.setSize(1920, 1200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(picture);
        frame.setLayout(null);


        panel.setLayout(new FlowLayout());
        frame.setBackground(Color.blue);
        frame.setVisible(true);
        panel.setVisible(true);
        picture.setVisible(true);

        JButton startGame = new JButton("Play Game");
        JButton howToPlay = new JButton("How to Play...");
        JButton quitting = new JButton("Quit Game");


        startGame.setFont(new Font("Impact", Font.PLAIN, 35));
        startGame.setSize(300, 75);
        startGame.setLocation(825, 275);
        startGame.setForeground(Color.cyan);


        howToPlay.setFont(new Font("Impact", Font.PLAIN, 35));
        howToPlay.setSize(300, 75);
        howToPlay.setLocation(825, 375);
        howToPlay.setForeground(Color.cyan);

        quitting.setFont(new Font("Impact", Font.PLAIN, 35));
        quitting.setSize(300, 75);
        quitting.setLocation(825, 475);
        quitting.setForeground(Color.cyan);


        frame.add(startGame);
        frame.add(howToPlay);
        frame.add(quitting);

        startGame.setBackground(Color.DARK_GRAY);
        howToPlay.setBackground(Color.DARK_GRAY);
        quitting.setBackground(Color.DARK_GRAY);

    }
}