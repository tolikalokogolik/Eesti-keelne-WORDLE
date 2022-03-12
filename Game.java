import java.util.Scanner;

public class Game {
    private final int difficulty;
    private Word desiredWord;
    private final Dictionary dictionary;
    private final Alphabet alphabet;
    private int currentTry = 0;
    private static int INIT_TRY_COUNT = 6;

    public Game(int difficulty) {
        this.difficulty = difficulty;
        this.dictionary = new Dictionary(difficulty);
        this.alphabet = new Alphabet();

        this.desiredWord = dictionary.randomWord();
        this.alphabet.setTrueWordLetters(this.desiredWord.getWord());
    }

    public void start() {
        while (currentTry < INIT_TRY_COUNT) {
            String inputWord = readInput();
            if (inputWord.length() != difficulty) {
                showLengthError();
            } else if (!dictionary.checkWord(inputWord)) {
                showNotFoundError();
            }
        }
    }

    private void showLengthError() {
        System.out.println("Sõna on kas liiga pikk või liiga lühike.");
        System.out.println("Katseid jäänud: " + (INIT_TRY_COUNT-currentTry));
    }

    private void showNotFoundError() {
        System.out.println("Kahjuks sõnastik sellist sõna ei tea.");
        System.out.println("Katseid jäänud: " + (INIT_TRY_COUNT-currentTry));
    }

    public String readInput() {
        System.out.println("Sisesta sõna, mille pikkus on " + difficulty + " tähemärki.");
        Scanner scan = new Scanner(System.in);
        return scan.next().toLowerCase();
    }

    public static String readDifficultyInput() {
        System.out.println("Sisesta raskustase (4,5,6): ");
        Scanner scan = new Scanner(System.in);
        return scan.next().toLowerCase();
    }
}
