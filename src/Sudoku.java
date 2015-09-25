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
	
	public Sudoku(String s){
		this.grid = createGrid(s);
	}
	
	public int[][] createGrid(String s){
		int[][] grid = new int[SIZE][SIZE];
		int n=0; 
		
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				grid[i][j] = Character.getNumericValue(s.charAt(n));
				n++; 
			}
		}
		return grid;
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
		// TODO Auto-generated method stub
		
		TextFileLineParser lp = new TextFileLineParser("1sudoku.txt");
		ArrayList<String> sudokus = lp.getLines();
		Sudoku s = new Sudoku(sudokus.get(0));
		System.out.println(s);
		
		
		BreadthFirstSearch BFSearch = new BreadthFirstSearch();
		
		//HillClimbingSearch HCsearch = new HillClimbingSearch(null);
		//AStarSearch ASSearch = new AStarSearch(null, null);
	}

}
