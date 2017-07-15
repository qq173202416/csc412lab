package TankGame;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class EnemyTank extends Tank implements Runnable{
	//boolean isAlive = true;
	
	public EnemyTank(Image img, int x, int y, int width, int height){
		super(img, x, y, width, height);
	}
	
	public void run(){
		while (true){
			//int time = 5;
			
			switch(direction)
	        {
	        
	        case 0://up
	        	for(int i = 0; i< 10; i++){
	        		if(y>0)
	        			y-=speed;
	        		
	        		
	        		try{
						Thread.sleep(50);
					}
					catch(Exception e){}
	        	}
	        	
	        	
	        	
	            break;
	            
	        case 1://right
	        	for(int i = 0; i< 10; i++){
	        		if(x<1000)
	        			x+=speed;
	        		
	        		
	        		try{
						Thread.sleep(50);
					}
					catch(Exception e){}
	        	}
	        	
	        	
	        	
	            break;
	            
	        case 2://down
	        	for(int i = 0; i< 10; i++){
	        		if(y<800)
	        			y-=speed;
	        		
	        		
	        		try{
						Thread.sleep(50);
					}
					catch(Exception e){}
	        	}
	        	
	        	
	        	
	            break;

	        case 3://left
	        	for(int i = 0; i< 10; i++){
	        		if(x>0)
	        			x-=speed;
	        		
	        		
	        		try{
						Thread.sleep(50);
					}
					catch(Exception e){}
	        	}
	        	
	        	
	        	
	            break;
	        }
			
			direction = (int)( Math.random()*4);
			//System.out.println(direction);
			
			if(!isLive)
				break;
		}
		
		
	}
	
}
