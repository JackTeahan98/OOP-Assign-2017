import java.io.*;
import sun.audio.*;



/*****************************************************
 *    Title: Java sound example - how to play a sound file in Java
 *    Author: Alvin Alexander
 *    Site owner/sponsor: Alvin Alexander.com
 *    Date: June 3 2016
 *    Availability: http://alvinalexander.com/java/java-audio-example-java-au-play-sound (Accessed 29 November 2016)
 *****************************************************/

//Code retrieved by John Brosnan who helped me understand the code by explaining it//

public class MusicFilePlayer
{
    public static void player1Sound(String path) throws Exception
    {
        // open the sound file as a Java input stream
        String p1sound = "audio/p2l.wav";
        InputStream in = new FileInputStream(p1sound);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }

    public static void playerHit1(String path) throws Exception
    {

        String p1sound = "audio/Shout1.wav";
        InputStream in = new FileInputStream(p1sound);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public static void playerHit2(String path) throws Exception
    {

        String p1sound = "audio/Shout2.wav";
        InputStream in = new FileInputStream(p1sound);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }



    public static void player2Sound(String path) throws Exception
    {

        String p1sound = "audio/p1gun.wav";
        InputStream in = new FileInputStream(p1sound);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public static void mainSound(String path) throws Exception
    {
        String gongFile = "audio/WgameplayMusic.wav";
        InputStream in = new FileInputStream(gongFile);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public static void electricFence(String path) throws Exception
    {
        String gongFile = "audio/ESPARK1.wav";
        InputStream in = new FileInputStream(gongFile);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

}