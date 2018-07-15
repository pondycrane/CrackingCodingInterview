class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        if (!checkOrder(board)) {
        	return false;
        }
        if (!checkWinningState(board)) {
        	return false;
        }
        return true;
    }

    private static boolean checkOrder(String[] board) {
    	int x = 0;
    	int o = 0;
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length(); j++) {
    			switch(board[i].charAt(j)) {
    				case 'X':
    					x = x + 1;
    					break;
    				case 'O':
    					o = o + 1;
    					break;
    			}
    		}
    	}
    	System.out.println(x + ", " + o);
    	if (o > x) {
    		System.out.println("checkOrder");
    		return false;
    	}
    	if (x - o > 1) {
    		System.out.println("checkOrder");
    		return false;
    	}
    	return true;
    }

    private static boolean checkWinningState(String[] board) {
    	int winCount = 0;
    	for (int i = 0; i < board.length; i++) {
    		if (board[i].equals("XXX") || board[i].equals("OOO")) {
    			winCount = winCount + 1;
    		}
    	}
    	if (board[0].charAt(0) != ' ' &&  board[0].charAt(0) == board[1].charAt(1)  && board[1].charAt(1) == board[2].charAt(2)) {
    		winCount = winCount + 1;
    	}
    	if (board[0].charAt(2) != ' ' &&  board[0].charAt(2) == board[1].charAt(1)  && board[1].charAt(1) == board[2].charAt(0)) {
    		winCount = winCount + 1;
    	}
    	if (winCount > 1) {
    		System.out.println("checkWinningState");
    		return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	ValidTicTacToeState vttts = new ValidTicTacToeState();

    	String[] case1 = {"O  ","   ","   "};
    	System.out.println(vttts.validTicTacToe(case1));

    	String[] case2 = {"XOX"," X ","   "};
    	System.out.println(vttts.validTicTacToe(case2));

    	String[] case3 = {"XOX","O O","XOX"};
    	System.out.println(vttts.validTicTacToe(case3));
    }
}