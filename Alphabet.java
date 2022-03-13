import java.util.Arrays;
import java.util.List;

public class Alphabet extends LetterSequence {

    //Konstruktor ja lisame kõik meetodid klassist LetterSequence
    public Alphabet() {
        super(initAlphabet());
    }

    //loome tähtede järjestiku
    private static List<Letter> initAlphabet() {
        String alphabet = "abcdefghijklmnopuqrstuvwxyzõäöü";
        return Arrays.stream(alphabet.split("")).map(Letter::new).toList();
    }

    //tagastab sõnena kasutamata tähed
    public String getUnused(){
        StringBuilder unused = new StringBuilder();
        for (Letter letter: getSequence()) {
            if (!letter.isTried()){
                unused.append(letter.getValue());
            }

        }
        return unused.toString();
    }

    //tagastab tähed, mis on ära arvatud, aga valel positsioonil
    public String getWrongPosition(){
        StringBuilder wrongPosition = new StringBuilder();
        for (Letter letter: getSequence()) {
            if (letter.isInWord() && letter.isTried() && !letter.isCorrectPosition()){
                wrongPosition.append(letter.getValue());
            }
        }
        return wrongPosition.toString();
    }

    //tagastab tähed, mis  on proovitud, kuid sõnas neid pole
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
