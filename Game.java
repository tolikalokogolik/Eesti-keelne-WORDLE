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
            Word inputWord = new Word(readInput());
            if (Objects.equals(inputWord.toString(), desiredWord.toString())) {
                showWinMessage();
                break;
            }
            else if (inputWord.toString().length() != difficulty) {
                showLengthError();
            } else if (!dictionary.checkWord(inputWord.toString())) {
                showNotFoundError();
            } else {
                currentTry++;
                for (int i = 0; i < difficulty; i++) {
                    for (int j = 0; j < difficulty; j++) {

                        alphabet.setTrueTry(inputWord.toString().split("")[i]);
                        inputWord.setTrueTry(i);

                        // green
                        if (i==j && Objects.equals(inputWord.getLetter(i).getValue(), desiredWord.getLetter(j).getValue())){
                            desiredWord.setCharacterPositionNGuess(j);
                            alphabet.setCharacterPositionNGuess(inputWord.getLetter(i).getValue());
                            inputWord.setCharacterPositionNGuess(i);

                            // yellow
                        } else if (Objects.equals(inputWord.getLetter(i).getValue(), desiredWord.getLetter(j).getValue())){
                            alphabet.setCharacterGuess(inputWord.getLetter(i).getValue());
                            desiredWord.setCharacterGuess(j);
                            inputWord.setCharacterGuess(i);
                        }
                    }
                }
                showState(inputWord);
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

    private void showState(Word inputWord) {
        // TODO add current word state

        System.out.println("Hetkel sõna kuju: " + desiredWord.getCorrectCharacters());
        System.out.print("Sisestatud sõna: ");
        inputWord.getColored();
        System.out.println();
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
        String input;
        while (true){
            System.out.println("Sisesta raskustase (4,5,6): ");
            Scanner scan = new Scanner(System.in);
            input = scan.next();
            if (!input.equals("4") && !input.equals("5") && !input.equals("6")){
                System.out.println("Sisestatud raskustase on vigane.");
                continue;
            } else {
                break;
            }
        }
        return input;
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
