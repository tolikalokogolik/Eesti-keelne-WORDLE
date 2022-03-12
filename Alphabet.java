public class Alphabet {
    protected final Letter[] alphabet = {
            new Letter("a"), new Letter("c"), new Letter("b"), new Letter("d"), new Letter("e"),
            new Letter("f"), new Letter("g"), new Letter("h"), new Letter("i"), new Letter("j"),
            new Letter("k"), new Letter("l"), new Letter("m"), new Letter("n"), new Letter("o"),
            new Letter("p"), new Letter("q"),new Letter("r") ,new Letter("s") , new Letter("t"),
            new Letter("u"), new Letter("v"), new Letter("w"), new Letter("x"), new Letter("y"),
            new Letter("z"), new Letter("õ"), new Letter("ä"), new Letter("ö"), new Letter("ü")};

    public void setTrueWordLetters(String word){
        for (String taht : word.split("")){
            for (Letter letter : alphabet) {
                if (taht.equals(letter.getLetter())) {
                    letter.setInWord(true);
                }
            }
        }

    }

    public void setTrueTry(String word){
        for (String taht : word.split("")){
            for (Letter letter : alphabet) {
                if (taht.equals(letter.getLetter())) {
                    letter.setTried(true);
                }
            }
        }
    }

    public void setTrueLetterPositionNGuess(String letter){
        for (Letter value : alphabet) {
            if (value.getLetter().equals(letter)) {
                value.setPosition(true);
                value.setGuessed(true);
            }
        }
    }

    public void setTrueLetterGuess(String letter){
        for (Letter value : alphabet) {
            if (value.getLetter().equals(letter)) {
                value.setGuessed(true);
            }
        }
    }

    public int getSize(){
        return alphabet.length;
    }

    public Letter[] getArray(){
        return alphabet;
    }







}
