import aima.core.search.uninformed.*;
import aima.core.search.local.*;
import aima.core.search.informed.*;
import aima.core.search.framework.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Sudoku {
	
	private static int SIZE = 9;  
	int[][] grid;
	boolean[][] playable;
	
	public Sudoku(String s){
		this.grid = createGrid(s);
		this.playable = createPlayable(); 
	}
	
	public int[][] createGrid(String s){
		int[][] grid = new int[SIZE][SIZE];
		int n=0;
		int content;
		
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				content = Character.getNumericValue(s.charAt(n));
				grid[i][j] = content; 
				n++; 
			}
		}
		return grid;
	}
	
	public boolean[][] createPlayable(){
		boolean[][] playable = new boolean[SIZE][SIZE];
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				if (this.grid[i][j] > 0) playable[i][j] = false;
			}
		}
		return playable;
	}
	
	public String toString(){
		String s = " - - - - - - - - - " + "\n"; 
		
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				s += "|" + this.grid[i][j]; 
			}
			s += "|" + "\n";
		} 
		s += " - - - - - - - - - " + "\n";
		return s;
	}
	

	public static void main(String[] args) throws IOException {
		
		TextFileLineParser lp = new TextFileLineParser("completeSudoku.txt");
		ArrayList<String> sudokus = lp.getLines();
		Sudoku s = new Sudoku(sudokus.get(0));
		
		Rules rules = new Rules(); 
		
		System.out.println(rules.legalChoices(s.grid, 8, 0));
		System.out.println(rules.isComplete(s.grid));
		
		System.out.println(s);
		
		
		
		
		//BreadthFirstSearch BFSearch = new BreadthFirstSearch();
		
		//HillClimbingSearch HCsearch = new HillClimbingSearch(null);
		//AStarSearch ASSearch = new AStarSearch(null, null);
	}

}
