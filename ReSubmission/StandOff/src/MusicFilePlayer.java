import java.io.*;
import sun.audio.*;



/*****************************************************
 *    Title: Java sound example - how to play a sound file in Java
 *    Author: Alvin Alexander
 *    Site owner/sponsor: Alvin Alexander.com
 *    Date: June 3 2016
 *    Availability: http://alvinalexander.com/java/java-audio-example-java-au-play-sound (Accessed 29 November 2016)
 *****************************************************/

//Code retrieved by John Brosnan who sent it on and helped me understand the code by explaining the different steps//
    /*JB - So you pass in the path to the audio file you wish to play
      and call playSound() as necessary from whichever class you need */
public class MusicFilePlayer
{
    public static void player1Sound(String path) throws Exception
    {
        //Code For Blue Players gun sound
        // Open the sound file as a Java input stream
        String p1sound = "audio/p2l.wav";
        InputStream in = new FileInputStream(p1sound);

        // Create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // Play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }

    public static void playerHit1(String path) throws Exception
    {
        //Code For Blue Player Getting shot at
        String p1sound = "audio/Shout1.wav";
        InputStream in = new FileInputStream(p1sound);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public static void playerHit2(String path) throws Exception
    {
        //Code For Red Player Getting shot at
        String p1sound = "audio/Shout2.wav";
        InputStream in = new FileInputStream(p1sound);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }



    public static void player2Sound(String path) throws Exception
    {
        //Code For Red Players gun sound
        String p1sound = "audio/p1gun.wav";
        InputStream in = new FileInputStream(p1sound);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public static void mainSound(String path) throws Exception
    {
        //Code For the Music
        String gongFile = "audio/WgameplayMusic.wav";
        InputStream in = new FileInputStream(gongFile);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public static void electricFence(String path) throws Exception
    {
        //Code For when either player hits
        String gongFile = "audio/ESPARK1.wav";
        InputStream in = new FileInputStream(gongFile);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

}