//a single point that knows something about its position and the direct neighbours 
public class Point {
	
	int value;
	int positionX;
	int positionY;
	int fitness;

	Point(int x, int y, int value){
		
		// 0 or 1 to visualize in Bitmap
		 this.value = value;
		 this.positionX = x;
		 this.positionY = y;
		 this.fitness = 0;
	
		
	}
	
	void move(int x, int y, int z) {
		positionX = x;
		positionY = y;
		value = z;
	}
	
	
	int getFitness() {
		return fitness;
		
	}

	public int countNeighbours(Board board) {
		// TODO Auto-generated method stub
		int countOfNeighbours=0;
		
		//inner square
		if(positionX>0 && positionX<board.fields.length-1) {
		
			if(positionY>0 && positionY<board.fields[0].length-1) {
				if(board.fields[positionX][positionY-1].value == 1)
					countOfNeighbours++;
				if(board.fields[positionX][positionY+1].value == 1)
					countOfNeighbours++;
				if(board.fields[positionX-1][positionY-1].value == 1)
					countOfNeighbours++;
				if(board.fields[positionX-1][positionY+1].value == 1)
					countOfNeighbours++;
				if(board.fields[positionX-1][positionY].value == 1)
					countOfNeighbours++;
				if(board.fields[positionX+1][positionY].value == 1)
					countOfNeighbours++;
				if(board.fields[positionX+1][positionY-1].value == 1)
					countOfNeighbours++;
				if(board.fields[positionX+1][positionY+1].value == 1)
					countOfNeighbours++;
			}
		
		}
		//outer left without corners
		if(positionX == 0 && positionY != 0 && positionY != board.fields[0].length-1) {
			if(board.fields[positionX][positionY+1].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX][positionY-1].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX+1][positionY].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX+1][positionY+1].value == 1)
				countOfNeighbours++; 
			if(board.fields[positionX+1][positionY-1].value == 1)
				countOfNeighbours++; 
		}
		//outer right without corners
		if(positionX == board.fields.length-1 && positionY != 0 && positionY != board.fields[0].length-1){
			if(board.fields[positionX][positionY+1].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX][positionY-1].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX-1][positionY].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX-1][positionY+1].value == 1)
				countOfNeighbours++; 
			if(board.fields[positionX-1][positionY-1].value == 1)
				countOfNeighbours++; 
		}
		//outer top without corners
		if(positionX != board.fields.length-1 && positionX != 0 && positionY == 0 ){
			if(board.fields[positionX-1][positionY].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX+1][positionY].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX][positionY+1].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX-1][positionY+1].value == 1)
				countOfNeighbours++; 
			if(board.fields[positionX+1][positionY+1].value == 1)
				countOfNeighbours++; 
		}
		//outer bottom without corners
		if(positionX != board.fields.length-1 && positionX != 0 && positionY == board.fields[0].length-1 ){
			if(board.fields[positionX-1][positionY].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX+1][positionY].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX][positionY-1].value == 1)
				countOfNeighbours++;
			if(board.fields[positionX-1][positionY-1].value == 1)
				countOfNeighbours++; 
			if(board.fields[positionX+1][positionY-1].value == 1)
				countOfNeighbours++; 
		}
		//upper left corner
		if(positionX == 0 && positionY == 0) {
			if(board.fields[positionX+1][positionY].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX+1][positionY+1].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX][positionY+1].value == 1) 
				countOfNeighbours++;
		}
		//lower left corner
		if(positionX == 0 && positionY == board.fields[0].length-1) {
			if(board.fields[positionX+1][positionY].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX+1][positionY-1].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX][positionY-1].value == 1) 
				countOfNeighbours++;
		}
		//lower right corner
		if(positionX == board.fields.length-1 && positionY == board.fields[0].length-1) {
			if(board.fields[positionX-1][positionY].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX-1][positionY-1].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX][positionY-1].value == 1) 
				countOfNeighbours++;
		}
		//upper right corner
		if(positionX == 0 && positionY == 0) {
			if(board.fields[positionX+1][positionY].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX+1][positionY+1].value == 1) 
				countOfNeighbours++;
			if(board.fields[positionX][positionY+1].value == 1) 
				countOfNeighbours++;
		}
		
		
		fitness = countOfNeighbours;
		return countOfNeighbours;
	}


}
