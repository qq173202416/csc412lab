package TankGame;

import javax.imageio.ImageIO;
import javax.swing.*;



import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

public class MyPannel extends Panel implements KeyListener, Runnable{
	PlayerTank player1;
	Image playerImg, backGround, enemyImg;
	Vector<EnemyTank> enemyTanks = new Vector();
	Vector<Explosion> bombs = new Vector();
	Vector<Image> bombImgs = new Vector();
	int enemySize = 5;
	EnemyTank enemy;
	
	
	public MyPannel(){
		//create play1
		try {
    		
    		playerImg=new ImageIcon("src/Resources/Tank1.gif").getImage();
    	    
    	} catch (Exception e) {
    		System.out.println("can not be found");
    	}
		
		player1 = new PlayerTank(playerImg, 0, 0, 30, 30);
		
		//create enemies
		try {
    		
			enemyImg=new ImageIcon("src/Resources/Tank2.gif").getImage();
			/*
			bombImgs.add( ImageIO.read(MyPannel.class.getResource("src/Resources/explosion1_1.png")));
			bombImgs.add( ImageIO.read(MyPannel.class.getResource("src/Resources/explosion1_2.png")));
			bombImgs.add( ImageIO.read(MyPannel.class.getResource("src/Resources/explosion1_3.png")));
			bombImgs.add( ImageIO.read(MyPannel.class.getResource("src/Resources/explosion1_4.png")));
			bombImgs.add( ImageIO.read(MyPannel.class.getResource("src/Resources/explosion1_5.png")));
			bombImgs.add( ImageIO.read(MyPannel.class.getResource("src/Resources/explosion1_6.png")));
			*/
			bombImgs.add( new ImageIcon("src/Resources/explosion1_1.png").getImage());
			bombImgs.add( new ImageIcon("src/Resources/explosion1_2.png").getImage());
			bombImgs.add( new ImageIcon("src/Resources/explosion1_3.png").getImage());
			bombImgs.add( new ImageIcon("src/Resources/explosion1_4.png").getImage());
			bombImgs.add( new ImageIcon("src/Resources/explosion1_5.png").getImage());
			bombImgs.add( new ImageIcon("src/Resources/explosion1_6.png").getImage());
			
    	    
    	} catch (Exception e) {
    		System.out.println("can not be found");
    	}
		
		for(int i = 0; i<enemySize; i++ ){
			enemy = new EnemyTank(enemyImg,900-i*100,700,30,30);
			Thread t = new Thread(enemy);
        	t.start();
			enemyTanks.add(enemy);
			//enemyTanks.add(new EnemyTank(enemyImg,900-i*100,700,30,30));
			
		}
		
		
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(50);
			}
			catch(Exception e){}
		
		for(int i = 0; i<player1.getBulletSet().size(); i++){
			if(!player1.getBulletSet().get(i).isAlive())
				player1.getBulletSet().remove(i);
		}
		
		//hitEnemy();
		hitEnemyTank();
			repaint();
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 1200, 900);  //backgroundColor  
		
		
		//paint tank
        this.drawTank(player1.getImg(),player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight(), 
        		g, player1.direction);
        
        //print bullet
        for(int j = 0; j<player1.getBulletSet().size(); j++){
        	//player1.getBulletSet().get(j).drawBullet(g);
        	g.drawImage(player1.getBulletSet().get(j).getImg(), player1.getBulletSet().get(j).getX(), 
        			player1.getBulletSet().get(j).getY(), this);
        }
        
        for(int i=0;i<bombs.size();i++)
        {
            
        	Explosion b=bombs.get(i);
            
            if(b.life>12)
            {
                g.drawImage(bombImgs.get(0), b.x, b.y, 30,30,this);
            }else if(b.life>10)
            {
                g.drawImage(bombImgs.get(1), b.x, b.y, 30,30,this);
            }else if(b.life>8)
            {
                g.drawImage(bombImgs.get(2), b.x, b.y, 30,30,this);
            }else if(b.life>6)
            {
                g.drawImage(bombImgs.get(3), b.x, b.y, 30,30,this);
            }else if(b.life>4)
            {
                g.drawImage(bombImgs.get(4), b.x, b.y, 30,30,this);
            }else 
            {
                g.drawImage(bombImgs.get(5), b.x, b.y, 30,30,this);
            }
            

            
            b.lifeDown();
            
            if(b.life==0)
            {
                bombs.remove(b);
            }
        }
        
        
        //paint enemy tank
        for(int i = 0; i< enemyTanks.size(); i++){
        	enemy = enemyTanks.get(i);
        	if(enemy.isLive){
        		this.drawTank(enemy.getImg(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight(),
        			g, enemy.getDirection());
        	}
        	
        }
        
        /*
        this.drawTank(enemy.getImg(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight(),
    			g, enemy.getDirection());
    	*/
	}
	
	
	
	
	//draw tank method
	public void drawTank(Image img, int x, int y, int width, int height, Graphics g, int direction){
		
		//g.setColor(Color.yellow);
		
		switch(direction)
        {
        
        case 0://up
        	g.drawImage(img, x, y, width, height, this);
            break;
        case 1://right
        	g.drawImage(img, x, y, width, height, this);
            break;
        case 2://down
        	g.drawImage(img, x, y, width, height, this);
            break;

        case 3://left
        	g.drawImage(img, x, y, width, height, this);
            break;
        }
	}
	
	
	//
	public void hitEnemyTank()
    {
        for(int i=0;i<player1.getBulletSet().size();i++)
        {
            
            Bullet myShot=player1.getBulletSet().get(i);
           
            if(myShot.isAlive())
            {
               
                for(int j=0;j<enemyTanks.size();j++)
                {
             
                    EnemyTank et = enemyTanks.get(j);

                    if(et.isLive)
                    {
                        this.hitTank(myShot, et);
                    }
                }
            }
        }
    }
	
	//track hit tank
	public void hitTank(Bullet b, Tank t){
		if(b.getX()>t.getX() &&b.getX()<t.getX()+64 && b.getY()>t.getY() && b.getY()<t.getY() + 64){
			b.setAlive(false);
			t.setLive(false);
			Explosion bomb = new Explosion(b.getX(), b.getY());
			bombs.add(bomb);
		}
	}
	
	public void keyTyped(KeyEvent e) {


    }
    
    public void keyReleased(KeyEvent e) {


    }
    
    public void keyPressed(KeyEvent e) {
    	/*
        if(e.getKeyCode() == KeyEvent.VK_W)//up
        {
            this.player1.setDirection(0);
            this.player1.moveUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D)//right
        {
            this.player1.setDirection(1);
            this.player1.moveRight();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S)//down
        {
            this.player1.setDirection(2);
            this.player1.moveDown();
        }
        else if(e.getKeyCode() == KeyEvent.VK_A)//left
        {
            this.player1.setDirection(3);
            this.player1.moveLeft();
        }
        this.repaint();// repaint
        */
    	int code = e.getKeyCode();

        switch(code){
            case KeyEvent.VK_W:
            	this.player1.setDirection(0);
                this.player1.moveUp();;
                break;
            case  KeyEvent.VK_D:
            	this.player1.setDirection(1);
                this.player1.moveRight();
                break;
            case  KeyEvent.VK_S:
            	this.player1.setDirection(2);
                this.player1.moveDown();
            	break;
            case KeyEvent.VK_A:
            	this.player1.setDirection(3);
                this.player1.moveLeft();
            	break;
            case KeyEvent.VK_J:
            	this.player1.fire();
            	break;
        }
        repaint();
    	
    }

}
