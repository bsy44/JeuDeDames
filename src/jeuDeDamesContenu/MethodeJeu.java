package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<Pion> listePionBlanc = new ArrayList<>(20);
    final static List<Pion> listePionNoir = new ArrayList<>(20);

    public static void main(String[] args) {
        afficherTab(Plateau.tableauJeuDame(Plateau.plateauPion()));

        int [][] t = new int[10][10];
        t=Plateau.plateauPion();
Plateau.afficherTab(Plateau.tableauJeuDame(t));

        System.out.println(deplacerPion(listePionBlanc.get(16),4,3,t));
        Plateau.afficherTab(Plateau.tableauJeuDame(t));

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

    public static void ajouterPionB(Pion pion) {
        for (Pion pionExistant : listePionBlanc) {
            if (pionExistant.getIdPion() == pion.getIdPion()) {
                pionExistant.setX(pion.getX());
                pionExistant.setY(pion.getY());
                return;
            }
        }
        listePionBlanc.add(pion);
    }

    public static void ajouterPionN(Pion pion) {
        for (Pion existingPion : listePionNoir) {
            if (existingPion.getIdPion() == pion.getIdPion()) {
                existingPion.setX(pion.getX());
                existingPion.setY(pion.getY());
                return;
            }
        }
        listePionNoir.add(pion);
    }

    public static void supprimerPionB(Pion  pion){
        listePionBlanc.remove(pion);
    }

    public static void supprimerPionN(Pion  pion){
        listePionNoir.remove(pion);
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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0) {
                    Pion pionBlanc = new Pion(i, j, 1);
                    ajouterPionB(pionBlanc);
                    damier[i][j] = pionBlanc.toString();
                }
            }
        }

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0){
                    Pion pionNoir = new Pion(i, j, 2);
                    ajouterPionN(pionNoir);
                    damier[i][j] = pionNoir.toString();
                }
            }
        }
        return damier;
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

    public static boolean deplacerPion(Pion pion, int ligneArrivee, int colonneArrivee, int [][] plateau) {
        int taille = 10;

        if (!dansTerrain(ligneArrivee, colonneArrivee)) {
            System.out.println("ok");
            return false;
        }

        if (plateau[ligneArrivee][colonneArrivee] != 1) {
            System.out.println("aaa");
            return false;
        }
        if (Math.abs(ligneArrivee - pion.getX()) == 1 && Math.abs(colonneArrivee - pion.getY()) == 1) {
            plateau[ligneArrivee][colonneArrivee] = plateau[pion.getX()][pion.getY()];
            plateau[pion.getX()][pion.getY()] = 1;
            return true;
        }
            return false;
    }

    public static boolean mangerPionN(Pion pion, int ligneArrivee, int colonneArrivee, int[][] plateau) {
        int taille = 10;

            if (!dansTerrain(ligneArrivee, colonneArrivee)) {
                return false;
            }

            if (plateau[ligneArrivee][colonneArrivee] == 1 || plateau[ligneArrivee][colonneArrivee] == 3 || plateau[ligneArrivee][colonneArrivee] == 0) {
                return false;
            }

            if (ligneArrivee > pion.getX()) {//manger a droite
                if (dansTerrain(ligneArrivee + 1, colonneArrivee + 1)) {
                    if (plateau[ligneArrivee + 1][colonneArrivee + 1] == 0) {
                        plateau[ligneArrivee + 1][colonneArrivee + 1] = plateau[pion.getX()][pion.getY()];
                        plateau[ligneArrivee][colonneArrivee] = 1;
                        plateau[pion.getX()][pion.getY()] = 1;

                        for (Pion p : listePionNoir) {
                            if (p.getX() == ligneArrivee && p.getY() == colonneArrivee) {
                                supprimerPionN(p);
                            }
                        }
                        return true;
                    }
                }
            }
            else {// manger à gauche
                if (dansTerrain(ligneArrivee - 1, colonneArrivee + 1)) {
                    if (plateau[ligneArrivee - 1][colonneArrivee + 1] == 0) {
                        Pion pionMange = new Pion(ligneArrivee - 1, colonneArrivee + 1, 1);
                        plateau[ligneArrivee - 1][colonneArrivee + 1] = plateau[pion.getX()][pion.getY()];
                        plateau[ligneArrivee][colonneArrivee] = 1;
                        plateau[pion.getX()][pion.getY()] = 1;

                        for (Pion p : listePionNoir) {
                            if (p.getX() == ligneArrivee && p.getY() == colonneArrivee) {
                                supprimerPionN(p);
                            }
                        }
                        return true;
                    }
                }
            }

            return false;
        }

    public static boolean mangerPionB(Pion pion, int ligneArrivee, int colonneArrivee, int[][] plateau) {
        int taille = 10;

        if (!dansTerrain(ligneArrivee, colonneArrivee)) {
            return false;
        }

        if (plateau[ligneArrivee][colonneArrivee] == 2 || plateau[ligneArrivee][colonneArrivee] == 2 || plateau[ligneArrivee][colonneArrivee] == 0) {
            return false;
        }

        if (ligneArrivee < pion.getX()) { // manger à gauche
            if (dansTerrain(ligneArrivee - 1, colonneArrivee - 1)) {
                if (plateau[ligneArrivee - 1][colonneArrivee - 1] == 0) {
                    plateau[ligneArrivee - 1][colonneArrivee - 1] = plateau[pion.getX()][pion.getY()];
                    plateau[ligneArrivee][colonneArrivee] = 2;
                    plateau[pion.getX()][pion.getY()] = 2;

                    for (Pion p : listePionBlanc) {
                        if (p.getX() == ligneArrivee && p.getY() == colonneArrivee) {
                            supprimerPionB(p);
                        }
                    }
                    return true;
                }
            }
        } else { // manger à droite
            if (dansTerrain(ligneArrivee + 1, colonneArrivee - 1)) {
                if (plateau[ligneArrivee + 1][colonneArrivee - 1] == 0) {
                    Pion pionMange = new Pion(ligneArrivee + 1, colonneArrivee - 1, 3);
                    plateau[ligneArrivee + 1][colonneArrivee - 1] = plateau[pion.getX()][pion.getY()];
                    plateau[ligneArrivee][colonneArrivee] = 2;
                    plateau[pion.getX()][pion.getY()] = 2;

                    for (Pion p : listePionBlanc) {
                        if (p.getX() == ligneArrivee && p.getY() == colonneArrivee) {
                            supprimerPionB(p);
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }


}
