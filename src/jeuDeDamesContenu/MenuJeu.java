package jeuDeDamesContenu;

import java.util.Scanner;

public class MenuJeu {

    public static void menuDebutJeu(){
        Scanner scanner = new Scanner(System.in);

        int menu;
        System.out.println("1. afficher les règles");
        System.out.println("2. démarrer une partie");
        System.out.println("3. quitter");
        menu = scanner.nextInt();

        switch (menu){

            case 1 :
                System.out.println("2 joueurs s'affrontent sur un plateau de 10 cases en largeur et 10 cases en longuer (pion blanc VS pion noir)." +
                                    "\nChaque Joueur possède 20 pions et peuvent les déplacer sur leur diagonale vers l'avant." +
                                    "\n");
        }
    }
}
