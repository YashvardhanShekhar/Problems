class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board ,0 ,0);
    }
    public static boolean sudokuSolver(char sudoku[][] ,int row ,int col){
		if( row == 9 ){
			return true;
		}
		int nextRow = row, nextCol =col+1 ;

		if(nextCol == 9){
			nextRow=row+1;
			nextCol=0 ;
		}

		if(sudoku[row][col] != '.'){
			return sudokuSolver(sudoku, nextRow, nextCol) ;
		}

		for(int num=1;num<=9;num++){
			char ch = (char)(48+num);   // to convert digit to char 

			if(	isSafeSudoku( sudoku, row, col, ch) ){
				sudoku[row][col] = ch;
				if(sudokuSolver(sudoku, nextRow, nextCol) ){
					return true;
				}
				sudoku[row][col] = '.';
			}
		}
		return false;
	}

	public static boolean isSafeSudoku(char sudoku[][] ,int row, int col, char num){
		for(int k =0; k<9; k++){
			if(sudoku[k][col] == num){
				return false ;
			}
		}
		for(int k =0; k<9; k++){
			if(sudoku[row][k] == num){
				return false ;
			}
		}
		int sr = (row/3)*3;
		int sc = (col/3)*3;
		
		for(int i = sr; i<sr+3; i++){
			for(int j = sc; j<sc+3; j++){
				if(sudoku[i][j] == num){
					return false;
				}
			}
		}
		return true;
	}
}