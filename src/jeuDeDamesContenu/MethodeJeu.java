package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<Pion> listePionBlanc = new ArrayList<>(20);
    final static List<Pion> listePionNoir = new ArrayList<>(20);

    public static void main(String[] args) {
        afficherTab(Plateau.creerDamier(Plateau.plateauPion()));
        int [][] t = new int[10][10];
        t = Plateau.plateauPion();
        Plateau.afficherTab(t);




//        System.out.println(deplacerPionN());
//        afficherTab(rafraichissementTableau(t,Plateau.creerDamier(t)));
//
//        System.out.println();
//
//        System.out.println(+", "+ listePionNoir.get(16).getY());
//        System.out.println(deplacerPion(listePionNoir.get(16),5,2,t));
//        afficherTab(rafraichissementTableau(t,Plateau.creerDamier(t)));
//        System.out.println(listePionNoir.get(16).getX()+", "+ listePionNoir.get(16).getY());
//        System.out.println();
//
//        System.out.println(deplacerPion(listePionNoir.get(16),4,1,t));
//        afficherTab(rafraichissementTableau(t,Plateau.creerDamier(t)));
//        System.out.println(listePionNoir.get(16).getX()+", "+ listePionNoir.get(16).getY());
//
//        System.out.println();
//
//        System.out.println(mangerPionN(listePionBlanc.get(15),4,1, t));
//        afficherTab(rafraichissementTableau(t,Plateau.creerDamier(t)));
//        System.out.println(listePionBlanc.get(16).getX()+", "+ listePionBlanc.get(16).getY());
//
//        System.out.println();
//
//        System.out.println(mangerPionN(listePionBlanc.get(15), 6,1,t));
//        afficherTab(rafraichissementTableau(t,Plateau.creerDamier(t)));
//        System.out.println(listePionBlanc.get(15).getX()+", "+ listePionBlanc.get(15).getY());
//
//        System.out.println(deplacerPion(listePionBlanc.get(15),6,3,t));
//        afficherTab(rafraichissementTableau(t,Plateau.creerDamier(t)));
    }

    public static int premierJoueur (){
        int premierJ = 0;
        double aleatoire = (int) Math.random();

        if (aleatoire < 0.5) {
            premierJ = 1;
        }

        return premierJ;
    }

    public static void afficherTab (String[][] tab){
        String c = "ABCDEFGHIJ";
        System.out.print("\t"+"\t");

        for (int i = 1; i < tab.length+1; i++) {
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

    public static String[][] rafraichissementTableau(int[][] plateauEntier, String[][] plateauCar){
        for (int i = 0; i < plateauEntier.length; i++) {
            for (int j = 0; j < plateauEntier[i].length; j++) {
                if (plateauEntier[i][j] == 1){
                    plateauCar[i][j] = "N";
                }
                else if (plateauEntier[i][j] == 2){
                    plateauCar[i][j] ="⛂";
                }
                else if (plateauEntier[i][j] == 3){
                    plateauCar[i][j] ="⛀";
                }
                else {
                    plateauCar[i][j] = "B";
                }
            }
        }
        return plateauCar;
    }

    public static void ajouterPionB(Pion pion) {
        listePionBlanc.add(pion);
    }

    public static void ajouterPionN(Pion pion) {
        listePionNoir.add(pion);
    }

    public static void supprimerPionB(Pion  pion){
        listePionBlanc.remove(pion);
    }

    public static void supprimerPionN(Pion  pion){
        listePionNoir.remove(pion);
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

    public static boolean dansTerrain (int x, int y){
        return (x >= 0 && x <= 9 && y <= 9 && y >= 0);
    }

    public static Pion pionBlancSelectionner(int[][] tab){
        Scanner scanner = new Scanner(System.in);
        int saisieX;
        int saisieY;

        System.out.println("Entrer le chiffre de la case du pion que vous voulez déplacer");
        saisieX = scanner.nextInt();
        saisieY = selectionPionY();

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if ((saisieX == tab[i][j] && tab[i][j] == 2) && (saisieY == tab[i][j] && tab[i][j] == 2)){
                    Pion p = new Pion(saisieX,saisieY,0);
                    return p;
                }

            }
        }
        return null;
    }

    public static Pion pionNoirSelectionner(int[][] tab){
        Scanner scanner = new Scanner(System.in);
        int saisieX;
        int saisieY;

        System.out.println("Entrer le chiffre de la case du pion que vous voulez sélectionner");
        saisieX = scanner.nextInt();
        saisieY = selectionPionY();

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if ((saisieX == tab[i][j] && tab[i][j] == 3) && (saisieY == tab[i][j] && tab[i][j] == 3)){
                    Pion p = new Pion(saisieX,saisieY,1);
                    return p;
                }

            }
        }
        return null;
    }

    public static boolean deplacerPion(Pion pion, int ligneArrivee, int colonneArrivee, int [][] plateau) {
        int taille = 10;

        if (droite) {
            if (!dansTerrain(pion.getX() + 1, pion.getY() - 1)) {
                System.out.println("ok");
                return false;
            }

            else if (plateau[pion.getX() + 1][pion.getY() - 1] != 1) {
                System.out.println("aaa");
                return false;
            }
            else {
                plateau[pion.getX() + 1][pion.getY() - 1] = plateau[pion.getX()][pion.getY()];
                plateau[pion.getX()][pion.getY()] = 1;

                pion.setX(pion.getX() + 1);
                pion.setY(pion.getY() - 1);

                return true;
            }
        } else {
            if (!dansTerrain(pion.getX() - 1, pion.getY() - 1)) {
                System.out.println("ok");
                return false;
            }

            else if (plateau[pion.getX() - 1][pion.getY() - 1] != 1) {
                System.out.println("aaa");
                return false;
            }
            else {
                plateau[pion.getX() - 1][pion.getY() - 1] = plateau[pion.getX()][pion.getY()];
                plateau[pion.getX()][pion.getY()] = 1;

                pion.setX(pion.getX() - 1);
                pion.setY(pion.getY() - 1);

                return true;
            }
        }
    }

    public static boolean deplacerPionB(Pion pion, boolean droite, int [][] plateau) {
        int taille = 10;

        if(droite){
            if (!dansTerrain(pion.getX()+1, pion.getY()+1)) {
                System.out.println("ok");
                return false;
            }

            if (plateau[pion.getX()+1][pion.getY()+1] != 1) {
                System.out.println("aaa");
                return false;
            }
            plateau[pion.getX()+1][pion.getY()+1] = plateau[pion.getX()][pion.getY()];
            plateau[pion.getX()][pion.getY()] = 1;

            pion.setX(pion.getX()+1);
            pion.setY(pion.getY()+1);

            return true;
        }
        else {
            if (!dansTerrain(pion.getX() - 1, pion.getY() + 1)) {
                System.out.println("ok");
                return false;
            }

            else if (plateau[pion.getX() - 1][pion.getY() + 1] != 1) {
                System.out.println("aaa");
                return false;
            }
            else {
                plateau[pion.getX() - 1][pion.getY() + 1] = plateau[pion.getX()][pion.getY()];
                plateau[pion.getX()][pion.getY()] = 1;

                pion.setX(pion.getX() + 1);
                pion.setY(pion.getY() + 1);

                return true;
            }
        }
    }

    public static boolean mangerPionN(Pion pion, boolean droite, int[][] plateau) {
        int taille = 10;

        if (droite) {//manger a droite
            if (dansTerrain(pion.getX() + 2, pion.getY() + 2)) {
                if (plateau[pion.getX()+1][pion.getY()+1] != 3) {
                    return false;
                }
                for (Pion p : listePionNoir) {
                    if (p.getX() == pion.getX()+1 && p.getY() == pion.getY()+1) {
                        listePionNoir.remove(p);
                        break;
                    }
                }
                if (plateau[pion.getX() + 1][pion.getY() + 1] == 1) {

                    plateau[pion.getX() + 2][pion.getY() + 2] = plateau[pion.getX()][pion.getY()];
                    plateau[pion.getX()+1][pion.getY()+1] = 1;
                    plateau[pion.getX()][pion.getY()] = 1;
                    System.out.println("manger !");
                    return true;
                }
            }
        }
        else {// manger à gauche
            if (dansTerrain(pion.getX() - 2, pion.getY() + 2)) {
                if (plateau[pion.getX()-1][pion.getY()+1] != 3) {
                    return false;
                }
                for (Pion p : listePionNoir) {
                    if (p.getX() == pion.getX()-1 && p.getY() == pion.getY()+1) {
                        listePionNoir.remove(p);
                        break;
                    }
                }
                if (plateau[pion.getX() - 2][pion.getY() + 2] == 1) {
                    plateau[pion.getX() - 2][pion.getY() + 2] = plateau[pion.getX()][pion.getY()];
                    plateau[pion.getX()+1][pion.getY()+1] = 1;
                    plateau[pion.getX()][pion.getY()] = 1;
                    System.out.println("manger !");
                    return true;
                }
            }
        }

        return false;
    }


    public static boolean mangerPionB(Pion pion, boolean droite, int[][] plateau) {
        int taille = 10;

        if (droite) {//manger a droite
            if (dansTerrain(pion.getX() + 2, pion.getY() - 2)) {
                if (plateau[pion.getX()+1][pion.getY()-1] != 3) {
                    return false;
                }
                for (Pion p : listePionNoir) {
                    if (p.getX() == pion.getX()+1 && p.getY() == pion.getY()-1) {
                        listePionNoir.remove(p);
                        break;
                    }
                }
                if (plateau[pion.getX() + 1][pion.getY() - 1] == 1) {

                    plateau[pion.getX() + 2][pion.getY() - 2] = plateau[pion.getX()][pion.getY()];
                    plateau[pion.getX()+1][pion.getY()-1] = 1;
                    plateau[pion.getX()][pion.getY()] = 1;
                    System.out.println("manger !");
                    return true;
                }
            }
        }
        else {// manger à gauche
            if (dansTerrain(pion.getX() - 2, pion.getY() - 2)) {
                if (plateau[pion.getX()-1][pion.getY()-1] != 3) {
                    return false;
                }
                for (Pion p : listePionNoir) {
                    if (p.getX() == pion.getX()-1 && p.getY() == pion.getY()-1) {
                        listePionNoir.remove(p);
                        break;
                    }
                }
                if (plateau[pion.getX() - 2][pion.getY() - 2] == 1) {
                    plateau[pion.getX() - 2][pion.getY() - 2] = plateau[pion.getX()][pion.getY()];
                    plateau[pion.getX()+1][pion.getY()-1] = 1;
                    plateau[pion.getX()][pion.getY()] = 1;
                    System.out.println("manger !");
                    return true;
                }
            }
        }

        return false;
    }

}
