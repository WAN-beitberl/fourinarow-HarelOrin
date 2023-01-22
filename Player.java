public class Player {
    private boolean turn;
    private String color;

    Player(boolean turn, String color) {
        this.turn = turn;
        this.color = color;
    }

    public boolean isTurn() {
        return this.turn;
    }

    public String getColor(){
        return this.color;
    }

    public String getSign() {
        return this.getColor().substring(0, 1).toUpperCase();
    }

    public void cha(){
        if (turn) {
            turn = false;
        } else {
            turn = true;
        }
    }
}
