import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// Autor: Mario Käära C09120

public class Peaklass {

    public static List<Jook> loeJoogid(String failinimi) throws Exception {
        List<Jook> list1 = new ArrayList<>();
        try (java.util.Scanner sc = new java.util.Scanner(Path.of(failinimi), "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(",");
                if (tükid.length == 4) {
                    list1.add(new Pudelijook(tükid[0], Double.parseDouble(tükid[1]), Integer.parseInt(tükid[2]), Integer.parseInt(tükid[3])));
                } else {
                    list1.add(new Vaadijook(tükid[0], Double.parseDouble(tükid[1]), Integer.parseInt(tükid[2])));
                }
            }
        }
        return list1;
    }

    public static void main(String[] args) throws Exception {

        // Rakendatakse vastavat staatilist meetodit, et lugeda failist jookide andmed
        List<Jook> joogid = loeJoogid("fail");

        // Sorteeritakse joogid vastavalt meetodis compareTo kirjeldatud järjekorrale (kasutada meetodit Collections.sort)
        Collections.sort(joogid);

        // Jookide info väljastatakse ekraanile
        for (Jook i : joogid) {
            System.out.println(i.toString());
        }

        // Luuakse 5 tellimust
        Tellimus tellimus1 = new Tellimus();
        Tellimus tellimus2 = new Tellimus();
        Tellimus tellimus3 = new Tellimus();
        Tellimus tellimus4 = new Tellimus();
        Tellimus tellimus5 = new Tellimus();

        // Kõikidest tellimustest tehakse Tellimus[]-tüüpi massiiv. (Massiivi võib ka enne tellimuste
        // tegemist luua ja järjest täita.)
        List<Tellimus> tellimused = new ArrayList<>();
        tellimused.addAll(Arrays.asList(tellimus1, tellimus2, tellimus3, tellimus4, tellimus5));

        // Iga tellimuse jaoks valitakse juhuslikult 1 kuni 4 jooki (võib eeldada, et failis on vähemalt 4 jooki).
        //Selleks tuleb kasutada Collections.shuffle meetodit. Antud meetod võtab argumendiks
        //listi ning järjestab selle suvalises järjekorras. Jookide list järjestada iga tellimuse jaoks uuesti
        //ümber, jookide arv n genereerida juhuslikult lõigust [1, 4] (täisarvuna) ning lisada tellimusse n
        //esimest jooki.
        for (Tellimus i : tellimused) {
            Collections.shuffle(joogid);
            int randInt = (int) (1 + Math.random() * 4);
            for (int j = 0; j < randInt; j++) {
                i.telliJook(joogid.get(j));
            }
        }

        // Tellimuste info ja iga tellimuse jookide nimekiri väljastatakse ekraanile
        int tellimuseNr = 1;
        for (Tellimus i : tellimused) {
            System.out.println("");
            System.out.println("------------------------------------ Tellimus nr " + tellimuseNr + " ----------------------------------------------------------------");
            System.out.println(i.toString());
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            i.tellimuseJoogid();
            tellimuseNr++;
        }

    }

}

