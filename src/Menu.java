
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;


public class Menu extends MouseAdapter implements MouseMotionListener {
	
	private Handler handler;
	
	public Menu(Handler handler) {
		this.handler = handler;
	}
	
	
	public void mousePressed(MouseEvent e) {
		//To get the cordinates of the mouse on X and Y axes
		int mx = e.getX();
		int my = e.getY();
		
	}
	
	
	public void mouseReleassed(MouseEvent e) {}
	
	
	public void mouseMoved(MouseEvent e) {}
	
	
	
	//Very usefull method determinating wether the mouse is over an area
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			if (my > y && my<y + height) {
				return true;
			}else {
				return false;
			}
		}else return false;
	}
	
	
	public void tick() {}
	
	public void render(Graphics g) {
		
		if(Game.gameState==STATE.MENU) {
				
			g.setColor( new Color(51, 102, 255));
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			
			g.setColor(Color.WHITE);
			g.drawString("Basic Game Engine. Ready to use.", 0, 15);
			g.drawString("Press Enter to Ready", 0, 30);
			//To draw the background Image to the Menu screen
			//g.drawImage(menu_background_img,0,0,null);
			
		}
	}
	
}