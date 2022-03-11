import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Dictionary {
    private int difficulty = 5;
    private ArrayList<String> words = new ArrayList<>();


    java.io.File fail = new java.io.File("dic" + difficulty +".txt");

    try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            String[] tükid = rida.split(" ");

            words.add(tükid[2].substring(1,tükid[2].length()-1));


        }
    }


    public Dictionary() throws FileNotFoundException {
        System.out.println("Antud faili pole olemas");
    }
}
