import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bullet{


    public static int getLeftPlayerX() {
        return leftPlayerX;
    }

    public void setLeftPlayerX(int leftPlayerX) {
        this.leftPlayerX = leftPlayerX;
    }

    public static int getLeftPlayerY() {
        return leftPlayerY;
    }

    public void setLeftPlayerY(int leftPlayerY) {
        this.leftPlayerY = leftPlayerY;
    }

    public static int getRightPlayerX() {
        return rightPlayerX;
    }

    public void setRightPlayerX(int rightPlayerX) {
        this.rightPlayerX = rightPlayerX;
    }

    public static int getRightPlayerY() {
        return rightPlayerY;
    }

    public void setRightPlayerY(int rightPlayerY) {
        this.rightPlayerY = rightPlayerY;
    }

    static int leftPlayerX = 70;
    static int leftPlayerY = 100;
    static int rightPlayerX = 700;
    static int rightPlayerY = 700;



}