import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HgGsa {
	static Random random = new Random();

	public static Board sort(Board board, List<Point> blackPoints, boolean gravity, Point centerOfMass, int gravityConst) {

		Board O2 = onePointCrossover(board, blackPoints);
		
		//if gravity is on -> apply it
		if(gravity) {
			O2 = GSA.gravity(O2, centerOfMass, gravityConst);
		}
		
		return O2;
	}
	
	//cross two points, check which child is more fit, return new board with children.
	private static Board onePointCrossover(Board board, List<Point> blackPoints) {
		
		Board b1 = new Board(board.fields.length, board.fields[0].length, 0);

		List<Point> cPoints = new ArrayList<Point>();
		
		for(int i =0;i<blackPoints.size();i++) {
			//pair with random black point
//			Point p = blackPoints.get(random.nextInt(blackPoints.size()));
			
			//pair with closest black point
//			Point p = (i < blackPoints.size()-1) ? blackPoints.get(i+1): blackPoints.get(0);
			
			//pair with a semi-determined point
			Point p = (blackPoints.get((i+ random.nextInt(10)) % blackPoints.size()));
			
			
			Point x = crossX(blackPoints.get(i), p);
			Point y = crossY(blackPoints.get(i), p);
			
			//try to avoid points collapsing into one too fast
			if(x.fitness>y.fitness) {
//				if(!cPoints.contains(x)) {
					x.value=1;
					cPoints.add(x);
//				}
//				else {
//					//point already in list -> default -> parent survives 
//					cPoints.add(blackPoints.get(i));
//				}
				
				
			}else {
				//second child is fitter
//				if(!cPoints.contains(y)) {
					y.value=1;
					cPoints.add(y);
//				}else {
//					//point already in list -> default -> parent survives 
//					cPoints.add(blackPoints.get(i));
//				}
			}
					
		}

		
		b1.populate(cPoints);
		System.out.println( cPoints.size());
		
		return b1;
	}

	private static Point crossX(Point point, Point point2) {
		
		return new Point(point2.positionX, point.positionY, 1);
	}
	private static Point crossY(Point point, Point point2) {
		
		return new Point(point.positionX, point2.positionY, 1);
	}


}
