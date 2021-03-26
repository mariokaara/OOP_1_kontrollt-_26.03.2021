// Autor: Mario Käära C09120

public abstract class Jook implements Comparable<Jook>{

    private String nimetus;
    private double hind;
    private int maht;

    public Jook(String nimetus, double hind, int maht) {
        this.nimetus = nimetus;
        this.hind = hind;
        this.maht = maht;
    }


    public double getHind() {
        return hind;
    }

    public int getMaht() {
        return maht;
    }

    public abstract double liitriHind();
    public abstract double tellimuseHind();

    @Override
    public String toString() {
        return nimetus + " Hind: " + hind + "EUR Maht: " + maht + "ml Liitri hind: " + liitriHind() + "EUR Tellimuse hind: " + tellimuseHind() + "EUR";
    }

    @Override
    public int compareTo(Jook o) {
        return Double.compare(this.liitriHind(), o.liitriHind());
    }
}
