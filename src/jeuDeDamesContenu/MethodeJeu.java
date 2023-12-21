package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<Pion> listePionBlanc = new ArrayList<>(20);
    final static List<Pion> listePionNoir = new ArrayList<>(20);

    public static void main(String[] args) {
        String[][] plateau = MethodeJeu.tableauJeuDame();

        // Affichage du plateau initial
        MethodeJeu.afficherTab(plateau);

        // Création de quelques pions et tests de déplacement
        Pion pionTest = new Pion(2, 3, 1); // Pion blanc en position (2, 3)
        plateau[2][3] = pionTest.toString(); // Mettre le pion sur le plateau

        // Déplacement du pion blanc vers le haut à droite (test de déplacement)
        // MethodeJeu.deplacementHautDroite(plateau, pionTest);

        // Affichage du plateau après le déplacement
        MethodeJeu.afficherTab(plateau);

        // Test de capture des pions adverses
        // Méthode de capture de pions noirs pour tester
        int[][] plateauPions = new int[10][10]; // Un tableau simple de 10x10 pour représenter le plateau
        plateauPions[3][4] = 2; // Pion noir en position (3, 4)
        plateauPions[4][5] = 1; // Pion blanc en position (4, 5)

        Pion pionNoirTest = new Pion(3, 4, 2); // Pion noir
        MethodeJeu.mangerPionN(pionNoirTest, 4, 5, plateauPions); // Capture du pion blanc

        // Affichage du plateau après la capture
        // MethodeJeu.afficherTab(plateauPions); // Assure-toi que ta méthode afficherTab accepte un tableau d'entiers pour la capture

        // Tests supplémentaires ici...

        // N'oublie pas de vérifier le résultat des actions pour savoir si elles ont réussi ou échoué et d'afficher les messages correspondants.
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

    public static void ajouterPionB(Pion pion){
        listePionBlanc.add(pion);
    }

    public static void ajouterPionN(Pion pion){
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

    public static boolean deplacerPion(Pion pion, int ligneArrivee, int colonneArrivee, int [][] plateau) {
        int taille = 10;

        if (ligneArrivee < 0 || ligneArrivee >= taille || colonneArrivee < 0 || colonneArrivee >= taille) {
            return false;
        }

        if (plateau[ligneArrivee][colonneArrivee] != 0) {
            return false;
        }
        if (Math.abs(ligneArrivee - pion.getX()) == 1 && Math.abs(colonneArrivee - pion.getY()) == 1) {
            plateau[ligneArrivee][colonneArrivee] = plateau[pion.getX()][pion.getY()];
            plateau[pion.getX()][pion.getY()] = 0;
            return true;
        }
            return false;
    }


        public static boolean mangerPionN(Pion pion, int ligneArrivee, int colonneArrivee, int[][] plateau) {
            int taille = 10;

            if (!dansTerrain(ligneArrivee, colonneArrivee)) {
                return false;
            }

            if (plateau[ligneArrivee][colonneArrivee] == 1 || plateau[ligneArrivee][colonneArrivee] == pion.getCouleurPion() || plateau[ligneArrivee][colonneArrivee] == 0) {
                return false;
            }

            if (ligneArrivee > pion.getX() && pion.getCouleurPion() == 1) {//manger a droite
                if (dansTerrain(ligneArrivee + 1, colonneArrivee + 1)) {
                    if (plateau[ligneArrivee + 1][colonneArrivee + 1] == 0) {
                        Pion pionMange = new Pion(ligneArrivee + 1, colonneArrivee + 1, 3);
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
                        Pion pionMange = new Pion(ligneArrivee - 1, colonneArrivee + 1, 3);
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

        if (plateau[ligneArrivee][colonneArrivee] == 2 || plateau[ligneArrivee][colonneArrivee] == pion.getCouleurPion() || plateau[ligneArrivee][colonneArrivee] == 0) {
            return false;
        }

        if (ligneArrivee < pion.getX() && pion.getCouleurPion() == 2) { // manger à gauche
            if (dansTerrain(ligneArrivee - 1, colonneArrivee - 1)) {
                if (plateau[ligneArrivee - 1][colonneArrivee - 1] == 0) {
                    Pion pionMange = new Pion(ligneArrivee - 1, colonneArrivee - 1, 3);
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
