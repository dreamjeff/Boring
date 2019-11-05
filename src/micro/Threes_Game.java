package micro;

import java.util.*;

import common.Go;

public class Threes_Game implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	//only 1,2 | 3,6,12,24,48,96.....
	//will show what is next, next is 1 or 2 or unknow stuff from 3 to anything
	
	
	private int size=0;
	private int max = 2;
	private int[][] grid;
	private Random rand;
	private List<Integer> possibleNumbers;
	enum Direction{
		up(-1,0),
		down(1,0),
		left(0,-1),
		right(0,1);
		
		private int i;
		private int j;
		
		private Direction (int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		public int getI() {
			return this.i;
		}
		
		public int getJ() {
			return this.j;
		}
	}
	
	public Threes_Game (int size) {
		this.size = size;
		this.grid = new int[size][size];
		this.rand = new Random();
		possibleNumbers = new ArrayList<>();
		possibleNumbers.add(1);
		possibleNumbers.add(2);
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid[i].length; j++) {
				grid[i][j] = -1;
			}
		}
		addRandomNumber();
	}
	
	private void addRandomNumber() {
		int i = rand.nextInt(size);
		int j = rand.nextInt(size);
		while(grid[i][j]!=-1) {
			i = rand.nextInt(size);
			j = rand.nextInt(size);
		}
		grid[i][j] = genRandom();
	}
	
	private int genRandom() {
		return possibleNumbers.get(rand.nextInt(possibleNumbers.size()));
	}
	
	public void move(Direction direction) {
		switch(direction) {
			case up :
				moveUp();
				break;
			case down : 
				break;
			case left : 
				break;
			case right : 
				break;
		}
	}
	
	private void moveUp() {
		for(int j=0; j<grid[0].length; j++) {
			int i=0;
			while(i<grid.length-1) {
				if(grid[i][j]==-1) {
					grid[i][j]=grid[i+1][j];
					grid[i+1][j]=-1;
				}else {
					//1 and 2 situation
					if((grid[i][j]==1 && grid[i+1][j]==2) || (grid[i][j]==2 && grid[i+1][j]==1)) {
						grid[i][j]=3;
						grid[i+1][j]=-1;
					}else if(grid[i][j]==grid[i+1][j]) {
						grid[i][j]+=grid[i][j];
						grid[i+1][j]=-1;
					}else {
						//no equals 3,6,12,24
					}
				}
				i++;
			}
		}
	}
	
	private void display() {
		System.out.println();
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(j==grid[i].length-1)
					System.out.println(grid[i][j]);
				else
					System.out.print(grid[i][j] + " , ");
			}
		}
	}
}


