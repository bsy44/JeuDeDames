package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<Pion> listePionBlanc = new ArrayList<>(20);
    final static List<Pion> listePionNoir = new ArrayList<>(20);

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

    public static void ajouterPionB(Pion pion){
        listePionBlanc.add(pion);
    }

    public static void ajouterPionN(Pion pion){
        listePionNoir.add(pion);
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

//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < damier.length; j++) {
//                if ((i + j) % 2 != 0) {
//                    damier[i][j] = "⛀";
//                }
//            }
//        }
//
//        for (int i = 9; i > 5; i--) {
//            for (int j = 0; j < damier.length; j++) {
//                if ((i + j) % 2 != 0)
//                    damier[i][j] = "⛂";
//            }
//        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0) {
                    Pion pionBlanc = new Pion(i, j, 0);
                    ajouterPionB(pionBlanc);
                    damier[i][j] = "⛂";
                }
            }
        }

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0){
                    Pion pionNoir = new Pion(i, j, 1);
                    ajouterPionN(pionNoir);
                    damier[i][j] = "⛀";
                }
            }
        }
        return damier;
    }

    public static boolean espaceDisponible(String[][] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (i < 0 || j < 0 || i > 9 || j > 9){
                    return false;
                }
                if (tab[i][j].equals("⛂") || tab[i][j].equals("⛀")){
                    return false;
                }
            }
        }
        return true;
    }
}
