import java.util.*;

class Program {

	int count =0;
  public int nonAttackingQueens(int n) {
		// contruct matrix
		char[][] matrix = new char[n][n];
		for(int i=0; i< n; i++){
			for(int j=0; j < n; j++){
				matrix[i][j] = '.';
			}
		}
		
		solve(matrix, 0, n);
    return count;
  }
	
	
	private void solve(char[][] matrix, int row, int n){
		if(row == n){
      // as we traversed all row, so we must have put all queens at valid positions
			count++;
			return;
		}
		
			for(int j=0; j < n; j++){				
				// we validate and recurse on our decision
				if(canPlace(matrix, row, j)){
					matrix[row][j] = 'Q';
					++row;
					solve(matrix, row, n);
					--row;
					matrix[row][j] = '.';
				}
			}
		
	}
	
	private boolean canPlace(char[][] mat, int row, int col) {
     //check if the column had a queen before.
				int n= mat.length;
        for (int i = 0; i != row; ++i)
            if (mat[i][col] == 'Q')
                return false;
        //check if the 45° diagonal had a queen before.
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
            if (mat[i][j] == 'Q')
                return false;
        //check if the 135° diagonal had a queen before.
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j)
            if (mat[i][j] == 'Q')
                return false;
        return true;
  }
}
