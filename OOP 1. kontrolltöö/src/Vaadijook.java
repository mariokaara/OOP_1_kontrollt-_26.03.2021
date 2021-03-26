// Autor: Mario Käära C09120

public class Vaadijook extends Jook{

    public Vaadijook(String nimetus, double hind, int maht) {
        super(nimetus, hind, maht);
    }

    @Override
    public double liitriHind() {
        return Math.round((10*getHind())*100.0)/100.0;
    }

    @Override
    public double tellimuseHind() {
        return Math.round((getHind()*getMaht()/100)*100.0)/100.0;
    }

    @Override
    public String toString() {
        return "Vaadijook: " + super.toString();
    }
}
