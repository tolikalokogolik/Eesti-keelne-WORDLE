import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception{
        boolean win = true;
        String triedLetters = "";
        String yellowLetters = "";
        int tryCount = 0;
        int inputDifficulty = 6;
        StringBuilder toReturn = new StringBuilder("");
        if (inputDifficulty == 4){
            toReturn.append("_ _ _ _")  ;
        } else if (inputDifficulty == 5){
            toReturn.append("_ _ _ _ _");
        } else {
            toReturn.append("_ _ _ _ _ _");
        }

        Alphabet alphabet = new Alphabet();

        //loome sõnastiku ja lisame sõnad
        Dictionary sonastik = new Dictionary(inputDifficulty);

        Word sona = sonastik.randomWord();
        alphabet.setCorrectWordLetters(sona.toString());

        while (tryCount <= 6){
            System.out.println("Sisesta sõna, mille pikkus on " + inputDifficulty + " tähemärki.");
            Scanner scan = new Scanner(System.in);
            StringBuilder inputWord = new StringBuilder(scan.next());

            if (inputWord.length() != inputDifficulty){

                System.out.println("Sõna on kas liiga pikk või liiga lühike.");
                System.out.println("Katseid jäänud: " + (6-tryCount));

            } else if (!sonastik.checkWord(inputWord.toString())){

                System.out.println("Kahjuks sõnastik sellist sõna ei tea.");
                System.out.println("Katseid jäänud: " + (6-tryCount));

            } else {
                for (int i = 0; i < inputDifficulty; i++) {

                    for (int j = 0; j < inputDifficulty; j++) {

                        alphabet.setTrueTry(inputWord.toString().split("")[i]);

                        // green
                        if (i==j && inputWord.toString().split("")[i] == sona.getLetter(j).toString()){
                            sona.setCharacterPositionNGuess(j);
                            alphabet.setCharacterPositionNGuess(inputWord.toString().split("")[i]);

                        // yellow
                        } else if (inputWord.toString().split("")[i] == sona.getLetter(j).toString()){
                            alphabet.setCharacterGuess(inputWord.toString().split("")[i]);
                            sona.setCharacterGuess(j);
                        }
                    }
                }

                System.out.println("Hetkel sõna kuju: " + toReturn);
                System.out.println("Ära arvatud tähed, kuid valel positsioonil: " + yellowLetters);
                System.out.println("Ära arvatud tähed, kuid valel positsioonil: " + triedLetters);
                System.out.println("Katseid jäänud: " + (5-tryCount));


                if (!toReturn.toString().contains("_")){
                    win = true;
                    break;
                }
                tryCount++;
            }

            if(win){
                System.out.println("Te arvasite ära õige sõna - te võitsite!");
                System.out.println("Õige sõna on " + sona.toString());
            } else{
                System.out.println("Katsed on lõppenud - te olete kaotanud!");
                System.out.println("Õige sõna on " + sona.toString());
            }
        }







    }
}
