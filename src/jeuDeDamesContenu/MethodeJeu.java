package jeuDeDamesContenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodeJeu {

    final static List<Pion> listePionBlanc = new ArrayList<>(20);
    final static List<Pion> listePionNoir = new ArrayList<>(20);

    public static void afficherTab(String[][] tab) {
        String c = "ABCDEFGHIJ";
        System.out.print("\t" + "\t");

        for (int i = 1; i < tab.length + 1; i++) {
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

    public static void afficherTabInt(int[][] tab){
        System.out.print("\t" + "\t");

        for (int i = 1; i < tab.length + 1; i++) {
            System.out.print(i + "\t");
        }

        System.out.println();

        for (int i = 0; i < tab.length; i++) {
            System.out.println();

            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + "\t");
            }
        }
    }

    public static String[][] rafraichissementTableau(int[][] plateauEntier, String[][] plateauCar) {
        for (int i = 0; i < plateauEntier.length; i++) {
            for (int j = 0; j < plateauEntier[i].length; j++) {
                if (plateauEntier[i][j] == 1) {
                    plateauCar[i][j] = "N";
                } else if (plateauEntier[i][j] == 2) {
                    plateauCar[i][j] = "⛂";
                } else if (plateauEntier[i][j] == 3) {
                    plateauCar[i][j] = "⛀";
                }
                else if (plateauEntier[i][j] == 4){
                    plateauCar[i][j] = "⛃";
                }
                else if (plateauEntier[i][j] == 5){
                    plateauCar[i][j] = "⛁";
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

    public static void supprimerPionB(Pion pion) {
        listePionBlanc.remove(pion);
    }

    public static void supprimerPionN(Pion pion) {
        listePionNoir.remove(pion);
    }

    public static List<Pion> getListePionBlanc() {
        return listePionBlanc;
    }

    public static List<Pion> getListePionNoir() {
        return listePionNoir;
    }

    public static int coordoneeDame() {
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
                return (i); // Retourne l'indice si la lettre est trouvée
            }
        }
        return -1; // Retourne -1 si la lettre n'est pas trouvée
    }

    public static int coordoneeDameX() {
        Scanner scanner = new Scanner(System.in);

        int saisieX;
        System.out.println("Entrer le chiffre de la case ou vous voulez déplacer votre Dame");
        saisieX = scanner.nextInt();

        return saisieX-1;
    }

    public static int coordoneeDameY() {
        Scanner scanner = new Scanner(System.in);
        String c = "ABCDEFGHIJ";
        String saisieY;
        int i;

        System.out.println("Entrer la lettre de la case ou vous voulez déplacer votre Dame");
        saisieY = scanner.nextLine();

        for (i = 0; i < c.length(); i++) {
            if (saisieY.equals(String.valueOf(c.charAt(i)))) {
                return (i); // Retourne l'indice si la lettre est trouvée
            }
        }
        return -1; // Retourne -1 si la lettre n'est pas trouvée
    }

    public static boolean dansTerrain(int x, int y) {
        return (x >= 0 && x <= 9 && y <= 9 && y >= 0);
    }

    public static Pion pionBlancSelectionner() {
        Scanner scanner = new Scanner(System.in);
        int saisieX;
        int saisieY;

        System.out.println("Entrer le chiffre de la case du pion que vous voulez déplacer");
        saisieX = scanner.nextInt() - 1;
        saisieY = selectionPionY();

        for (Pion p : listePionBlanc) {
            if (saisieX == p.getY() && saisieY == p.getX()) {
                return p;
            }
        }
        return null;
    }

    public static Pion pionNoirSelectionner() {
        Scanner scanner = new Scanner(System.in);
        int saisieX;
        int saisieY;

        System.out.println("Entrer le chiffre de la case du pion que vous voulez déplacer");
        saisieX = scanner.nextInt() - 1;
        saisieY = selectionPionY();

        for (Pion p : listePionNoir) {
            if (saisieX == p.getY() && saisieY == p.getX()) {
                return p;
            }
        }
        return null;
    }

    public static boolean deplacerPionN(Pion pion, boolean droite, int[][] plateau) {
        int taille = 10;

        if (droite) {
            System.out.println(pion.getX());
            if (!dansTerrain(pion.getX() - 1, pion.getY() + 1)) {
                System.out.println("sortie de terrain");
                return false;
            } else if (plateau[pion.getX() - 1][pion.getY() + 1] != 1) {
                System.out.println("case inaccessible");
                return false;
            } else {
                plateau[pion.getX() - 1][pion.getY() + 1] = plateau[pion.getX()][pion.getY()];
                plateau[pion.getX()][pion.getY()] = 1;

                pion.setX(pion.getX() - 1);
                pion.setY(pion.getY() + 1);

                return true;
            }
        } else {
            if (!dansTerrain(pion.getX() - 1, pion.getY() - 1)) {
                System.out.println("sortie de terrain");
                return false;
            } else if (plateau[pion.getX() - 1][pion.getY() - 1] != 1) {
                System.out.println("case inaccessible");
                return false;
            } else {
                plateau[pion.getX() - 1][pion.getY() - 1] = plateau[pion.getX()][pion.getY()];
                plateau[pion.getX()][pion.getY()] = 1;

                pion.setX(pion.getX() - 1);
                pion.setY(pion.getY() - 1);

                return true;
            }
        }
    }

    public static boolean directionPion(){
        Scanner scanner = new Scanner(System.in);
        int saisieUtil;

        System.out.println("Voulez vous vous déplacez votre pion à droite ? tapez 1 pour aller droite. Tapez sur une autre touche pour aller à gauche");
        saisieUtil = scanner.nextInt();

        if (saisieUtil == 1){
            return true;
        }
        return false;
    }

    public static boolean deplacerPionB(Pion pion, boolean droite, int[][] plateau) {
        int taille = 10;

        if (droite) {
            if (!dansTerrain(pion.getX() + 1, pion.getY() + 1)) {
                System.out.println("sortie de terrain");
                return false;
            }

            if (plateau[pion.getX() + 1][pion.getY() + 1] != 1) {
                System.out.println("case inaccessible");
                return false;
            }
            plateau[pion.getX() + 1][pion.getY() + 1] = plateau[pion.getX()][pion.getY()];
            plateau[pion.getX()][pion.getY()] = 1;

            pion.setX(pion.getX() + 1);
            pion.setY(pion.getY() + 1);

            return true;
        } else {
            if (!dansTerrain(pion.getX() + 1, pion.getY() - 1)) {
                System.out.println("sortie de terrain");
                return false;
            } else if (plateau[pion.getX() + 1][pion.getY() - 1] != 1) {
                System.out.println("case inaccessible");
                return false;
            } else {
                plateau[pion.getX() + 1][pion.getY() - 1] = plateau[pion.getX()][pion.getY()];
                plateau[pion.getX()][pion.getY()] = 1;

                pion.setX(pion.getX() + 1);
                pion.setY(pion.getY() - 1);

                return true;
            }
        }
    }

    public static boolean mangerPionN(Pion pion, boolean droite, int[][] plateau) {
        int taille = 10;

        if (droite) {//manger a droite Fonctionne
            if (dansTerrain(pion.getY() + 2, pion.getX() + 2)) {
                if (plateau[pion.getX() + 1][pion.getY() + 1] != 3) {//ajouter dame noir
                    return false;
                }
                for (Pion p : listePionNoir) {
                    if (p.getX() == pion.getY() + 1 && p.getY() == pion.getX() + 1) {
                        supprimerPionN(p);
                        break;
                    }
                }

                if (plateau[pion.getX() + 2][pion.getY() + 2] == 1) {


                    plateau[pion.getX() + 2][pion.getY() + 2] = plateau[pion.getX()][pion.getY()];
                    plateau[pion.getX() + 1][pion.getY() + 1] = 1;
                    plateau[pion.getX()][pion.getY()] = 1;
                    System.out.println("manger !");
                    pion.setX(pion.getX()+2);
                    pion.setY(pion.getY()+2);
                    return true;
                }
            }
        } else {// manger à gauche Fonctionne à continuer les testes.
            if (!dansTerrain(pion.getY() - 2, pion.getX() + 2)) {
                System.out.println("sortie de terrain");
                return false;
            }
            if (plateau[pion.getX() + 1][pion.getY() - 1] != 3) {
                return false;
            }
            for (Pion p : listePionNoir) {
                if (p.getX() == pion.getX() - 1 && p.getY() == pion.getY() + 1) {
                    supprimerPionN(p);
                    break;
                }
            }
            if (plateau[pion.getX() + 2][pion.getY() - 2] == 1) {
                plateau[pion.getX() + 2][pion.getY() - 2] = plateau[pion.getX()][pion.getY()];
                plateau[pion.getX() + 1][pion.getY() - 1] = 1;
                plateau[pion.getX()][pion.getY()] = 1;
                System.out.println("manger !");
                pion.setX(pion.getX()+2);
                pion.setY(pion.getY()-2);
                return true;
            }
        }

        return false;
    }


    public static boolean mangerPionB(Pion pion, boolean droite, int[][] plateau) {
        int taille = 10;

        if (droite) {//manger a droite fonctionne
            if (dansTerrain(pion.getX() + 2, pion.getY() - 2)) {
                if (plateau[pion.getX() - 1][pion.getY() + 1] != 2) {
                    return false;
                }
                for (Pion p : listePionBlanc) {
                    if (p.getX() == pion.getX() + 1 && p.getY() == pion.getY() - 1) {
                        supprimerPionB(p);
                        break;
                    }
                }
                if (plateau[pion.getX() - 2][pion.getY() + 2] == 1) {
                    plateau[pion.getX() - 2][pion.getY() + 2] = plateau[pion.getX()][pion.getY()];
                    plateau[pion.getX() - 1][pion.getY() + 1] = 1;
                    plateau[pion.getX()][pion.getY()] = 1;
                    System.out.println("manger !");
                    pion.setX(pion.getX()-2);
                    pion.setY(pion.getY()+2);
                    return true;
                }
            }
        } else {// manger à gauche Fonctionne
            if (dansTerrain(pion.getX() - 2, pion.getY() - 2)) {
                if (plateau[pion.getX() - 1][pion.getY() - 1] != 2) {
                    return false;
                }
                for (Pion p : listePionBlanc) {
                    if (p.getX() == pion.getX() - 1 && p.getY() == pion.getY() - 1) {
                        supprimerPionB(p);
                        break;
                    }
                }

                if (plateau[pion.getX() - 2][pion.getY() - 2] == 1) {
                    plateau[pion.getX() - 2][pion.getY() - 2] = plateau[pion.getX()][pion.getY()];
                    plateau[pion.getX() - 1][pion.getY() - 1] = 1;
                    plateau[pion.getX()][pion.getY()] = 1;
                    System.out.println("manger !");
                    pion.setX(pion.getX()-2);
                    pion.setY(pion.getY()-2);
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean deplacerOuMangerPionB(Pion pion, boolean droite, int[][] plateau) {
        if (mangerPionN(pion, droite, plateau)) {
            return true;
        } else {
            return deplacerPionB(pion, droite, plateau);
        }
    }


    public static boolean deplacerOuMangerPionN(Pion pion, boolean droite, int[][] plateau) {
        if (mangerPionB(pion, droite, plateau)) {
            return true; // Si le pion a pu manger, retourne true
        } else {
            return deplacerPionN(pion, droite, plateau); // Si le pion n'a pas pu manger, effectue simplement le déplacement
        }
    }

    public static boolean deplacerDame(Pion pion, int xArrivee, int yArrivee, int[][] plateau) {

        int differenceX = xArrivee - pion.getY();
        int differenceY = yArrivee - pion.getX();

        if (Math.abs(differenceX) == Math.abs(differenceY)) {
            int deltaX = differenceX > 0 ? 1 : -1;
            int deltaY = differenceY > 0 ? 1 : -1;

            int x = pion.getX() + deltaX;
            int y = pion.getY() + deltaY;

            while (x != xArrivee && y != yArrivee) {
                if ( plateau[x][y] == pion.getCouleurPion()){
                    System.out.println("Un pion allié est sur le chemin");
                    return false;
                }

                if (plateau[x][y] != 1 && plateau[x][y] != pion.getCouleurPion()) {
                    int ApresMangerX = x + deltaX;
                    int apresMangerY = y + deltaY;
                    if (plateau[ApresMangerX][apresMangerY] != 1 || !dansTerrain(ApresMangerX,apresMangerY)) {
                        System.out.println("Il ne peut pas etre mangé");
                        return false;
                    }
                    if (pion.getCouleurPion()==2) {
                        for (Pion p : listePionBlanc) {
                            if (p.getX() == pion.getX() - 1 && p.getY() == pion.getY() - 1) {
                                supprimerPionB(p);
                                break;
                            }
                        }
                    }
                    else
                    {
                        for (Pion p : listePionNoir) {
                            if (p.getX() == pion.getX() - 1 && p.getY() == pion.getY() - 1) {
                                supprimerPionN(p);
                                break;
                            }
                        }
                    }
                    plateau[x][y]=1;
                    plateau[x+deltaX][y + deltaY] = plateau[pion.getX()][pion.getY()];

                    plateau[pion.getX()][pion.getY()] = 1;

                    pion.setX(xArrivee);
                    pion.setY(yArrivee);
                    return true;
                }
                x += deltaX;
                y += deltaY;
            }

            plateau[xArrivee][yArrivee] = plateau[pion.getX()][pion.getY()];
            plateau[pion.getX()][pion.getY()] = 1;

            pion.setX(xArrivee);
            pion.setY(yArrivee);
            return true;
        }

        return false;
    }

    public static boolean estSurRangéeOpposée(Pion pion) {
        if (pion.getCouleurPion() == 3 && pion.getX() == 0) {
            pion.setEstDame(true);
            return true;
        } else if (pion.getCouleurPion() == 2 && pion.getX() == 9) {
            pion.setEstDame(true);
            return true;
        } else {
            return false;
        }
    }

}
