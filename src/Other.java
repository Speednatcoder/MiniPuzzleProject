public class Other extends Puzzle{
    //parametry
    private String nazwa;
    private boolean oficjalne;

    //konstruktory (dwa)
    public Other(String model, String marka, double cena, String nazwa, boolean oficjalne) {
        super(model, marka, cena);
        this.nazwa = nazwa;
        this.oficjalne = oficjalne;
    }

    public Other(String marka, double cena, String nazwa, boolean oficjalne) {
        super(marka,cena);
        this.nazwa = nazwa;
        this.oficjalne = oficjalne;
    }

    //metody

    public String getNazwa() { //do wykorzystania w maine przy liczeniu kategorii
        return this.nazwa;
    }

    //---POLIMORFIZM PRZEZ PRZESLANIANIE cz.2a----
    @Override
    public void opis() {
        super.opis();
        System.out.println("Nazwa kostki: " + nazwa);
        if (oficjalne) {
            System.out.println("Kostka oficjalna - dopuszczona do konkurencji WCA.");
        } else {
            System.out.println("Kostka nieoficjalna - niedopuszczona do konkurencji WCA.");
        }
    }
    //-------------------------------------------

}
