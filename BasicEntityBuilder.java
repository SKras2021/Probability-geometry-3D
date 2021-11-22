import javax.swing.text.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class BasicEntityBuilder{


	public static IEntity createCube(double size, double centerX, double centerY, double centerZ){
		MyPoint p1 = new MyPoint(centerX + size/2, centerY - size/2, centerZ - size/2);
		MyPoint p2 = new MyPoint(centerX + size/2, centerY + size/2, centerZ - size/2);
		MyPoint p3 = new MyPoint(centerX + size/2, centerY + size/2, centerZ + size/2);
		MyPoint p4 = new MyPoint(centerX + size/2, centerY - size/2, centerZ + size/2);

		MyPoint p5 = new MyPoint(centerX - size/2, centerY - size/2, centerZ - size/2);
		MyPoint p6 = new MyPoint(centerX - size/2, centerY + size/2, centerZ - size/2);
		MyPoint p7 = new MyPoint(centerX - size/2, centerY + size/2, centerZ + size/2);
		MyPoint p8 = new MyPoint(centerX - size/2, centerY - size/2, centerZ + size/2);

		myPolygon p1 = new MyPolygon(Color.CYAN , p5, p6, p7, p8),
		myPolygon p2 = new MyPolygon(Color.WHITE, p1, p2, p6, p5),
		myPolygon p3 = new MyPolygon(Color.BLUE, p1, p5, p8, p4),
		myPolygon p4 = new MyPolygon(Color.YELLOW, p2, p6, p7, p3),
		myPolygon p5 = new MyPolygon(Color.GREEN, p4, p3, p7, p8),
		myPolygon p6 = new MyPolygon(Color.RED, p1, p2, p3, p4)

		Tetrahedron tetra = new Tetrahedron(p1, p2, p3, p4, p5, p6);

		List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();
		tetras.add(tetra);

		return new Entity(tetras);
	}
}