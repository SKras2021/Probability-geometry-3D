import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class ComplexEntityBuilder{
	public static IEntity createCubes(double size, double centerX, double centerY, double centerZ, int[][] pastValues, int lw){
		List<Tetrahedron> tetras = new ArrayList<Tetrahedron>();

		double cubeSpacing = 1;
		probGeom3D pg3 = new probGeom3D();
		Display dis = new Display();

		for(int i = 0; i < lw; i++){
			double cubeCenterX = pastValues[i][0]*(size+cubeSpacing) + centerX;
			
				double cubeCenterY = pastValues[i][1]*(size+cubeSpacing) + centerY;
				
					//if (i == 0, j == 0, k == 0) continue;
					double cubeCenterZ = pastValues[i][2]*(size+cubeSpacing) + centerZ;
					MyPoint p1 = new MyPoint((cubeCenterX - size/2), (cubeCenterY - size/2), (cubeCenterZ - size/2));
					MyPoint p2 = new MyPoint((cubeCenterX - size/2), (cubeCenterY - size/2), (cubeCenterZ + size/2));
					MyPoint p3 = new MyPoint((cubeCenterX - size/2), (cubeCenterY + size/2), (cubeCenterZ - size/2));
					MyPoint p4 = new MyPoint((cubeCenterX - size/2), (cubeCenterY + size/2), (cubeCenterZ + size/2));
					MyPoint p5 = new MyPoint((cubeCenterX + size/2), (cubeCenterY - size/2), (cubeCenterZ - size/2));
					MyPoint p6 = new MyPoint((cubeCenterX + size/2), (cubeCenterY - size/2), (cubeCenterZ + size/2));
					MyPoint p7 = new MyPoint((cubeCenterX + size/2), (cubeCenterY + size/2), (cubeCenterZ - size/2));
					MyPoint p8 = new MyPoint((cubeCenterX + size/2), (cubeCenterY + size/2), (cubeCenterZ + size/2));

					MyPolygon p01 = new MyPolygon(Color.CYAN, p5, p6, p8, p7);
					MyPolygon p02 = new MyPolygon(Color.WHITE, p2, p4, p8, p6);
					MyPolygon p03 = new MyPolygon(Color.BLUE, p3, p4, p8, p7);
					MyPolygon p04 = new MyPolygon(Color.YELLOW, p1, p2, p6, p5);
					MyPolygon p05 = new MyPolygon(Color.GREEN, p1, p2, p4, p3);
					MyPolygon p06 = new MyPolygon(Color.RED, p1, p3, p7, p5);

					Tetrahedron tetra = new Tetrahedron(p01, p02, p03, p04, p05, p06);
					tetras.add(tetra);
					
			
		}
		
		//
		return new Entity(tetras);
	}
}