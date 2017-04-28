package space;

public class Cube {
	private int[] minCoordinates;
	// donja tacka dijagonale kocke
	private int cubeSideLength;
	// duzina stranice kocke
	private int[] maxCoordinates;

	// gornja tacka dijagonale kocke
	// kreira kocku na osnovu prosledjenih parametara
	public Cube(int[] cubeStartCoordinates, int side)
	{
		this.minCoordinates=cubeStartCoordinates;
		this.cubeSideLength=side;
		this.maxCoordinates=new int[]{minCoordinates[0]+side, minCoordinates[1]+side, minCoordinates[2]+side};
	}

	// kopira prosledjenu kocku
	public Cube(Cube cube) {
		this.minCoordinates=cube.minCoordinates;
		this.cubeSideLength=cube.cubeSideLength;
		this.maxCoordinates=cube.maxCoordinates;
				
	}

	// default konstruktor
	public Cube() {
	}

	// proverava da li se prosledjene koordinate nalaze u kocki
	public boolean checkCoordinates(int[] coordinates) {
		for (int i = 0; i < minCoordinates.length; i++) {
			if (coordinates[i] >= minCoordinates[i] && coordinates[i] <=maxCoordinates[i]) {
				return true;
			}
		}
		return false;
	}

	// proverava da li se kocke seku
	public boolean checkCubeIntersection(Cube cube) {
		if ((checkCoordinates(cube.minCoordinates) && !checkCoordinates(cube.maxCoordinates))
				|| (!checkCoordinates(cube.minCoordinates) && checkCoordinates(cube.maxCoordinates))) {
			return true;
		}
		return false;
	}

	// proverava da li se kocke dodiruju
	public boolean checkIfCubesAreTouching(Cube cube) {
		for (int i = 0; i < minCoordinates.length; i++) {
			if (getMinCoordinates()[0]<=cube.getMinCoordinates()[0] + cube.getCubeSideLength() &&
					getMinCoordinates()[0] + getCubeSideLength() >=cube.getMinCoordinates()[0] &&
					getMinCoordinates()[1] <= cube.getMinCoordinates()[1] + cube.getCubeSideLength() &&
					getMinCoordinates()[1] + getCubeSideLength()>= cube.getMinCoordinates()[1]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Drone position: (" + Integer.toString(minCoordinates[0]) + "," + Integer.toString(minCoordinates[1])
				+ "," + Integer.toString(minCoordinates[2]) + "), (" + Integer.toString(maxCoordinates[0]) + ","
				+ Integer.toString(maxCoordinates[1]) + "," + Integer.toString(maxCoordinates[2]) + ")";
	}

	// proverava da li se kocke dodiruju iznutra

	public boolean checkIfCubesAreTouchingFromInside(Cube cube) {
		if(checkIfCubesAreTouching(cube) && checkCoordinates(getCenterOfCube()) && !checkCubeIntersection(cube)) {
			return true;
		}
		return false;
	}

	// proverava da li se kocke dodiruju sa spoljasnje strane
	public boolean checkIfCubesAreTouchingFromOutside(Cube cube) {
		if(checkIfCubesAreTouching(cube) && !checkCubeIntersection(cube)){
			return true;
		}
		return false;
	}

	public int[] getCenterOfCube() {
		return new int[] {(minCoordinates[0] + maxCoordinates[0])/2, (minCoordinates[1] + maxCoordinates[1])/2,
				(minCoordinates[2] + maxCoordinates[2])/2};
	}
	
	// uvecava X
	public void increaseX(int x) {
		this.minCoordinates[0] +=x;
		this.maxCoordinates[0] +=x;
	}

	// uvecava Y
	public void increaseY(int y) {
		this.minCoordinates[1] +=y;
		this.maxCoordinates[1] +=y;
	}

	// uvecava Z
	public void increaseZ(int z) {
		this.minCoordinates[2] +=z;
		this.maxCoordinates[2] +=z;
 	}

	// smanjuje X
	public void decreaseX(int x) {
		this.minCoordinates[0] -=x;
		this.maxCoordinates[0] -=x;
	}

	// smanjuje Y
	public void decreaseY(int y) {
		this.minCoordinates[1] -=y;
		this.maxCoordinates[1] -=y;
	}

	// smanjuje Z
	public void decreaseZ(int z) {
		this.minCoordinates[2] -=z;
		this.maxCoordinates[2] -=z;
	}

	public int[] getMinCoordinates() {
		return minCoordinates;
	}

	public void setMinCoordinates(int[] minCoordinates) {
		this.minCoordinates = minCoordinates;
	}

	public int getCubeSideLength() {
		return cubeSideLength;
	}

	public void setCubeSideLength(int cubeSideLength) {
		this.cubeSideLength = cubeSideLength;
	}

	public int[] getMaxCoordinates() {
		return maxCoordinates;
	}

	public void setMaxCoordinates(int[] maxCoordinates) {
		this.maxCoordinates = maxCoordinates;
	}
}