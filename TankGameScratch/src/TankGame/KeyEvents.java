package TankGame;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class KeyEvents extends JPanel implements  KeyListener {;
    int x = 0, y = 0;
    Image img;
    URL url;

    public KeyEvents() {
        //this.x = x;
        //this.y = y;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.RED);
        //g.fillRect(x, y, 50, 30);
        g.drawImage(getImage(), x, y, this);
    }


    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        int code = e.getKeyCode();

        switch(code){
            case KeyEvent.VK_DOWN:
            y+=5;
            break;
        case  KeyEvent.VK_UP:
            y -= 5;
            break;
        case  KeyEvent.VK_LEFT:
            x -= 5;
            break;
        case KeyEvent.VK_RIGHT:
            x += 5;
            break;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        
    }
    
    
    public Image getImage(){
    	try {
    		
    		img=new ImageIcon("src/Resources/Tank1.gif").getImage();
    	    
    	} catch (Exception e) {
    		System.out.println("can not be found");
    	}
    	
    	return img;
    }
	
    
    public static void main(String arge[]) {

        JFrame f = new JFrame();
        KeyEvents s = new KeyEvents();
        f.add(s);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setVisible(true);

    }
}