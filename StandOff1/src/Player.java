import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends JPanel{

    private String name;
    private double score;
    private int xPosition;
    private int yPosition;
    private BufferedImage player;





    public String getName()
    {return name;}
    public void setName(String name)
    {this.name = name;}



 /*
     public double getScore()
     {return score;}
     public void setScore(double score)
     {this.score = score;}*/




    public int getxPosition()
    {return xPosition;}

    public void setxPosition(int xPosition)
    {this.xPosition = xPosition;}



    public int getyPosition()
    {return yPosition;}

    public void setyPosition(int yPosition)
    {this.yPosition = yPosition;}


    public BufferedImage getImage()
    {return player;}
    public void setImage(BufferedImage player)
    {this.player = player;}






    public Player()
    {this("Unknown",0,0,null);}


    public Player(String name, int xPosition, int yPosition, BufferedImage player) {
        setName(name);
        setxPosition(xPosition);
        setyPosition(yPosition);
        setImage(player);
    }

    public void drawPlayer(Graphics g){
        ImageIcon img = new ImageIcon(player);
        g.drawImage(img.getImage(),getxPosition(),getyPosition(),null);
    }




    //public String toString() {
    //return String.format("%-20s%-20s%-20s%-20f%-20s%d-20s%d", "Name: ", getName(),
    //"\nAge: ", getAge(), "\nBalance: ", getBalance());


}
