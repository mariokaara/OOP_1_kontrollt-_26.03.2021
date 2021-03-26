// Autor: Mario Käära C09120

import java.util.ArrayList;
import java.util.List;

public class Tellimus {

    private List<Jook> joogid = new ArrayList<>();


    public Tellimus() {
        this.joogid = joogid;
    }

    public void telliJook(Jook jook) {
        joogid.add(jook);
    }

    public double tellimuseMaksumus() {
            double summa = 0;
            for (Jook i: joogid) {
                summa += i.tellimuseHind();
            }
            return Math.round(summa*100.0)/100.0;
    }

    public void tellimuseJoogid() {
        for (Jook i: joogid) {
            System.out.println(i.toString());
        }
    }

    @Override
    public String toString() {
        return "Tellimuse maksumus: " + tellimuseMaksumus() + "EUR. " + "Jookide arv: " + joogid.size() + "tk";
    }
}
