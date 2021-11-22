import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener{

	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	private static int scroll = 0;

	public int getX(){
		return this.mouseX;
	}
	public int getY(){
		return this.mouseY;
	}

	public boolean isScrollingUp(){
		return this.scroll == -1;
	}

	public boolean isScrollingDown(){
		return this.scroll == 1;
	}

	public void resetScroll(){
		this.scroll = 0;
	}

	public int getButton(){
		return this.mouseB;
	}

	public void resetButton(){
		this.mouseB = -1;
	}

	public void mouseWheelMoved(MouseWheelEvent event){
		scroll = event.getWheelRotation();
	}
	public void mouseDragged(MouseEvent event){
		this.mouseX = event.getX();
		this.mouseY = event.getY();
	}
	public void mouseMoved(MouseEvent event){
		this.mouseX = event.getX();
		this.mouseY = event.getY();
	}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mousePressed(MouseEvent event){
		this.mouseB = event.getButton();
	}
	public void mouseReleased(MouseEvent event){
		this.mouseB = -1;
	}
}