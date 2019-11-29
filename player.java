abstract class player {
    public int playerSymbol;
    public board gameBoard;
    public String playerName;

    public abstract void play(board var1);

    public player(board var1, int var2, String var3) {
        this.gameBoard = var1;
        this.playerSymbol = var2;
        this.playerName = var3;
    }

    public String toString() {
        return this.playerName;
    }
}

