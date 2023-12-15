package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<Pion> listePionBlanc = new ArrayList<>(20);
    final static List<Pion> listePionNoir = new ArrayList<>(20);

    public static void main(String[] args) {
        afficherTab(tableauJeuDame());
        deplacementHautDroite(tableauJeuDame(),listePionNoir.get(19));
        afficherTab(tableauJeuDame());
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

    public static void ajouterPionB(Pion pion){
        listePionBlanc.add(pion);
    }

    public static void ajouterPionN(Pion pion){
        listePionNoir.add(pion);
    }

    public static String[][] tableauJeuDame(){
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
                    Pion pionBlanc = new Pion(i, j, "⛀");
                    ajouterPionB(pionBlanc);
                    damier[i][j] = pionBlanc.toString();
                }
            }
        }

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0){
                    Pion pionNoir = new Pion(i, j, "⛂");
                    ajouterPionN(pionNoir);
                    damier[i][j] = pionNoir.toString();
                }
            }
        }
        return damier;
    }

    public static void deplacementHautDroite(String[][] tab, Pion pion) {

        if (pion.getX()-1 >= 0 && pion.getY()+1 < tab.length) {

            pion.setX(pion.getX() + 1);
            pion.setY(pion.getY() + 1);

            tab[pion.getX()][pion.getY()] = pion.toString();
        }
        else {
            System.out.println("Déplacement impossible");
        }
    }
}