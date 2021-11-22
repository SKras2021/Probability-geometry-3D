import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class probGeom3D{
	private EntityManager em;
	Display display;
	String[] change;
	int [][] pastValues;
	int dirX;
	int dirY;
	int dirZ;
	int totalInterations = -1;
	int tcg = 100;

	public static void main(String args){

	}

	public int[][] getArray(int lw){
		doit();
		for (int i = 0; i < lw; i++) {
			getChange(i);
		}

		return pastValues;
	}

	public void doit(){
		Scanner sc = new Scanner(System.in);
		display = new Display();
		change = new String[3];
		pastValues = new int[100000][3];
		change[0] = "0";
		change[1] = "0";
		change[2] = "0";
		 dirX = 0;
		 dirY = 0;
		 dirZ = 0;
		for (int i = 0; i < 10000; i++){
			for (int j = 0; j < 3; j++){
				pastValues[i][j] = 0;
			}
		}

	}

	public String[] getChange(int t){
				String [] error = {"error","error","error"};
				change = new String[3];
				totalInterations++;

				int whichDimChange = randomGet(3);
				int canX;
				int canY;
				int canZ;
				if (whichDimChange == 0){
					int xv = randomGet(2);
					if (xv == 0){
						canX = -1;
					} else {
						canX =1;
					}
					canY = 0;
					canZ = 0;
				} else if (whichDimChange == 1){
					canX = 0;
					int yv = randomGet(2);
					if (yv == 0){
						canY = -1;
					} else {
						canY =1;
					}
					canZ = 0;
				} else {
					canX = 0;
					canY = 0;
					int zv = randomGet(2);
					if (zv == 0){
						canZ = -1;
					} else {
						canZ =1;
					}
				}

				//int canZ = randomGet(3);
				if(!checkPastVal(pastValues, dirX+canX, dirY+canY, dirZ+canZ, totalInterations)){
					dirX += canX;
					dirY += canY;
					dirZ += canZ;
					pastValues[t][0] = dirX;
					pastValues[t][1] = dirY;
					pastValues[t][2] = dirZ;
					change[0] = "" + dirX;
					change[1] = "" + dirY;
					change[2] = "" + dirZ;
				} else {
					return error;
				}
				return change;
			
	}

	public boolean checkPastVal(int[][] pastValues, int val1, int val2, int val3, int total){
		boolean answer = false;

		for (int i = 0; i < total; i++){
			try {

				if (pastValues[i][0] == val1 && pastValues[i][1] == val2 && pastValues[i][2] == val3){
					return true;
				}
			
			} catch(NullPointerException e){

		}	
	}

		return answer;
	}

	public int randomGet(int upperBound){
		Random rand = new Random();
		int output = rand.nextInt(upperBound);
		return output;
	}

}	