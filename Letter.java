public class Letter {
    private String letter;
    private boolean guessed = false;
    private boolean inWord = false;
    private boolean position = false;
    private boolean tried = false;
    private boolean repeat = false;

    public Letter(String letter) {
        this.letter = letter;
    }

    public void setTried(boolean tried) {
        this.tried = tried;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public boolean isTried() {
        return tried;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public String getValue() {
        return letter;
    }

    public boolean isInWord() {
        return inWord;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public boolean isCorrectPosition() {
        return position;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setInWord(boolean inWord) {
        this.inWord = inWord;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    public void setCorrectPosition(boolean position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "letter='" + letter + '\'' +
                ", guessed=" + guessed +
                ", inWord=" + inWord +
                ", position=" + position +
                ", tried=" + tried +
                ", repeat=" + repeat +
                '}';
    }
}
