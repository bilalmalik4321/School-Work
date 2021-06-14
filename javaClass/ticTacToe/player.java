abstract class player {
    public int playerSymbol;
    public board gameBoard;
    public String playerName;

    public abstract void play(board var1);

    /**
     * Overloaded Constructor that takes parameters passed from one of its three children
     * @param x variable value for game board
     * @param y variable value representing Nought or Cross
     * @param z value representing player name
     */
    public player(board x, int y, String z) {
        this.gameBoard = x;
        this.playerSymbol = y;
        this.playerName = z;
    }

    /**
     * Override method invoked by printing one of the player objects, printing out the following
     * @return the player name passed in constructor
     */
    public String toString() {
        return this.playerName;
    }
}
