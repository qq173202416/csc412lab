package TankGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class GameWorld extends JFrame {
	MyPannel mp =null;
    public static void main(String[] args) 
    {
    	GameWorld tankgame1 = new GameWorld();
    }

    public GameWorld()
    {
        mp=new MyPannel();
        Thread t = new Thread (mp);
        t.start();
        this.addKeyListener(mp);
        this.setVisible(true);
        this.setSize(1030, 830);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mp);
    }

}



