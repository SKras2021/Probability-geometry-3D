import java.awt.Color;
import java.awt.Graphics;

public class Tetrahedron {
	
	private MyPolygon[] polygons;
	private Color color;

	public Tetrahedron(Color color, MyPolygon... polygons){
		//Array pointer wrong, fix later
		this.color = color;
		this.polygons = polygons;
		this.setPolygonColor();
		this.sortPolygons();
	}

	public Tetrahedron(MyPolygon... polygons){
		//Array pointer wrong, fix later
		this.color = new Color(40, 200, 100);
		this.polygons = polygons;
		this.sortPolygons();
	}
 
	public void render(Graphics g){
		for (MyPolygon poly: this.polygons){
			poly.render(g);
		}
	}

	public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees){
		for(MyPolygon p : this.polygons){
			p.rotate(CW, xDegrees, yDegrees, zDegrees);
		}
		this.sortPolygons();
	}

	private void sortPolygons(){
		MyPolygon.sortPolygons(this.polygons);
	}

	private void setPolygonColor(){
		for(MyPolygon poly: this.polygons){
			poly.setColor(this.color);
		}
	}

	public MyPolygon[] getPolygons(){
		return this.polygons;
	}

}