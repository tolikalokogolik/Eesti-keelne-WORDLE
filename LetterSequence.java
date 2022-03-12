import java.util.List;

public class LetterSequence {
    private final List<Letter> sequence;

    public LetterSequence(List<Letter> sequence) {
        this.sequence = sequence;
    }


    // Timofei loh
    public void setCorrectWordLetters(String word){
        for (String taht : word.split("")){
            for (Letter letter : sequence) {
                if (taht.equals(letter.toString())) {
                    letter.setInWord(true);
                }
            }
        }
    }

    public void setTrueTry(String word) {
        for (String taht : word.split("")){
            for (Letter letter : sequence) {
                if (taht.equals(letter.toString())) {
                    letter.setInWord(true);
                }
            }
        }
    }

    public void setCharacterPositionNGuess(String character){
        for (Letter value : sequence) {
            if (value.toString().equals(character)) {
                value.setCorrectPosition(true);
                value.setGuessed(true);
            }
        }
    }

    public void setCharacterPositionNGuess(int position){
        Letter letter = sequence.get(position);
        letter.setCorrectPosition(true);
        letter.setGuessed(true);
    }

    public void setCharacterGuess(String letter){
        for (Letter value : sequence) {
            if (value.toString().equals(letter)) {
                value.setGuessed(true);
            }
        }
    }

    public void setCharacterGuess(int position) {
        sequence.get(position).setGuessed(true);
    }

    public int getSize(){
        return sequence.size();
    }

    public List<Letter> getSequence() {
        return sequence;
    }
}
