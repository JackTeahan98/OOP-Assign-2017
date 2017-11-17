import javax.swing.*;
import java.awt.*;

public class Player extends JPanel{

        private String name;
        private double score;
        private int xPosition;
        private int yPosition;
        private String model;





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


     public String getModel()
     {return model;}
     public void setModel(String model)
     {this.model = model;}






     public Player()
     {this("Unknown",0,0,null);}


        public Player(String name, int xPosition, int yPosition, String model) {
            setName(name);
            setxPosition(xPosition);
            setyPosition(yPosition);
            setModel(model);
        }

    public void drawModel(Graphics g){
        ImageIcon img = new ImageIcon(model);
        g.drawImage(img.getImage(),getxPosition(),getyPosition(),null);
    }




        //public String toString() {
            //return String.format("%-20s%-20s%-20s%-20f%-20s%d-20s%d", "Name: ", getName(),
                    //"\nAge: ", getAge(), "\nBalance: ", getBalance());


        }


