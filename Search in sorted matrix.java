import java.util.*;

class Program {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    // Write your code here.
		int row = matrix.length;
		int col = matrix[0].length;
		
		int rowIndex = 0;
		int colIndex = col-1;
		
		while(rowIndex < row && colIndex >= 0){
			int val = matrix[rowIndex][colIndex];
			
			if(val == target){
				return new int[] {rowIndex, colIndex};
			}else if(val > target){
				colIndex--;
			}else{
				rowIndex++;
			}
		}
    return new int[] {-1, -1};
  }
}
