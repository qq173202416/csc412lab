
package TankGame;

import java.awt.*;
import java.awt.image.ImageObserver;


public class Bullet extends GameObject implements Runnable{

    int BulletSpeed;
    boolean isAlive = true;
    int direction;// 0:up 1:right 2:down 3:left
    Image BulletImg;

    public Bullet(Image img, int x, int y, int width, int height, int direction) {
        super(img, x, y, width, height);
        this.direction = direction;
        this.BulletSpeed = 4;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    

    public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Image getBulletImg() {
		return BulletImg;
	}

	public void setBulletImg(Image bulletImg) {
		BulletImg = bulletImg;
	}

	public void drawBullet(Graphics g) {
        g.drawImage(BulletImg, x, y, null);
    }

    public void run() {
        while (true) {
            switch (direction) {
                case 0://up
                    while (y > 0) {

                        y -= BulletSpeed;
                        
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                        }
                    }

                    break;

                case 1://right
                    while (x < 1030) {
                        x += BulletSpeed;

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                        }
                    }

                    break;

                case 2://down

                    while (y < 830) {
                        y += BulletSpeed;

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                        }
                    }

                    break;

                case 3://left
                    while (x > 0) {
                        x -= BulletSpeed;

                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                        }
                    }

                    break;
            }
            if(x<0 || x>1000 || y<0 || y>800){
            	isAlive =false;
            }
            
            if (isAlive == false) {
                break;
            }

        }
    }

}
