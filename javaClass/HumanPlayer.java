import java.util.Scanner;

class HumanPlayer extends player {
    public HumanPlayer(board var1, int var2, String var3) {
        super(var1, var2, var3);
    }

    public void play(board var1) {
        Scanner var4 = new Scanner(System.in);
        super.gameBoard = var1;

        boolean var3;
        do {
            System.out.println("GameBot: Please enter your move by selecting a number from the available moves: ");
            var1.displayPlayerSelectionBoard();
            int var2 = var4.nextInt();
            var3 = var1.makeMove(var2, this.playerSymbol);
            if (!var3) {
                System.out.println("GameBot: Invalid move! try again...");
            }
        } while(!var3);

    }
}
