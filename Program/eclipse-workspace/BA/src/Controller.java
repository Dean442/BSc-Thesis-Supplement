import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//main controller. Adjustments to the board and controlling tasks should be done here.

public class Controller {
	//how many times the algorithm should be used
	static int IterMax=1500;
	static int xAxis = 800;
	static int yAxis = 600;
	static int nrBlackPoints= 20000;
	private static List<Point> blackPoints;
	static double targetedReduction = 0.0001;
	static int[] lastReductions = new int [4];
	
	//change where the center of mass should be
	static Point centerOfMass = new Point(400, 300, 0);
	
	//if false -> only GA is active
	static boolean gravity = true;
	static int gravityConst = 2;
	
	
	
	public static void main(String[] args) {
		
		//init visualizer
		Visualizer vis = new Visualizer(xAxis, yAxis);
		//init board
		Board board = initboard(xAxis, yAxis, nrBlackPoints);
		
		//timer
		long startTime = System.currentTimeMillis();
		long elapsedTime =0L;
		
		
		for(int iter = 0; iter < IterMax; iter++) {
			updateLoop(vis, board);
			
			System.out.println(blackPoints.size());
			
//			System.out.println(iter);
			if(blackPoints.size()==gravityConst+1) {
				System.out.println("Acceptable reduction aqquired" + "\n" + "itterations needed: " + iter);
				System.out .println("Time to completetion: " + ((new Date()).getTime() - startTime));
				break;
			}
			//keep check of reduction size
			lastReductions[iter%4]= blackPoints.size();
			
			
			// no further reduction -> stop
//			if(lastReductions[Math.abs(iter-3)%4] == lastReductions[iter%4]) {
//				System.out.println("No further reduction" + "\n" + "itterations needed: " + iter);
//				System.out .println("Time to completetion: " + ((new Date()).getTime() - startTime));
//				break;
//			}
				
			
//			double reduction = (double)blackPoints.size()/ (double)nrBlackPoints;
//	
//			
//			if(reduction < targetedReduction) {
//				System.out.println("Acceptable reduction aqquired" + "\n" + "itterations needed: " + iter);
//				break;
//			}
			
			board = HgGsa.sort(board,blackPoints, gravity, centerOfMass, gravityConst);
			
			//board = GSA.gravity(board, centerOfMass, gravityConst);
			
			
		}
	
	}
	

	private static void updateLoop(Visualizer vis, Board board) {
		updateBlackPoints(board);
		
		//determines fitness of black points
		determineFitness(board);
//		System.out.println(blackPoints.size());

		//draw frame
		vis.draw(board);
		
	}


	private static void determineFitness(Board board) {
//		int overallFit=0;
		blackPoints.forEach(Point -> Point.countNeighbours(board));
		
//		blackPoints.forEach(Point -> System.out.println(Point.fitness));
//		for(int i =0; i<blackPoints.size();i++) {
//			overallFit += blackPoints.get(i).fitness;
//		}
//		System.out.println("Fitness of the board:"+overallFit);
		
	}



	private static void updateBlackPoints(Board board) {
		
		blackPoints = new ArrayList<Point>();
		for(int i=0; i<xAxis; i++) {
			for(int j=0; j<yAxis; j++) {
				if(board.fields[i][j].value == 1)
					blackPoints.add(board.fields[i][j]);
					
			}
		}
	}


	private static Board initboard(int x, int y, int z) {

		Board b = new Board(x, y, z);
		System.out.println("So many black poits: " + z);
		return b;

		
	}

}
