
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1442798787354930462L;
	
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9; 
	
	private Thread thread;
	private boolean running = false;
	
	//private Handler handler;
	//private Random r; 
	//private HUD hud;
	private Menu menu;
	
	
	public static STATE  gameState = STATE.MENU;
	
	
	//Contructor fot the Game class
	public Game() {
		
		//Here we create a Handler object that late will be passed to KeyInput
		
		//handler = new Handler();
		//hud = new HUD(handler);
		menu = new Menu();
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);
		
		//MouseInput player = new MouseInput(handler);
		//MouseInput.Move move = player.new Move();
		//this.addMouseMotionListener(move);
		
		//MouseInput.Click click = player.new Click();
		//this.addMouseListener(click);
	
		 new Window(WIDTH, HEIGHT,"Game",this); 
	}

	//The method that start the thread?
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join(); 		//killing the thread
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//It was copy-pasted.. except the requestFocus()
	public void run() {
		this.requestFocus();
		/*this.requestFocus() means that you don't have to click on the window to have access to the keyboard
		 * as the game starts, so it's much easier than before.*/
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
				Toolkit.getDefaultToolkit().sync();
			}
			frames++;
			if(System.currentTimeMillis() - timer >1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	//Behavior changes per tick
	private void tick() {
		//update each bevarior per frame
	
		if(gameState== STATE.GAME) {
			
			//hud.tick();
			//handler.tick();	
			
		}else if(gameState == STATE.MENU ) {
			
			menu.tick();
		}	
	}

	
	//Rendering frames
	private void render() {
		//update each appearance per frame
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		//handler.render(g);
		
		if(gameState == STATE.GAME) {
			//hud.render(g);
			
		}else if(gameState == STATE.MENU) {
			
			menu.render(g);
		}
		g.dispose();
		bs.show();
	}
	
	
	//Helpful method for (collision effect) game
	public static float clamp(float var, float min, float max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String[] args) {
	
		new Game();
	}

}