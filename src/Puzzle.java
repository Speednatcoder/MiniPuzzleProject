/**
 Klasa abstrakcyjna Puzzle
 */
public abstract class Puzzle {
    //parametry
    /**
     * Żeby nie ograniczać parametru "kategorie" do kilku możliwości i mieć możliwość
     * rozwoju projektu o dodatkowe parametry w poszczególnych kategoriach
     * zamiast typu wyliczeniowego tworzymy kilka klas dziedziczących po Układance
     */
   protected String model;
   protected String marka;
   private double cena;

   //konstruktory
   public Puzzle (String model, String marka, double cena){
      this.model = model;
      this.marka = marka;
      setNowaCena(cena); //choc moze byc this.cena, ale wtedy mozna ominac walidacje
   }
   //konstruktor do Other
   public Puzzle(String marka, double cena){
      model = "jedyna dla tej firmy";
      this.marka = marka;
      setNowaCena(cena);
   }

   //metody
   public double getCena(){
      return this.cena; //this nie musi tutaj byc
   }
   public void setNowaCena(double cena){
      if(cena <0){
         System.out.println("Cena nie moze byc ujemna!! \n");
      }
      else{
         this.cena = cena;
      }

   }

   //---POLIMORFIZM PRZEZ PRZESLANIANIE cz.1----
   public void opis(){
      System.out.println("\nKostka " + model + " produkowana przez " + marka + " kosztuje: " + cena + " zlotych.");
   }
   //---------------------------------------
   //---POLIMORFIZM AD-HOC------------------
   public void zakup(){ //czy musze to dawac int cena?????
      if(cena > 100.0){
         System.out.println("Studencie - nie stac Cie :( \n");
      }
      else{
         System.out.println("Kostka budzetowa - idealna dla Ciebie. \n");
      }
   }
   public void zakup(double budzet){
      if(cena > budzet){
         System.out.println("Nie stac Cie :( \n");
      }
      else{
         System.out.println("Kostka idealna dla Ciebie. \n");
      }
   }
   //-------------------------------------

}
