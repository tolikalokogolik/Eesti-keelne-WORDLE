import java.util.Arrays;
import java.util.List;

public class Alphabet extends LetterSequence {

    public Alphabet() {
        super(initAlphabet());
    }

    private static List<Letter> initAlphabet() {
        String alphabet = "abcdefghijklmnopuqrstuvwxyzõäöü";
        return Arrays.stream(alphabet.split("")).map(Letter::new).toList();
    }

    public String getUnused(){
        StringBuilder unused = new StringBuilder();
        for (Letter letter: getSequence()) {
            if (!letter.isTried()){
                unused.append(letter);
            }

        }
        return unused.toString();
    }

    public String getWrongPosition(){
        StringBuilder wrongPosition = new StringBuilder();
        for (Letter letter: getSequence()) {
            if (letter.isInWord() && letter.isTried() && !letter.isCorrectPosition()){
                wrongPosition.append(letter.getValue());
            }
        }
        return wrongPosition.toString();
    }

    public String getWrong() {
        StringBuilder wrong = new StringBuilder();
        for (Letter letter : getSequence()) {
            if (!letter.isInWord() && letter.isTried()) {
                wrong.append(letter.getValue());
            }
        }
        return wrong.toString();
    }
}
