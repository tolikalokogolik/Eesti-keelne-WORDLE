public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String getLetter(int position){
        return word.split("")[position];
    }
}
