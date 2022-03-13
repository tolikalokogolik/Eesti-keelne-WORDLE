import java.util.List;

public class LetterSequence {
    private final List<Letter> sequence;

    //Konstruktor
    public LetterSequence(List<Letter> sequence) {
        this.sequence = sequence;
    }


    // Muudab tähtede olekut määrates, et nad on sõnas olemad
    public void setCorrectWordLetters(String word){
        for (String taht : word.split("")){
            for (Letter letter : sequence) {
                if (taht.equals(letter.getValue())) {
                    letter.setInWord(true);
                }
            }
        }
    }

    // Muudab tähtede olekut määrates, et nad on katsetatud väärtuse järgi
    public void setTrueTry(String word) {
        for (String taht : word.split("")){
            for (Letter letter : sequence) {
                if (taht.equals(letter.getValue())) {
                    letter.setTried(true);
                }
            }
        }
    }

    // Muudab tähtede olekut määrates, et nad on katsetatud positsiooni järgi
    public void setTrueTry(int position){
        Letter letter = sequence.get(position);
        letter.setTried(true);
    }

    // Muudab tähtede olekut määrates, et nad on ära arvatud ja õigel positsioonil
    public void setCharacterPositionNGuess(String character){
        for (Letter value : sequence) {
            if (value.getValue().equals(character)) {
                value.setCorrectPosition(true);
                value.setGuessed(true);
            }
        }
    }

    // Muudab tähtede olekut määrates, et nad on ära arvatud ja õigel positsioonil
    public void setCharacterPositionNGuess(int position){
        Letter letter = sequence.get(position);
        letter.setCorrectPosition(true);
        letter.setGuessed(true);
    }

    // Muudab tähtede olekut määrates, et nad on ära arvatud, kuid valel positsioonil
    public void setCharacterGuess(String letter){
        for (Letter value : sequence) {
            if (value.getValue().equals(letter)) {
                value.setGuessed(true);
            }
        }
    }

    // Muudab tähtede olekut määrates, et nad on ära arvatud, kuid valel positsioonil
    public void setCharacterGuess(int position) {
        sequence.get(position).setGuessed(true);
    }

    // Tagastab massiivi suuruse
    public int getSize(){
        return sequence.size();
    }

    // Muudab massiivi
    public List<Letter> getSequence() {
        return sequence;
    }
}
