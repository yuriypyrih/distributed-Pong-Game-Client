import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	/*what it does it Renders all objects of the entire LinkedList in the Game
	 * UPDATES THE GAME ALL TOGETHER, almost every object has a tick() and render() method
	 * so the Handler class "handles" and updates the classes all-together
	*/
	Player mainPlayer;
	Ball mainBall;
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();	//A LinkedList to handle our GameObject objects
	
	public Handler() {
		mainPlayer = new Player(10,10,ID.PLAYER_1);
		mainBall = new Ball(300,300,ID.BALL,this);
		
		addObject(mainPlayer);
		addObject(mainBall);
	}
	
	public void resetGame() {
		mainPlayer.setX(10);
		mainPlayer.setY(10);
	}
	
	public Player getMainPlayer() {
		return mainPlayer;
	}
	
	public void clearGame() {
		object.clear();
	}
	
	public void clearEnemy() {
	 for(int i=0 ; i < object.size(); i++) {
		removeObject(object.get(i));
		i-- ;
	 	}
	}
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			try {
				GameObject tempObject = object.get(i);
				tempObject.render(g);
			}catch(NullPointerException e) {}
		}
	}
	
	public void addObject(GameObject object) {
		System.out.println(object + " object has been added");
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		System.out.println(object + " object has been removed");
		this.object.remove(object);
	}
	
	public LinkedList<GameObject> getObjectList(){
		return object;
	}
	
	
	
	
	
	
	
	
	
}//end of Handler class