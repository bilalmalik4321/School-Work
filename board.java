class board implements global {
    public block[][] blocks = new block[3][3];
    private int state = 0;

    public board() {
        for(int var1 = 0; var1 < 3; ++var1) {
            for(int var2 = 0; var2 < 3; ++var2) {
                this.blocks[var1][var2] = new block();
            }
        }

    }

    public void displayBoard() {
        System.out.print("" + this.blocks[0][0] + "|" + this.blocks[0][1] + "|" + this.blocks[0][2] + "\n");
        System.out.print("" + this.blocks[1][0] + "|" + this.blocks[1][1] + "|" + this.blocks[1][2] + "\n");
        System.out.print("" + this.blocks[2][0] + "|" + this.blocks[2][1] + "|" + this.blocks[2][2] + "\n");
    }

    public void displayPlayerSelectionBoard() {
        int var1 = 1;

        for(int var2 = 0; var2 < 3; ++var2) {
            for(int var3 = 0; var3 < 3; ++var3) {
                System.out.print(this.blocks[var2][var3].getState() == 0 ? var1 : this.blocks[var2][var3]);
                ++var1;
                if (var3 != 2) {
                    System.out.print("|");
                }
            }

            System.out.print("\n");
        }

    }

    public int getState() {
        return this.updateState();
    }

    public int updateState() {
        int var1 = this.checkRow(0) + this.checkRow(1) + this.checkRow(2) + this.checkCol(0) + this.checkCol(1) + this.checkCol(2) + this.checkDiagonals();
        if (var1 != 0) {
            this.state = var1;
        } else {
            this.state = this.checkDraw();
        }

        return this.state;
    }

    private int checkDraw() {
        for(int var1 = 0; var1 < 3; ++var1) {
            for(int var2 = 0; var2 < 3; ++var2) {
                if (this.blocks[var1][var2].getState() == 0) {
                    return 0;
                }
            }
        }

        return 3;
    }

    private int checkRow(int var1) {
        return this.blocks[var1][0].getState() != 0 && this.blocks[var1][0].getState() == this.blocks[var1][1].getState() && this.blocks[var1][1].getState() == this.blocks[var1][2].getState() ? this.blocks[var1][0].getState() : 0;
    }

    private int checkCol(int var1) {
        return this.blocks[0][var1].getState() != 0 && this.blocks[0][var1].getState() == this.blocks[1][var1].getState() && this.blocks[1][var1].getState() == this.blocks[2][var1].getState() ? this.blocks[0][var1].getState() : 0;
    }

    private int checkDiagonals() {
        if (this.blocks[0][0].getState() != 0 && this.blocks[0][0].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][2].getState()) {
            return this.blocks[0][0].getState();
        } else {
            return this.blocks[0][2].getState() != 0 && this.blocks[0][2].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][0].getState() ? this.blocks[0][2].getState() : 0;
        }
    }

    public boolean makeMove(int var1, int var2) {
        byte var3 = 0;
        byte var4 = 0;
        if (var1 >= 1 && var1 <= 9) {
            if (var1 == 1) {
                var3 = 0;
                var4 = 0;
            }

            if (var1 == 2) {
                var3 = 0;
                var4 = 1;
            }

            if (var1 == 3) {
                var3 = 0;
                var4 = 2;
            }

            if (var1 == 4) {
                var3 = 1;
                var4 = 0;
            }

            if (var1 == 5) {
                var3 = 1;
                var4 = 1;
            }

            if (var1 == 6) {
                var3 = 1;
                var4 = 2;
            }

            if (var1 == 7) {
                var3 = 2;
                var4 = 0;
            }

            if (var1 == 8) {
                var3 = 2;
                var4 = 1;
            }

            if (var1 == 9) {
                var3 = 2;
                var4 = 2;
            }

            if (this.blocks[var3][var4].getState() == 0) {
                this.blocks[var3][var4].setState(var2);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}