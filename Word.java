import java.util.Arrays;

public class Word extends LetterSequence {
    public Word(String word) {
        super(Arrays.stream(word.split("")).map(Letter::new).toList());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        getSequence().forEach(letter -> sb.append(letter.getValue()));
        return sb.toString();
    }

    public Letter getLetter(int position) {
        return getSequence().get(position);
    }

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
}
