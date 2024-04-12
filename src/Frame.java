public class Frame {
    private int[] rolls = new int[3];
    private boolean isComplete = false;
    private boolean isStrike =false;
    private boolean isTenthFrame = false;
    private boolean isSpare= false;

    private int rollIndex = 0;

    public Frame(boolean isTenthFrame) {
        this.isTenthFrame = isTenthFrame;
    }

    public void addRoll(int pins) {
        if (rollIndex < rolls.length) {
            rolls[rollIndex++] = pins;
            if (!isTenthFrame && (pins == 10 || rollIndex == 2)) {
                isComplete = true;
            } else if (isTenthFrame && (rollIndex == 3 || (rollIndex == 2 && getScore() < 10))) {
                isComplete = true;
            }
        } else {
            System.out.println("No se pueden añadir más tiros a este frame.");
        }
    }



    public boolean isComplete() {
        return isComplete;
    }

    public int getScore() {
        return rolls[0] + rolls[1] + rolls[2];
    }
    public int getFirstRoll() {
        return rolls[0];
    }
    public int getSecondRoll(){
        return rolls[1];
    }

    public boolean isStrike() {
        return rolls[0] == 10;
    }

    public boolean isSpare() {
        return !isStrike() && getScore() == 10;
    }
    public int getRoll(int index) {
        if (index >= 0 && index < rolls.length) {
            return rolls[index];
        }
        return 0;
    }

}
