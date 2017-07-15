package TankGame;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;




public class Tank extends GameObject{
	//private Image planeImg;
	//GameObject tank1; 
	int speed;
	int direction;// 0:up 1:right 2:down 3:left
	boolean isLive = true;
	
	
	
	
	public boolean isLive() {
		return isLive;
	}




	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}




	public Tank(Image img, int x, int y, int width, int height){
		super(img, x, y, width, height);
		speed = 3;
		direction = 0;
	}




	public int getSpeed() {
		return speed;
	}




	public void setSpeed(int speed) {
		this.speed = speed;
	}




	public int getDirection() {
		return direction;
	}




	public void setDirection(int direction) {
		this.direction = direction;
	}	
	
	

	
}




