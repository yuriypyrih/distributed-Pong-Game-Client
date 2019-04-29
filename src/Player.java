
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


//import entities.Trail;

public class Player extends GameObject{
	
	
	//private Handler handler;
	//private TaskManager task_manager ;
	//private Spawn spawner;
	private int stars = 0 ;
	public static boolean poisoned = false;
	public static boolean immune = false; /*CHANGE THIS TO TRUE WHENEVER YOU WANT TO TEST A LEVEL*/
	public static Color PLAYER_COLOR = Color.WHITE;


	//Contructor
	public Player(float  x, float y, ID id) {
		super(x, y, id);
		//this.handler = handler;
		//this.spawner = spawner;
		//task_manager = new TaskManager(handler);
		
	}
	
	
	
	public int getStars() {
		return stars;
	}
	
	public void setStart(int stars) {
		this.stars = stars;
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
		
		x = Game.clamp((int)x, 0, Game.WIDTH - 35);
		y = Game.clamp((int)y, 0, Game.HEIGHT - 60);
		
		
		
		 collision(); //to check if there is any collision happening
		
		
	}
	
	private void collision() {
		
	}//end of collision();
	
	public void render(Graphics g) {
		//Appearance
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x,(int) y, 32, 32);
	}
	
	
	
}//end of Player class