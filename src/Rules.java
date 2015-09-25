import java.util.ArrayList;
import java.util.Arrays;

public class Rules {

	//Définit si un choix est légal 
	public boolean isLegal(int[][]grid, int choice, int i, int j){
		int [][] tempGrid = new int[grid.length][];
		
		for(int c = 0; c < grid.length; c++){
		    tempGrid[c] = grid[c].clone();
		}
		
		tempGrid[i][j] = choice;
		
		for (int a=0; a < tempGrid.length; a++ ){
			if (tempGrid[i][a] == choice){
				if (a !=j) return false;
			} 
		}
		
		for (int a=0; a < tempGrid.length; a++ ){
			if (tempGrid[a][j] == choice){
				if (a !=i) return false;
			} 
		}
		
		for (int a=i/3; a < i/3+3; a++ ){
			for(int b=j/3; b < j/3+3; b++ )
				if (tempGrid[a][b] == choice){
					if (a !=i && b != j) return false;
				} 
		}
		return true;
	}
	
	// Renvoie la liste des choix légaux
	public ArrayList<Integer> legalChoices(int[][]grid, int i, int j){
		ArrayList<Integer> legalChoices = new ArrayList<Integer>();
		
		for (int c=1; c<=9; c++){
			if(isLegal(grid, c,  i, j)) legalChoices.add(c);
		}
		return legalChoices;
	}
	
	// Vérifie si la grille est complète 
	public boolean isComplete(int[][] grid){
		boolean[] numbers = new boolean[grid.length];
		int content; 
		
		for (int i=0; i<grid.length;i++){
			Arrays.fill(numbers, false);
			for (int j=0; j<grid.length; j++){
				content = grid[i][j];
				if (content == 0)return false; 
				if(numbers[content-1] == false){
					numbers[content-1] = true; 
				}else{
					return false;
				}
			}
		}
		
		for (int j=0; j<grid.length;j++){
			Arrays.fill(numbers, false);
			for (int i=0; i<grid.length; i++){
				content = grid[i][j];
				if (content == 0) return false;
				if(numbers[content-1] == false){
					numbers[content-1] = true; 
				}else{
					return false; 
				}
			}
		}
		
		//BUG 
		for(int i = 0; i<3; i++){
			for(int j = 0; j < 3; j++){
				Arrays.fill(numbers, false);
				for(int bi = 0; bi < 3; i++){
					for(int bj = 0; bj <3; bj++){
						content = grid[3*i + bi][3*j+bj]; 
						if (content == 0) return false;
						if (numbers[content-1] == false){
							numbers[content-1] = true;
						}
						else{
							System.out.println(content + " " +(3*i + bi) + (3*j + bj));
							return false; 
						}
					}
				}
			}
		}
		return true; 
		
	}
}
