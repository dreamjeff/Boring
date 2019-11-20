package micro;


import java.util.*;

import common.Go;

public class Threes_Game implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Threes_Game game = new Threes_Game(4);
		game.display();
		while(!game.isFull()) {
			Direction dir = Direction.right;
			game.addRandomNumber();
			game.move(dir);
			game.display();
		}
		System.out.print(game.totalPoint());
	}

	//only 1,2 | 3,6,12,24,48,96.....
	//will show what is next, next is 1 or 2 or unknow stuff from 3 to anything
	
	
	private int size=0;
	private int nullLeft = 0;
	private int[][] grid;
	private Random rand;
	private List<Integer> possibleNumbers;
	enum Direction{
		up(1,0),
		down(-1,0),
		left(0,1),
		right(0,-1);
		
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
		this.nullLeft = size*size;
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
	
	public void addRandomNumber() {
		int i = rand.nextInt(size);
		int j = rand.nextInt(size);
		while(grid[i][j]!=-1) {
			i = rand.nextInt(size);
			j = rand.nextInt(size);
		}
		grid[i][j] = genRandom();
		nullLeft--;
	}
	
	private int genRandom() {
		return possibleNumbers.get(rand.nextInt(possibleNumbers.size()));
	}
	
	public void move(Direction dir) {
		switch(dir) {
			case up :
				moveUp(dir);
				break;
			case down : 
				moveDown(dir);
				break;
			case left : 
				moveLeft(dir);
				break;
			case right : 
				moveRight(dir);
				break;
		}
	}
	
	private void moveUp(Direction dir) {
		for(int j=0; j<size; j++) {
			int i=0;
			while(i<size-1) {
				compare(i,j,dir);
				i++;
			}
		}
	}
	
	private void moveDown(Direction dir) {
		for(int j=0; j<size; j++) {
			int i=size-1;
			while(i>0) {
				compare(i,j,dir);
				i--;
			}
		}
	}
	
	private void moveLeft(Direction dir) {
		for(int i=0; i<size; i++) {
			int j=0;
			while(j<size-1) {
				compare(i,j,dir);
				j++;
			}
		}
	}
	
	private void moveRight(Direction dir) {
		for(int i=0; i<size; i++) {
			int j=size-1;
			while(j>0) {
				compare(i,j,dir);
				j--;
			}
		}
	}
	
	private void compare(int i, int j, Direction dir) {
		if(grid[i][j]==-1) {
			grid[i][j]=grid[i+dir.i][j+dir.j];
			grid[i+dir.i][j+dir.j]=-1;
		}else {
			//1 and 2 situation
			if((grid[i][j]==1 && grid[i+dir.i][j+dir.j]==2) || (grid[i][j]==2 && grid[i+dir.i][j+dir.j]==1)) {
				grid[i][j]=3;
				isNewMax(grid[i][j]);
				grid[i+dir.i][j+dir.j]=-1;
				nullLeft++;
			}else if(grid[i][j]==1 || grid[i][j]==2) {
				return;
			}else if(grid[i][j]==grid[i+dir.i][j+dir.j]) {
				grid[i][j]+=grid[i][j];
				isNewMax(grid[i][j]);
				nullLeft++;
				grid[i+dir.i][j+dir.j]=-1;
			}else {
				//no equals 3,6,12,24
			}
		}
	}
	
	private void isNewMax(int x) {
		if(x>possibleNumbers.get(possibleNumbers.size()-1)) {
			possibleNumbers.add(x);
		}
	}
	
	public boolean isFull() {
		return nullLeft==0;
	}
	
	private int totalPoint() {
		int res=0;
		for(int[] i : grid) {
			for(int j : i) {
				res+=j;
			}
		}
		return res;
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


>>>>>>> 6e4d6fbe150da46c2fc13edcca946d068a4cf80b
