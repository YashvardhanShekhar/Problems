class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> finallist = new ArrayList<>();
        
		char board[][] = new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				board[i][j] = '.' ;
			}
		}
		nQueens(board , 0, finallist);
        return finallist;
    }
    public static boolean isSafe(char board[][], int row, int col){
		for(int i=0; i<row; i++){
			if(board[i][col]=='Q')
				return false ;
		}
		for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
			if(board[i][j]=='Q')
				return false ;
		}
		for(int i=row-1,j=col+1; i>=0 && j<board.length; i--,j++){
			if(board[i][j]=='Q')
				return false ;
		}
		return true ;
	}

	public static void nQueens(char board[][], int row ,List<List<String>> finallist){
		if(row==board.length){
			printBoard(board,finallist);
			return ;
		}

		for(int j=0; j<board.length; j++){
			if(isSafe(board, row, j)){
				board[row][j] = 'Q';
				nQueens(board, row+1, finallist);
				board[row][j] = '.';
			}
		}
		
	}

	public static void printBoard(char board[][] , List<List<String>> finallist){
        List<String> anslist = new ArrayList<String>();
		for(int i=0; i<board.length; i++){
            String str = "";
			for(int j=0; j<board.length; j++){
				// System.out.print(board[i][j]+" ");
                str = str + board[i][j] ;
			}
            anslist.add(i,str);
			// System.out.println();
		}
        
        finallist.add(anslist);
        
	}
}