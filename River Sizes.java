import java.util.*;

class Program {
  public static List<Integer> riverSizes(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
		ArrayList<Integer> result = new ArrayList();
    for(int i=0; i < row; i++){
        for(int j=0; j < col; j++){
            if(matrix[i][j] == 1){
                int size = mark_connected_islands(matrix, i, j, row, col);
								if(size > 0){
									result.add(size);
								}
              }
          }
      }
    return result;
  }
	
	// we mark all connected islands - 2
     private  static int mark_connected_islands(int[][] grid, int i, int j, int row, int col){
         if( i >= row || i < 0 || j >= col || j < 0 || grid[i][j] != 1){
             return 0;
         }

         grid[i][j] = 2;
         // make recursive call in four directions
         return 1 + mark_connected_islands(grid, i+1, j, row, col) + 
         mark_connected_islands(grid, i, j+1, row, col) + 
         mark_connected_islands(grid, i-1, j, row, col) + 
         mark_connected_islands(grid, i, j-1, row, col);
     }
}
