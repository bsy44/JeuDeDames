package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<Pion> listePionBlanc = new ArrayList<>(20);
    final static List<Pion> listePionNoir = new ArrayList<>(20);

    public static void main(String[] args) {

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

    public static void ajouterPionB(Pion pion){
        listePionBlanc.add(pion);
    }

    public static void ajouterPionN(Pion pion){
        listePionNoir.add(pion);
    }

//    public static void deplacementHautDroite(String[][] tab, Pion pion) {
//
//        if (pion.getX()-1 >= 0 && pion.getY()+1 < tab.length) {
//
//            pion.setX(pion.getX() + 1);
//            pion.setY(pion.getY() + 1);
//
//            tab[pion.getX()][pion.getY()] = pion.toString();
//        }
//        else {
//            System.out.println("Déplacement impossible");
//        }
//    }

    public static boolean dansTerrain (int x, int y){
        return (x >= 0 && x <= 9 && y <= 9 && y >= 0);
    }

    public static boolean deplacerPion(Pion pion, int ligneArrivee, int colonneArrivee, String[][] plateau) {
        int taille = 10;

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
