public class Game {
    private Player p1;
    private Player p2;
    public Board myb;

    Game(String color1, String color2, int first) {
        if (first == 1) {
            this.p1 = new Player(true, color1);
            this.p2 = new Player(false, color2);
        } else{
            this.p1 = new Player(false, color1);
            this.p2 = new Player(true, color2);
        }
        this.myb = new Board();
    }

    public Player getCurrPlayer() {
        if (this.p1.isTurn()) {
            return this.p1;
        } else {
            return this.p2;
        }
    }

    public void changeCurrPlayer() {
        this.p1.cha();
        this.p2.cha();
    }

    public void playCol(int input) {
        int i = 0;
        while (i+1 < myb.board.length) {
            if (myb.board[i+1][input] != Board.emptyItem) break;
            else i++;
        }
        myb.board[i][input] = this.getCurrPlayer().getSign();

    }

    public boolean checkWinner() {
        changeCurrPlayer();
        for (int i = 0; i < myb.board.length; i++) {
            for (int j = 0; j < myb.board[0].length; j++) {
                if (myb.board[i][j] != Board.emptyItem) {
                    if (myb.checkIndexWinner(i, j)) return true;
                }
            }
        }

        changeCurrPlayer();
        return false;
    }
}
