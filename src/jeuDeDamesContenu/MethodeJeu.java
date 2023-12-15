package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<String> listePionBlanc = new ArrayList<>(20);
    final static List<String> listePionNoir = new ArrayList<>(20);

    public static void main(String[] args) {
        afficherTab(TableauJeuDame());
    }

    public static int premierJoueur (){
        int premierJ = 2;
        double aleatoire = (int) Math.random();

        if (aleatoire < 0.5)
            premierJ=1;
        return premierJ;
    }

    public static String creationJ() {
        Scanner scanner = new Scanner(System.in);
        String pseudo;

        return pseudo = scanner.nextLine();
    }

    public static void afficherTab (String [][] tab){
        String c = "ABCDEFGHIJ";
        System.out.print("\t"+"\t");

        for (int i = 0; i < tab.length+1; i++) {
            System.out.print(i + "\t");
        }

        System.out.println();

        for (int i = 0; i < tab.length; i++) {
            System.out.println();
            System.out.print(c.charAt(i) + "\t" + "\t");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + "\t");
            }
        }
    }

    public static String[][] TableauJeuDame (){
        String[][] damier = new String[10][10];

        for (int i = 0; i < damier.length; i++) {
            for (int j = 0; j < damier[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    damier[i][j] = "B";
                } else {
                    damier[i][j] = "N";
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0) {
                    damier[i][j] = "⛀";
                }
            }
        }

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0)
                    damier[i][j] = "⛂";
            }
        }
        return damier;
    }

        public boolean deplacerPion (int ligneDepart, int colonneDepart, int ligneArrivee, int colonneArrivee, char joueur, char[][] plateau) {
            int taille = 10;
            if (ligneArrivee < 0 || ligneArrivee >= taille || colonneArrivee < 0 || colonneArrivee >= taille) {
                return false;
            }

            if (plateau[ligneArrivee][colonneArrivee] != 'N') {
                return false;
            }

            if (Math.abs(ligneArrivee - ligneDepart) == 1 && Math.abs(colonneArrivee - colonneDepart) == 1) {

                plateau[ligneArrivee][colonneArrivee] = plateau[ligneDepart][colonneDepart];
                plateau[ligneDepart][colonneDepart] = 'N';
                return true;
            }

            if (Math.abs(ligneArrivee - ligneDepart) == 2 && Math.abs(colonneArrivee - colonneDepart) == 2) {

                int lignePionAdverse = (ligneArrivee + ligneDepart) / 2;
                int colonnePionAdverse = (colonneArrivee + colonneDepart) / 2;

                if (plateau[lignePionAdverse][colonnePionAdverse] != 'N' &&
                        plateau[lignePionAdverse][colonnePionAdverse] != joueur /*pion du joueur*/) {

                    plateau[ligneArrivee][colonneArrivee] = plateau[ligneDepart][colonneDepart];
                    plateau[ligneDepart][colonneDepart] = 'N';
                    plateau[lignePionAdverse][colonnePionAdverse] = 'N';

                    return true;
                }
            }

            return false;
        }

}
