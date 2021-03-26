// Autor: Mario Käära C09120

public class Pudelijook extends Jook{

    private int tellitudPudeliteArv;

    public Pudelijook(String nimetus, double hind, int maht, int tellitudPudeliteArv) {
        super(nimetus, hind, maht);
        this.tellitudPudeliteArv = tellitudPudeliteArv;
    }

    @Override
    public double liitriHind() {
        return Math.round(1000*(getHind()/getMaht())*100.0)/100.0;
    }

    @Override
    public double tellimuseHind() {
        return Math.round(getHind()*tellitudPudeliteArv*100.0)/100.0;
    }

    @Override
    public String toString() {
        return "Pudelijook: " + super.toString() + " Tellitud pudeleid: " + tellitudPudeliteArv + " pdl";
    }

}
