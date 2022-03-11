public class test2 {
    /*
    Autorite nimed: Natali Atamanova, Aleksander Ontin
    Meie projekti nimi: Eessti-keelne-WORDLE
    Tänapäeval on erinevad mobiilimängud muutumas populaarseks ja WORDLE on üks neist. See on saadaval erinevates keeltes, kuid hetkel mitte eesti keeles. Me kavatseme selle probleemi lahendada, tehes mängu eesti keeles.
    ...
    ...
    ...
    ...
    Natali Atamanova töötas selle kallal, et saada teatud pikkusega sõnu sisaldavaid tekstifaile, mida seejärel programmis kasutada. Seejärel kirjutas ta programmi koodi.
    Aleksander Ontin oli hõivatud rühmatöö kirjeldamisega ja kommentaaride ülespanekuga. Ta kirjutas ka programmi koodi.
    ...
    ...
    ...
    ...
    */
    public static void main(String[] args) {


        System.out.println("Tere tulemast meie mängu - Wordle!");
        System.out.println("Meie mängureeglid on lihtsad.");
        System.out.println("Te valite kõigepealt, millise pikkusega sõna soovite ära arvata, ja alustate siis olemasoleva sõna sisestamist.");
        System.out.println("Pärast sõna sisestamist ütleb programm teile, milline täht on õige ja on õiges kohas, ning milline täht on õige, kuid ei ole õiges kohas.");
        System.out.println("Teil on kuus katset õige sõna sisestamiseks.");
        System.out.println("Kui leiad õige sõna, siis võidad.");
        System.out.println("Kui mitte, siis olete kaotanud!");
        System.out.println("Kui sisestate sõna valesti, siis te ei kaota katset.");

        System.out.println("Valige sõna pikkus, mida soovite ära arvata.");
        System.out.println("Kui te ei vii midagi ja vajutate Enter, lõpetab programm.");
        System.out.print("Kirjutage 4, 5 või 6: ");

        System.out.println("Sellist sõna ei ole olemas!");
        System.out.println("Proovi uuesti!");


        System.out.println("Täht " + 5 + " on sõnas ja on õiges kohas.");
        System.out.println("Täht " + 5 + " on sõnas, kuid see ei ole õiges kohas.");

        System.out.println("Teil on jäänud " + 6 + " katset.");
        System.out.println("Teil on jäänud " + 1 + " katse.");


        System.out.println("Katsed on lõppenud - te olete kaotanud!");
        System.out.println("Õige sõna on " + true);

        System.out.println("Te arvasite ära õige sõna - te võitsite!");
        System.out.println("Õige sõna on " + true);


        System.out.println("Lõpp!");



    }
}
