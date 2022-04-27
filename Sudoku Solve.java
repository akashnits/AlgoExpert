import java.util.*;

class Program {

  public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
    // Write your code here.
		solve(board, 0, 0, board.size());
    return board;
  }
	
	private boolean solve(ArrayList<ArrayList<Integer>>  board, int row, int col, int n){
		// base condition
		if(col == n){
			// we change row
			row = row +1;
			col=0;
		}
		if(row == n){
			// we solved it
			return true;
		}
		
		if((board.get(row)).get(col) != 0){
			// no need to solve for this cell
			return solve(board, row, col+1, n);
		}
		// iterate over choices
		for(int val=1; val <= 9; val++){
			if(canPlace(board, row, col, val)){
				// we place it 
					(board.get(row)).set(col, val);
					
				// recurse on our decision
					if(solve(board, row, col+1, n)){
						return true; // we don't want to solve further if we have a solution
					}
			}
		}
		// we backtrack as we have exhausted all our choices
		(board.get(row)).set(col, 0);
		return false;
	}
	
	
	private boolean canPlace(ArrayList<ArrayList<Integer>>  board, int row, int col, int val){
		// check row for same val
		for(int j=0; j < board.size(); j++){
			if((board.get(row)).get(j) == val){
				return false;
			}
		}
		
		// check column for same val
		for(int i=0; i < board.size(); i++){
			if((board.get(i)).get(col) == val){
				return false;
			}
		}
		
		int subGridRowStart = (row/3) * 3;
		int subGridColStart = (col/ 3) * 3;
		// check subgrid
		for(int m= 0; m < 3; m++){
			for(int n= 0; n < 3; n++){
				if((board.get(subGridRowStart + m)).get(subGridColStart +n) == val){
					return false;
				}
			}
		}
		return true;
	}
}
