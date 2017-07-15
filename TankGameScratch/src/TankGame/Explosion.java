package TankGame;

public class Explosion {
	int x, y;
	int life = 12;
	boolean isLive =true;
	
	public Explosion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void lifeDown(){
		if(life > 0)
			life--;
		else
			isLive =false;
	}
}
