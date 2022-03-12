import java.util.Arrays;
import java.util.List;

public class Alphabet {
    private final List<Letter> alphabet;

    public Alphabet() {
        this.alphabet = initAlphabet();
    }

    private static List<Letter> initAlphabet() {
        String alphabet = "abcdefghijklmnopuqrstuvwxyzõäöü";
        return Arrays.stream(alphabet.split("")).map(Letter::new).toList();
    }

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
        return alphabet.size();
    }

    public List<Letter> getArray(){
        return alphabet;
    }

}
