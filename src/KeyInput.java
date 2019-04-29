import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	//private Handler handler;
	private Game game;
	private Player mainPlayer;
	
	public static boolean WASDkeys = true;
	
	private boolean[] keyDown = new boolean[2];
	
	//Constructor for KeyInput class
	public KeyInput( Game game , Player mainPlayer) {
		//this.handler = handler;
		this.game = game;
		this.mainPlayer = mainPlayer;
		
		keyDown[0] = false; //W UP
		keyDown[1] = false; //S DOWN
		
	}
	
	/*It handles every key event on the keyboard*/
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//Example if Esc button is pressed
		
				if(key == KeyEvent.VK_ESCAPE) {
					if(Game.gameState==STATE.MENU) {
						System.exit(1);
					}
					else if(Game.gameState==STATE.GAME) {
						Game.gameState = STATE.MENU;
					}
				}
				else if(key == KeyEvent.VK_ENTER) {
					Game.gameState = STATE.GAME;
				}
				
				if(WASDkeys) {
					if(key == KeyEvent.VK_W) {mainPlayer.setVelY(-6); keyDown[0] = true;}
					if(key == KeyEvent.VK_S) {mainPlayer.setVelY(6);  keyDown[1] = true;}
				}
				
		
	}//end of keyPressed method
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		
	}//end of keyReleased Method

}//end of KeyInput class