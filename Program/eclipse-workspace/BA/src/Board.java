import java.util.List;

//the whole board on which our points will be placed and rearanged
public class Board {
	
	Point[][] fields;
	int numberOfBlackPoints = 0;
	
	Board(int x, int y, int b){
		
		
		this.fields = new Point[x][y];
		
				
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				fields[i][j] = new Point(i,j, blackPoint(b));
			}
		}
		
		
	}
	
	

	private int blackPoint(int b) {

		if(numberOfBlackPoints < b) {
			if(Math.random()*130 < 3) {
				
				numberOfBlackPoints++;
				
				return 1;
			}
		}
			
		return 0;
	}



	public void populate(List<Point> cPoints) {
		// TODO Auto-generated method stub
		cPoints.forEach(Point -> this.fields[Point.positionX][Point.positionY]=Point);
		
	}


}
