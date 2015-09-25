import java.util.ArrayList;

public class Rules {

	public boolean isLegal(int[][]grid, int choice, int i, int j){
		int [][] tempGrid = new int[grid.length][];
		
		for(int c = 0; c < grid.length; c++){
		    tempGrid[c] = grid[c].clone();
		}
		
		tempGrid[i][j] = choice;
		
		for (int a=0; a < tempGrid.length; a++ ){
			if (tempGrid[i][a] == choice){
				if (a !=j){
					System.out.println("a" + choice + a);
					return false;
				}
			} 
		}
		
		for (int a=0; a < tempGrid.length; a++ ){
			if (tempGrid[a][j] == choice){
				if (a !=i){
					System.out.println("b" + choice + a);
					return false;
				}
			} 
		}
		
		for (int a=i/3; a < i/3+3; a++ ){
			for(int b=j/3; b < j/3+3; b++ )
				if (tempGrid[a][b] == choice){
					if (a !=i && b != j){
						System.out.println("c" + choice + a + b);
						return false;
					}
				} 
		}
		return true;
	}
	
	public ArrayList<Integer> legalChoices(int[][]grid, int i, int j){
		ArrayList<Integer> legalChoices = new ArrayList<Integer>();
		
		for (int c=1; c<=9; c++){
			if(isLegal(grid, c,  i, j)) legalChoices.add(c);
		}
		return legalChoices;
	}
}
