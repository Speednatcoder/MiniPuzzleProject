    public class Basic extends Puzzle {
        //parametry
        private int kategoria; //nie robie gettera bo sie nie zmienia po utworzeniu kostki
        private boolean smartcube;

        //konstruktor
        public Basic (String model, String marka, double cena, int kategoria, boolean smartcube) {
           super(model, marka, cena);
           if(kategoria >= 2 && kategoria <= 7){
               this.kategoria = kategoria;
           }
           else{
               System.out.println("Kategoria kostki musi być z zakresu 2-7.Przyjeto kategorie domyslna.");
               this.kategoria = 3;
           }
           this.smartcube = smartcube;
        }
        //metody
        public int getKategoria() { //do wykorzystania w maine przy liczeniu kategorii
            return this.kategoria;
        }

        public void opisKategorii(){
            System.out.println("Kostka " + kategoria + "x" + kategoria + "x" + kategoria);
        }
        //---POLIMORFIZM PRZEZ PRZESLANIANIE cz.2a----
        @Override
        public void opis(){
            super.opis();
            opisKategorii();
            if(smartcube){
                System.out.println("Ta kostka to smartcube");
            }
            else{
                System.out.println("Ta kostka nie jest smart kostka");
            }

        }
        //-------------------------------------------

    }
