import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	//private Handler handler;
	private Game game;
	
	public static boolean WASDkeys = true;
	
	private boolean[] keyDown = new boolean[4];
	
	//Constructor for KeyInput class
	public KeyInput( Game game ) {
		//this.handler = handler;
		this.game = game;
		
		
		
	}
	
	/*It handles every key event on the keyboard*/
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Example if Esc button is pressed
		
				if(key == KeyEvent.VK_ESCAPE) {
					//example: Close the game
				}
				
		
	}//end of keyPressed method
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		
	}//end of keyReleased Method

}//end of KeyInput class