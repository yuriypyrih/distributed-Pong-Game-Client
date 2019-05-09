
public class Spawner {

	private Handler handler;
	
	public Spawner(Handler handler) {
		this.handler = handler;
	}
	
	public void startGame(){
		handler.getMainPlayer().setX(10);
		handler.getMainPlayer().setY(10);
	}
	
	public void endGame() {
		//handler.clearGame();
	}
}
