import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception{
        boolean win = true;
        String triedLetters = "";
        String yellowLetters = "";
        StringBuilder inputWord = new StringBuilder();
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

        java.io.File fail = new java.io.File( "C:\\Users\\Natal\\Documents\\Tartu Ülikool\\VI aasta\\Eessti-keelne-WORDLE\\dic" + sonastik.getDifficulty() +".txt");
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                sonastik.addWord(tükid[1].substring(1,tükid[1].length()-1));
            }
        }

        Word sona = new Word(sonastik.randomWord());
        alphabet.setTrueWordLetters(sona.getWord());

        while (tryCount <= 6){
            System.out.println("Sisesta sõna, mille pikkus on " + inputDifficulty + " tähemärki.");
            Scanner scan = new Scanner(System.in);
            inputWord.append(scan.next());
            System.out.println(inputWord);

            if (inputWord.length() != inputDifficulty){

                System.out.println("Sõna on kas liiga pikk või liiga lühike.");
                System.out.println("Katseid jäänud: " + (6-tryCount));

            } else if (!sonastik.checkWord(inputWord.toString())){

                System.out.println("Kahjuks sõnastik sellist sõna ei tea.");
                System.out.println("Katseid jäänud: " + (6-tryCount));

            } else {
                for (int i = 0; i < sonastik.getDifficulty(); i++) {

                    for (int j = 0; j < sonastik.getDifficulty(); j++) {

                        if (i==j && inputWord.toString().split("")[i] == sona.getLetter(j)){

                            alphabet.setTrueLetterPositionNGuess(inputWord.toString().split("")[i]);
                            toReturn.setCharAt(i*2, sona.getLetter(i).charAt(0));
                            alphabet.setTrueTry(inputWord.toString().split("")[i]);

                        } else if (inputWord.toString().split("")[i] == sona.getLetter(j)){

                            alphabet.setTrueLetterGuess(inputWord.toString().split("")[i]);
                            alphabet.setTrueTry(inputWord.toString().split("")[i]);

                        } else{

                            alphabet.setTrueTry(inputWord.toString().split("")[i]);
                        }

                    }
                }


                for (int i = 0; i < alphabet.getSize(); i++) {
                    if (!alphabet.getArray()[i].isPosition() && alphabet.getArray()[i].isGuessed() && !yellowLetters.contains(alphabet.getArray()[i].getLetter())){
                        yellowLetters += alphabet.getArray()[i].getLetter();
                    } else if (alphabet.getArray()[i].isPosition() && alphabet.getArray()[i].isGuessed() && yellowLetters.contains(alphabet.getArray()[i].getLetter())){
                        //eemaldame kollaste tähtede nimekirjast, kui on ära arvatud
                        // vaja lisada kontroll, et kas esinevad kordused
                    }
                }

                for (int i = 0; i < alphabet.getSize(); i++) {
                    if (alphabet.getArray()[i].isTried() & !triedLetters.contains(alphabet.getArray()[i].getLetter())){
                        triedLetters += alphabet.getArray()[i].getLetter();
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
                System.out.println("Õige sõna on " + sona.getWord());
            } else{
                System.out.println("Katsed on lõppenud - te olete kaotanud!");
                System.out.println("Õige sõna on " + sona.getWord());
            }



            inputWord = new StringBuilder();
        }







    }
}
