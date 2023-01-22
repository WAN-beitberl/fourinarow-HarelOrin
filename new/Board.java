public class Board {
    public String board[][] = new String[6][7];
    static public String emptyItem = "O";

    Board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = emptyItem;
            }
        }
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        for (int j = 0; j < (board[0].length+2)*2 -1; j++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.print("  ");
        for (int j = 0; j < board[0].length; j++) {
            System.out.print(j+1 + " ");
        }
        System.out.println();System.out.println();System.out.println();
    }

    public boolean colFull(int input) {
        if (board[0][input] == emptyItem) {
            return false;
        }
        
        return true;
    }

    public boolean checkIndexWinner(int i, int j){
        int rowDir[] = { -1, -1, -1,  0, 0,  1, 1, 1 };
        int colDir[] = { -1,  0,  1, -1, 1, -1, 0, 1 };
        int rowDirIndex;
        int colDirIndex;
        String checkedPlayer = board[i][j];

        for (int nDir = 0; nDir < 8; nDir++) {
            int winCount = 1;
            rowDirIndex = i + rowDir[nDir];
            colDirIndex = j + colDir[nDir];

            while (winCount < 4 && winCount != 0) {
                
                if( rowDirIndex >= board.length || rowDirIndex < 0 || colDirIndex >= board[0].length || colDirIndex < 0) {  
                    break;
                }
                
                if (board[rowDirIndex][colDirIndex].equals(checkedPlayer)) {
                    winCount++;
                }
                else {winCount = 0;}
                
                rowDirIndex += rowDir[nDir];
                colDirIndex += colDir[nDir];
            }

            if (winCount == 4) {
                return true;
            }
        }
        return false;
    }


}