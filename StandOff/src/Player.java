 public class Player {

        private String name;
        private double score;
        private int xPosition;
        private int yPosition;


     public String getName() {return name;}

     public void setName(String name) {this.name = name;}



     public double getScore() {return score;}

     public void setScore(double score) {this.score = score;}



     public int getxPosition() {return xPosition;}

     public void setxPosition(int xPosition) {this.xPosition = xPosition;}



     public int getyPosition() {return yPosition;}

     public void setyPosition(int yPosition) {this.yPosition = yPosition;}



     public Player() {
            this("Unknown",00.00,0,0);
        }


        public Player(String name, double score, int xPosition, int yPosition) {
            setName(name);
            setScore(score);
            setxPosition(xPosition);
            setyPosition(yPosition);
        }


        public String toString() {
            return String.format("%-20s%-20s%-20s%-20f%-20s%d-20s%d", "Name: ", getName(),
                    "\nAge: ", getAge(), "\nBalance: ", getBalance());


        }
    }

