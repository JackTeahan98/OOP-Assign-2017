import javax.swing.*;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args)
    {
        String name;
        int i=0,age;
        double balance;
        Scanner input = new Scanner(System.in);

    System.out.println("How many players wish to play this game? (Minimum of 2)");
    i = input.nextInt();

    Player[] players = new Player[i];

    for(int x = 0; x < i; x++)
    {
        System.out.print("Enter Player "+(x+1)+ "'s name...");
        name = input.nextLine();

        input.nextLine();

        System.out.print("Enter Player "+(x+1)+ "'s age...");
        age = input.nextInt();
        System.out.print("Enter Player "+(x+1)+ "'s balance...");
        balance = input.nextFloat();

        System.out.println();

        players[x] = new Player(name,age,balance);

    }




    }
}
