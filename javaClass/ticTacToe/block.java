class block implements global {
    private int state = 0;

    public block() {
    }

    public boolean setState(int var1) {
        if (this.isValidState(var1)) {
            this.state = var1;
            return true;
        } else {
            return false;
        }
    }

    public int getState() {
        return this.state;
    }

    public boolean isValidState(int var1) {
        return var1 == 2 || var1 == 1;
    }

    public String toString() {
        if (this.state == 0) {
            return " ";
        } else {
            return this.state == 1 ? "x" : "o";
        }
    }
}
