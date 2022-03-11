public class Test {
    public static void main(String[] args) throws Exception{

        int inputDifficulty = 5;

        //loome sõnastiku ja lisame sõnad
        Dictionary sonastik = new Dictionary(inputDifficulty);

        java.io.File fail = new java.io.File( "dic" + sonastik.getDifficulty() +".txt");
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                System.out.println(tükid[2].substring(1,tükid[2].length()-1));
                System.out.println(tükid);
                sonastik.addWord(tükid[2].substring(1,tükid[2].length()-1));


            }
        }

        System.out.println("dic" + sonastik.getDifficulty() +".txt");
        System.out.println(sonastik);

    }
}
