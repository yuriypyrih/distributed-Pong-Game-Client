

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


//import entities.Trail;

public class Ball extends GameObject{
	
	private ID playerID = ID.PLAYER_1;


	//Contructor
	public Ball(float  x, float y, ID id) {
		super(x, y, id);
		//this.handler = handler;
		//this.spawner = spawner;
		//task_manager = new TaskManager(handler);
		
		velY = 5;
		velX = 5;
		
	}
	
	
	
	public ID getID() {
		return playerID;
	}
	
	public void setID(ID playerID) {
		this.playerID = playerID;
	}
	
	
	public Rectangle getBounds() {
		//that's what the hitbox is, not the actuall shape of the sprite
		return new Rectangle((int)x,(int)y,32,32);
	}
	

	public void tick() {
		//handler.addObject(new Trail(x, y, ID.Trail, PLAYER_COLOR, 32, 32, 0.2f, handler));
		//Behavior
		x += velX;
		y += velY;
		
		//x = Game.clamp((int)x, 0, Game.WIDTH - 35);
		//y = Game.clamp((int)y, 0, Game.HEIGHT - 65);
		
		
		
		 collision(); //to check if there is any collision happening
		
		
	}
	
	private void collision() {
				if(y <= 0 || y >= Game.HEIGHT - 50) velY *= -1; 
				if(x <= 0 || x >= Game.WIDTH - 30) velX *= -1;
	}//end of collision();
	
	public void render(Graphics g) {
		//Appearance
		
		g.setColor(Color.WHITE);
		g.fillOval((int)x,(int) y, 32, 32);
	}
	
	
	
}//end of Player class