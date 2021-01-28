package karta_pacjenta;

public class Pacjent implements Comparable <Pacjent> {
    private String IMIE, NAZWISKO;
    private int WIEK;

    public Pacjent(String imie, String nazwisko, int wiek) {
        this.IMIE = imie;
        this.NAZWISKO = nazwisko;
        this.WIEK = wiek;
    }

    @Override
    public int compareTo(Pacjent p) {
        return p.WIEK-this.WIEK;
    }

    public String toString() {
        return "{\n\timie: "+this.IMIE+","+"\n\tnazwisko: "+this.NAZWISKO+","+"\n\twiek: "+this.WIEK+"\n{\n";
    }

    public String getImie() {
        return this.IMIE;
    }

    public String getNazwisko() {
        return this.NAZWISKO;
    }

    public int getWiek() {
        return this.WIEK;
    }

}
