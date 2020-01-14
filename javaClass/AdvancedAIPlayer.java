import java.util.Random;

public class AdvancedAIPlayer extends player implements global {
    public AdvancedAIPlayer(board var1, int var2, String var3) {
        super(var1, var2, var3);
    }

    public void play(board var1) {
        boolean var2 = false;
        int var3 = this.senseWin();
        if (var3 != 0) {
            var1.makeMove(var3, this.playerSymbol);
            System.out.println(this.playerName + ": yes... I see a winning move at " + var3 + "!");
        } else {
            var3 = this.senseLoss();
            if (var3 != 0) {
                var1.makeMove(var3, this.playerSymbol);
                System.out.println(this.playerName + ": I am playing defense at " + var3);
            } else {
                var3 = this.randomLegal();
                var1.makeMove(var3, this.playerSymbol);
                System.out.println(this.playerName + ": hmm... just a random move at " + var3);
            }
        }
    }

    private int senseWin() {
        for(int var1 = 0; var1 < 3; ++var1) {
            for(int var2 = 0; var2 < 3; ++var2) {
                if (this.gameBoard.blocks[var1][var2].getState() == 0) {
                    int var3 = 0;
                    if (this.gameBoard.blocks[0][var2].getState() == this.playerSymbol) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[1][var2].getState() == this.playerSymbol) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[2][var2].getState() == this.playerSymbol) {
                        ++var3;
                    }

                    if (var3 == 2) {
                        return 3 * var1 + 1 + var2;
                    }

                    var3 = 0;
                    if (this.gameBoard.blocks[var1][0].getState() == this.playerSymbol) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[var1][1].getState() == this.playerSymbol) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[var1][2].getState() == this.playerSymbol) {
                        ++var3;
                    }

                    if (var3 == 2) {
                        return 3 * var1 + 1 + var2;
                    }

                    var3 = 0;
                    if (var1 == 0 && var2 == 2 || var1 == 1 && var2 == 1 || var1 == 2 && var2 == 0) {
                        if (this.gameBoard.blocks[0][2].getState() == this.playerSymbol) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[2][0].getState() == this.playerSymbol) {
                            ++var3;
                        }

                        if (var3 == 2) {
                            return 3 * var1 + 1 + var2;
                        }
                    }

                    var3 = 0;
                    if (var1 == 0 && var2 == 0 || var1 == 1 && var2 == 1 || var1 == 2 && var2 == 2) {
                        if (this.gameBoard.blocks[0][0].getState() == this.playerSymbol) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[2][2].getState() == this.playerSymbol) {
                            ++var3;
                        }

                        if (var3 == 2) {
                            return 3 * var1 + 1 + var2;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private int senseLoss() {
        byte var4;
        if (this.playerSymbol == 1) {
            var4 = 2;
        } else {
            var4 = 1;
        }

        for(int var1 = 0; var1 < 3; ++var1) {
            for(int var2 = 0; var2 < 3; ++var2) {
                if (this.gameBoard.blocks[var1][var2].getState() == 0) {
                    int var3 = 0;
                    if (this.gameBoard.blocks[0][var2].getState() == var4) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[1][var2].getState() == var4) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[2][var2].getState() == var4) {
                        ++var3;
                    }

                    if (var3 == 2) {
                        return 3 * var1 + 1 + var2;
                    }

                    var3 = 0;
                    if (this.gameBoard.blocks[var1][0].getState() == var4) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[var1][1].getState() == var4) {
                        ++var3;
                    }

                    if (this.gameBoard.blocks[var1][2].getState() == var4) {
                        ++var3;
                    }

                    if (var3 == 2) {
                        return 3 * var1 + 1 + var2;
                    }

                    var3 = 0;
                    if (var1 == 0 && var2 == 2 || var1 == 1 && var2 == 1 || var1 == 2 && var2 == 0) {
                        if (this.gameBoard.blocks[0][2].getState() == var4) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == var4) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[2][0].getState() == var4) {
                            ++var3;
                        }

                        if (var3 == 2) {
                            return 3 * var1 + 1 + var2;
                        }
                    }

                    var3 = 0;
                    if (var1 == 0 && var2 == 0 || var1 == 1 && var2 == 1 || var1 == 2 && var2 == 2) {
                        if (this.gameBoard.blocks[0][0].getState() == var4) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[1][1].getState() == var4) {
                            ++var3;
                        }

                        if (this.gameBoard.blocks[2][2].getState() == var4) {
                            ++var3;
                        }

                        if (var3 == 2) {
                            return 3 * var1 + 1 + var2;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private int randomLegal() {
        int var3 = 0;
        int[] var4 = new int[9];
        Random var5 = new Random();

        for(int var1 = 0; var1 < 3; ++var1) {
            for(int var2 = 0; var2 < 3; ++var2) {
                if (this.gameBoard.blocks[var1][var2].getState() == 0) {
                    var4[var3++] = 3 * var1 + 1 + var2;
                }
            }
        }

        return var4[var5.nextInt(var3)];
    }
}

