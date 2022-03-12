import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Dictionary {
    private int difficulty = 5;
    private ArrayList<String> words = new ArrayList<>();

    public Dictionary(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean checkWord(String toCheckWord){
        for (String word : words) {
            if (word.equals(toCheckWord)){
                return true;
            }
        }

        return false;

    }


    public void addWord(String sona){
        words.add(sona);
    }

    public String randomWord(){
        return words.get((int) (Math.random() * words.size()));
    }






}
