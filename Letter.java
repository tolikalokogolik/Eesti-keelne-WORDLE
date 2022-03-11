public class Letter {
    private String letter;
    private boolean inWord = false;
    private boolean guessed = false;
    private boolean position = false;

    public Letter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public boolean isInWord() {
        return inWord;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public boolean isPosition() {
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

    public void setPosition(boolean position) {
        this.position = position;
    }


}
