public class Deck {

    public Deck() {
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spade"};


        Card[] deck = new Card[52];

        for (int suitCounter = 0; suitCounter < 4; suitCounter++) {

            for (int faceCounter = 0; faceCounter < 13; faceCounter++) {

                deck[(faceCounter + (suitCounter * 13))] = new Card(suits[suitCounter], faces[faceCounter], faceCounter + 2);

            }




    }
    //public int getDeck() {return deck;}
    }

}

