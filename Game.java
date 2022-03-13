import java.util.Objects;
import java.util.Scanner;

public class Game {
    private final int difficulty;
    private final Word desiredWord;
    private final Dictionary dictionary;
    private final Alphabet alphabet;
    private int currentTry = 0;
    private static final int INIT_TRY_COUNT = 6;

    public Game(int difficulty) {
        this.difficulty = difficulty;
        this.dictionary = new Dictionary(difficulty);
        this.alphabet = new Alphabet();

        this.desiredWord = dictionary.randomWord();
        this.alphabet.setCorrectWordLetters(this.desiredWord.toString());
    }

    public void start() {
        while (currentTry < INIT_TRY_COUNT) {
            String inputWord = readInput();
            if (Objects.equals(inputWord, desiredWord.toString())) {
                showWinMessage();
                break;
            }
            else if (inputWord.length() != difficulty) {
                showLengthError();
            } else if (!dictionary.checkWord(inputWord)) {
                showNotFoundError();
            } else {
                currentTry++;
                for (int i = 0; i < difficulty; i++) {
                    for (int j = 0; j < difficulty; j++) {

                        alphabet.setTrueTry(inputWord.split("")[i]);

                        // green
                        if (i==j && Objects.equals(inputWord.split("")[i], desiredWord.getLetter(j).getValue())){
                            desiredWord.setCharacterPositionNGuess(j);
                            alphabet.setCharacterPositionNGuess(inputWord.split("")[i]);

                            // yellow
                        } else if (Objects.equals(inputWord.split("")[i], desiredWord.getLetter(j).getValue())){
                            alphabet.setCharacterGuess(inputWord.split("")[i]);
                            desiredWord.setCharacterGuess(j);
                        }
                    }
                }
                showState();
            }
        }
        if (currentTry == INIT_TRY_COUNT) {
            showLoseMessage();
        }
    }

    private void showLoseMessage() {
        System.out.println("Katsed on lõppenud - te olete kaotanud!");
        System.out.println("Õige sõna on " + desiredWord.toString());
    }

    private void showWinMessage() {
        System.out.println("Te arvasite ära õige sõna - te võitsite!");
        // TODO add stats
    }

    private void showLengthError() {
        System.out.println("Sõna on kas liiga pikk või liiga lühike.");
        System.out.println("Katseid jäänud: " + (INIT_TRY_COUNT-currentTry));
    }

    private void showNotFoundError() {
        System.out.println("Kahjuks sõnastik sellist sõna ei tea.");
        System.out.println("Katseid jäänud: " + (INIT_TRY_COUNT-currentTry));
    }

    private void showState() {
        // TODO add current word state

        System.out.println("Hetkel sõna kuju: " + desiredWord.getCorrectCharacters());
        System.out.println("Ära arvatud tähed, kuid valel positsioonil: " + alphabet.getWrongPosition());
        System.out.println("Neid tähti pole sõnas: " + alphabet.getWrong());
        System.out.println("Katseid jäänud: " + (INIT_TRY_COUNT-currentTry));
    }

    public String readInput() {
        System.out.println("Sisesta sõna, mille pikkus on " + difficulty + " tähemärki.");
        Scanner scan = new Scanner(System.in);
        return scan.next().toLowerCase();
    }

    public static String readDifficultyInput() {
        System.out.println("Sisesta raskustase (4,5,6): ");
        // TODO add validation for correct input
        Scanner scan = new Scanner(System.in);
        return scan.next().toLowerCase();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Word getDesiredWord() {
        return desiredWord;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public int getCurrentTry() {
        return currentTry;
    }
}
