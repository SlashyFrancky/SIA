import aima.core.search.uninformed.*;
import aima.core.search.local.*;
import aima.core.search.informed.*;
import aima.core.search.framework.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Sudoku {
	
	public Sudoku(){
		
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		TextFileLineParser lp = new TextFileLineParser("1sudoku.txt");
		ArrayList<String> sudokus = lp.getLines();
		
		System.out.println(sudokus);
		
		
		
		BreadthFirstSearch BFSearch = new BreadthFirstSearch();
		
		//HillClimbingSearch HCsearch = new HillClimbingSearch(null);
		//AStarSearch ASSearch = new AStarSearch(null, null);
	}

}
