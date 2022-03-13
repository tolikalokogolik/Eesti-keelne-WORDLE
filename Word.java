import java.util.Arrays;

public class Word extends LetterSequence {
    //konstruktor ja paneme külge kõik LetterSequence klassi meetodid
    public Word(String word) {
        super(Arrays.stream(word.split("")).map(Letter::new).toList());
    }

    //tagastame sõna sõne kujul
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getSequence().forEach(letter -> sb.append(letter.getValue()));
        return sb.toString();
    }

    //leiab tähe vastaval positsioonil
    public Letter getLetter(int position) {
        return getSequence().get(position);
    }

    //tagastab juba ärarvatud tähed
    public String getCorrectCharacters() {
        StringBuilder correctCharacters = new StringBuilder();
        getSequence().forEach(letter -> {
            if (letter.isCorrectPosition()) {
                correctCharacters.append(letter.getValue()).append(" ");
            } else {
                correctCharacters.append("_ ");
            }
        });
        return correctCharacters.toString();
    }

    //värvib ja prindib tähed sõnas vastavalt tähtede seisundile
    public void getColored(){
        for (Letter letter : getSequence()) {
            letter.toColor();
        }
    }

}
