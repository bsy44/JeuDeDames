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

    public static int selectionPionX(){
        Scanner scanner = new Scanner(System.in);

        int saisieX;
        System.out.println("Entrer le chiffre de la case du pion que vous voulez déplacer");
        saisieX = scanner.nextInt();

        return saisieX;
    }

    public static int selectionPionY() {
        Scanner scanner = new Scanner(System.in);
        String c = "ABCDEFGHIJ";
        String saisieY;
        int i;

        System.out.println("Entrer la lettre de la case du pion que vous voulez déplacer");
        saisieY = scanner.nextLine();

        for (i = 0; i < c.length(); i++) {
            if (saisieY.equals(String.valueOf(c.charAt(i)))) {
                return (i+1); // Retourne l'indice si la lettre est trouvée
            }
        }
        return -1; // Retourne -1 si la lettre n'est pas trouvée
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

    public static boolean dansTerrain (int x, int y){
        return (x >= 0 && x <= 9 && y <= 9 && y >= 0);
    }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0) {
                    Pion pionBlanc = new Pion(i, j, 0);
                    ajouterPionB(pionBlanc);
                    damier[i][j] = "⛂";
                }
            }
        }

    public static boolean deplacerPion(Pion pion, int ligneArrivee, int colonneArrivee, String[][] plateau) {
        int taille = 10;
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

        if (ligneArrivee < 0 || ligneArrivee >= taille || colonneArrivee < 0 || colonneArrivee >= taille) {
            return false;
        }

        if (plateau[ligneArrivee][colonneArrivee] != "N") {
            return false;
        }
        if (Math.abs(ligneArrivee - pion.getX()) == 1 && Math.abs(colonneArrivee - pion.getY()) == 1) {
            plateau[ligneArrivee][colonneArrivee] = plateau[pion.getX()][pion.getY()];
            plateau[pion.getX()][pion.getY()] = "N";
            return true;
        }
            return false;
    }
}
