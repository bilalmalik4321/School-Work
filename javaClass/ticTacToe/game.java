import java.util.Random;
import java.util.Scanner;

public class game implements global{

    board gameBoard;
    player playerX;
    player playerO;
    int turn;
    boolean done = false;

    public  game(){
        Scanner var1 = new Scanner(System.in);
        this.gameBoard = new board();
        String var2 = "player1";
        String var3 = "player2";
        int var4 = 0;

        while(!this.done) {
            System.out.println("Welcome to TicTacToe!");
            System.out.println("Please select a game option: [1] Human vs Human [2] Human vs AI [3] AI vs AI");
            var4 = var1.nextInt();
            switch(var4) {
                case 1:
                    System.out.print("Please enter human player X name: ");
                    var2 = var1.next().trim();
                    System.out.print("Please enter human player O name: ");
                    var3 = var1.next().trim();
                    this.done = true;
                    break;
                case 2:
                    System.out.print("Please enter human player X name: ");
                    var2 = var1.next().trim();
                    System.out.print("Please enter AI player O name: ");
                    var3 = var1.next().trim();
                    System.out.println("KobtiBot: yeah...right! you many not name me... I AM KobtiBot");
                    System.out.println("KobtiBot: don't worry " + var2 + ", my level of difficulty is set to NOVICE!\n");
                    var3 = "KobtiBot";
                    this.done = true;
                    break;
                case 3:
                    System.out.print("GameBot: Please enter Novice AI player X name: ");
                    var2 = var1.next().trim();
                    System.out.print("GameBot: Please enter Advanced AI player O name: ");
                    var3 = var1.next().trim();
                    this.done = true;
                    break;
                default:
                    System.out.println("GameBot: Please enter a valid selection...");
            }
        }

        if (var4 == 1) {
            this.playerX = new HumanPlayer(this.gameBoard, 1, var2);
            this.playerO = new HumanPlayer(this.gameBoard, 2, var3);
        } else if (var4 == 2) {
            this.playerX = new HumanPlayer(this.gameBoard, 1, var2);
            this.playerO = new AdvancedAIPlayer(this.gameBoard, 2, var3);
        } else {
            this.playerX = new AIPlayer(this.gameBoard, 1, var2);
            this.playerO = new AdvancedAIPlayer(this.gameBoard, 2, var3);
        }

        System.out.println("GameBot: Game initiated: " + var2 + " VS. " + var3 + "\n");
    }


    public void start() {
        Random var1 = new Random();
        boolean var2 = false;
        this.turn = var1.nextInt(2) + 1;
        if (this.turn == 1) {
            System.out.println("GameBot: " + this.playerX.playerName + " wins the coin toss... X will start\n");
        } else {
            System.out.println("GameBot: " + this.playerO.playerName + " wins the coin toss... O will start\n");
        }

        while(!var2) {
            if (this.turn == 1) {
                System.out.println("GameBot: Player X's Turn, go ahead " + this.playerX.playerName + ":");
                this.playerX.play(this.gameBoard);
            } else {
                System.out.println("GameBot: Player O's Turn, go ahead " + this.playerO.playerName + ":");
                this.playerO.play(this.gameBoard);
            }

            if (this.gameBoard.getState() != 0) {
                var2 = true;
            }

            if (!var2) {
                if (this.turn == 1) {
                    this.turn = 2;
                } else {
                    this.turn = 1;
                }
            }
        }

        this.gameBoard.displayBoard();
        if (this.gameBoard.getState() == 3) {
            System.out.println("GameBot: It is a DRAW! no winner...");
        } else if (this.turn == 1) {
            System.out.println("GameBot: The winner is player " + this.playerX);
        } else {
            System.out.println("GameBot: The winner is player " + this.playerO);
        }

    }
}
