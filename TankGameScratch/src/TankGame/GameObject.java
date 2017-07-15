package TankGame;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.*;
import javax.swing.*;



public class GameObject {
	protected int x, y, width, height;
	protected Image img;
	
	public GameObject(Image img, int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = img;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	/*
	public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img, x, y, obs);
   
   }
	*/
	

        
}
