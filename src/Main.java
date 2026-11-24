/**
 * Projekt dodatkowy
 * @author Speednatcoder
 * @since 23.11.2026
 * Mały projekt o różnych układankach.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int budzet = 500;
        int dwojki = 0;
        int trojki = 0;
        double suma = 0;

        Puzzle[] kolekcja = new Puzzle[6];
        //---NIEJAWNY UPCASTING---
        kolekcja[0] = new Basic("RS3M", "MoYu", 120, 2, false);
        kolekcja[1] = new Basic("GAN16-Minions Edition", "GAN", 433.01, 3, true);
        kolekcja[2] = new Basic("Weilongv11","MoYu", 65.45, 3, false);
        kolekcja[3] = new Other("MGC", "YJ", 89.16, "Megaminx", true);
        kolekcja[4] = new Other("QiYi", 22.91, "Gear", false); //krótszy konstruktor
        kolekcja[5]= new Other("Standard", "Ao", 38.98, "Master Magic", false);
        //-----------------------

        System.out.println("UKLADANKI - kolekcja ");
        //tutaj polimorfizm przez przeslanianie w srodku
        for(Puzzle i: kolekcja) {
            i.opis();
        }
        System.out.println();
        //--- DOWNCASTING---
        for (Puzzle i : kolekcja) {
            // Próba: i.opisKategorii(); -> BŁĄD KOMPILACJI
            // Sprawdzamy rzeczywisty typ na stercie:
            if (i instanceof Basic) {
                //Downcasting
                Basic basic = (Basic) i;
                int pomocnicza = basic.getKategoria();
                if (pomocnicza == 3) {
                    trojki++;
                    //model jest protected wiec moge tak zrobic
                    System.out.println(basic.model);
                    basic.opisKategorii();
                    System.out.println("to tzw. kostka Rubika - najpopularniejsza z ukladanek.\n");
                } else if(pomocnicza == 2) {
                    dwojki++;
                }
                else{
                    basic.opisKategorii();
                }
            }
        }

        System.out.println("Liczba kostek 2x2: " + dwojki);
        System.out.println("Liczba kostek 3x3: " + trojki);

        System.out.println("\nInne kostki w kolekcji:");

        for(Puzzle i : kolekcja){
            if(i instanceof Other){
                // Downcasting
                Other other = (Other) i;
                System.out.println(other.getNazwa());
            }
        }
        //---------------

        for(Puzzle i : kolekcja){
            suma += i.getCena();
        }
        System.out.println("\nCena kolekcji: \n" + suma + " zl.");

        //test walidacji kategorii
        System.out.println("\nProba dodania kostki 17x17x17");
        Basic osiemNaOsiem = new Basic("HuangLong", "YuXin ", 1861.21, 17, false);
        osiemNaOsiem.opis();
        //tutaj poliformizm ad-hoc
        System.out.print("\nJak chcesz kupic GAN16-Minions Edition... \n");
        kolekcja[1].zakup();
        System.out.print("\nDla budzetu: " + budzet + " zl:");
        kolekcja[1].zakup(budzet);
        System.out.print("\nTeraz wpisz wlasny budzet: ");
        Scanner skaner = new Scanner(System.in);
        budzet = skaner.nextInt();
        kolekcja[1].zakup(budzet);
        skaner.close();

    }

}
