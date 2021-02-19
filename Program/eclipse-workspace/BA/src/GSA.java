import java.util.ArrayList;
import java.util.List;

public class GSA {

	public static Board gravity(Board board, Point centerOfMass, int gravityConst) {
		// TODO Auto-generated method stub
		Board toReturn = new Board(board.fields.length, board.fields[0].length, 0);
		
		List<Point> gPoints = new ArrayList<Point>();
		for(int i = 0; i<board.fields.length;i++) {
			for(int j = 0; j<board.fields[0].length;j++) {
				if(board.fields[i][j].value==1) {
					gPoints.add(norm(board.fields[i][j], centerOfMass, gravityConst));
				}
			}
		}
		
		toReturn.populate(gPoints);
		
		return toReturn;
	}

	private static Point norm(Point point, Point centerOfMass, int gravityConst) {
		// TODO Auto-generated method stub
		int x = centerOfMass.positionX-point.positionX;
		int y = centerOfMass.positionX-point.positionY;
		
		if(x==y && x==0) {
			return point;
		}
		
		if(Math.abs(x)==Math.abs(y)) {
			point.positionX = point.positionX+(gravityConst*(x/Math.abs(x)));
			point.positionY = point.positionY+(gravityConst*(y/Math.abs(y)));
		}else {
			if(Math.abs(x)<Math.abs(y)) {
				point.positionY = point.positionY+(gravityConst*(y/Math.abs(y)));
			}else {
				point.positionX = point.positionX+(gravityConst*(x/Math.abs(x)));
			}
			
		}
		
		return point;
	}

}
