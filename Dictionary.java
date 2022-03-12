import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    private final List<String> words = new ArrayList<>();

    public Dictionary(int difficulty) {
        this.loadWords(difficulty);
    }

    public void loadWords(int difficulty) {
        File fail = new File( "C:\\Users\\Natal\\Documents\\Tartu Ülikool\\VI aasta\\Eessti-keelne-WORDLE\\dic" + difficulty +".txt");
        try (Scanner sc = new Scanner(fail, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                words.add(tükid[1].substring(1, tükid[1].length() - 1));
            }
        } catch (Exception e) {
            System.out.println("Uvazaemii loh, proverte fail");
        }
    }

    public boolean checkWord(String toCheckWord){
        for (String word : words) {
            if (word.equals(toCheckWord)){
                return true;
            }
        }
        return false;
    }

    public Word randomWord(){
        return  new Word(words.get((int) (Math.random() * words.size())));
    }


}
