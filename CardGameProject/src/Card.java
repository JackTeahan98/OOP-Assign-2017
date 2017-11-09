public class Card {

    //attributes//
    private String face;
    private String suit;
    private int value;


    //setters//
    public void setFace(String face)
    {this.face = face;}

    public void setSuit(String suit)
    {this.suit = suit;}

    public void setValue(int value)
    {this.value = value;


        if(getFace().equals("Jack") || getFace().equals("Queen") || getFace().equals("King"))
        {this.value = 10;}

        else if(getFace().equals("Ace"))
        {this.value = 11;}
    }


    //getters//
    public String getFace()
    {return face;}

    public String getSuit()
    {return suit;}

    public int getValue()
    {return value;}


    //no arg constructor//
    public Card()
    {
    this("Unkknown Value","Unknown Suit",0);
    }


    //3 arg constructor//
    public Card(String face, String suit, int value)
    {
    setFace(face);
    setSuit(suit);
    setValue(value);
    }

}
