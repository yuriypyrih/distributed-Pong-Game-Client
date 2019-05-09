

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


//import entities.Trail;

public class Ball extends GameObject{
	
	//private ID playerID = ID.PLAYER_1;
	private Handler handler;


	//Contructor
	public Ball(float  x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		//this.spawner = spawner;
		//task_manager = new TaskManager(handler);
		
		velY = 5;
		velX = 5;
		
	}
	
	
	
	public ID getID() {
		return id;
	}
	
	public void setID(ID id) {
		this.id = id;
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
				
				for(int i = 0; i < handler.object.size(); i++) {
					
					GameObject tempObject = handler.object.get(i);
					
					if(tempObject.getId() == ID.PLAYER_1) {
						if(getBounds().intersects(tempObject.getBounds())) {
							float objY = tempObject.getY();
							System.out.println("Player Y: " + objY);
							System.out.println("Ball Y: " + y);
							System.out.println("Diff: " + (objY-y));
							
							//The lower the y the higher the object is
							if(objY >= y || y - objY < 54) { //Player is higher
								velY = -7;
								System.out.println("Upper most");
							}
							else if(y - objY < 70 ) {
								velY = -5;
								System.out.println("Upper middle");
							}
							else if(y - objY < 186 ) {
								System.out.println("Center middle");
								if(velY > 0) {
									velY = 5;
								}
								else {
									velY = -5;
								}
							}
							else if(y - objY < 202 ) {
								System.out.println("Lower middle");
								velY =5;
							}
							else if(y - objY <= 256 ){
								System.out.println("Lower most");
								velY =7;
							}
							velX *= -1;
						}
					}
				}
	}//end of collision();
	
	public void render(Graphics g) {
		//Appearance
		
		g.setColor(Color.WHITE);
		g.fillOval((int)x,(int) y, 32, 32);
	}
	
	
	
}//end of Player class