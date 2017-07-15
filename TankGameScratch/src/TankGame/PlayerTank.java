package TankGame;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;

public class PlayerTank extends Tank{
	protected Bullet bullet;
	protected Vector<Bullet> bulletSet= new Vector<Bullet>();
	protected Image bulletImg;
	
	public PlayerTank(Image img, int x, int y, int width, int height){
		super(img, x, y, width, height);
	}
	
	//move up
    public void moveUp()
    {
        y-=speed;
    }
    //move right
    public void moveRight()
    {
        x+=speed;
    }
    //move down
    public void moveDown()
    {
        y+=speed;
    }
    //move left
    public void moveLeft()
    {
        x-=speed;
    }
    
    public void fire(){
    	try {
    		
    		bulletImg=new ImageIcon("src/Resources/Shell.gif").getImage();
    	    
    	} catch (Exception e) {
    		System.out.println("can not be found");
    	}
    	
    	bullet = new Bullet(bulletImg, x, y, width, height, direction);
    	bulletSet.add(bullet);
    	Thread t = new Thread(bullet);
    	t.start();
    }
    
    public Vector<Bullet> getBulletSet(){
    	return this.bulletSet;
    }

}
