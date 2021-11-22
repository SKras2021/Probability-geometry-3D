import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics;

public class EntityManager{
	
	private List<IEntity> entities;
	private int initialX;
	private int initialY;

	public EntityManager(){
		this.entities = new ArrayList<IEntity>();
	}

	public void init(int[][] pastVals, int lw){
		this.entities.add(ComplexEntityBuilder.createCubes(30.0, 0.0, 0.0, 0.0, pastVals, lw));
	}

	public void update(Mouse mouse){
		int x = mouse.getX();
		int y = mouse.getY();
		if(mouse.getButton() == 1){
			int xDif = x - initialX;
			int yDif = y - initialY;

			this.rotate(true, 0, -yDif, -xDif);
		} else if(mouse.getButton() == 3){
			int xDif = x - initialX;

			this.rotate(true, -xDif, 0, 0);
		}

		if(mouse.isScrollingUp()){
			PointConverter.zoomIn();
		} else if (mouse.isScrollingDown()){
			PointConverter.zoomOut();
		}

		mouse.resetScroll();
		initialX = x;
		initialY = y;
		//this.tetra.rotate(true, 0, 0, 0);
	}

	public void render(Graphics g){
		for(IEntity entity : this.entities){
			entity.render(g);
		}
	}

	private void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees){
		for(IEntity entity : this.entities){
			entity.rotate(CW, xDegrees, yDegrees, zDegrees);
		}
	}
}