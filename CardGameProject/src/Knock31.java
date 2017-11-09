import javax.swing.*;
import java.net.SocketPermission;
import java.util.Scanner;

public class Knock31 {
    public static void main(String[] args)
    {
        String name;
        int i=0,age;
        double balance;
        Scanner input = new Scanner(System.in);
        int play;

        play = JOptionPane.showConfirmDialog(null,"Do you wish to Play Knock 31?");

        while(play != 1) {

            i = Integer.parseInt(JOptionPane.showInputDialog("How many players wish to play this game? (Minimum of 2)"));

            Player[] players = new Player[i];

            for (int x = 0; x < i; x++) {
                name = JOptionPane.showInputDialog("Enter Player " + (x + 1) + "'s name...");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Player " + (x + 1) + "'s age..."));
                balance = Double.parseDouble(JOptionPane.showInputDialog("Enter Player " + (x + 1) + "'s balance..."));

                players[x] = new Player(name, age, balance);
            }



            for(Card card : getDeck )
                System.out.print(card);
        }

        JOptionPane.showMessageDialog(null,"Goodbye...");

        Deck deck = getDeck();


    }


}
