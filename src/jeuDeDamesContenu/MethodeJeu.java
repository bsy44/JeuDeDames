package jeuDeDamesContenu;

import java.util.Scanner;

public class MethodeJeu {
    public static void main(String[] args) {
        afficherTab(TableauJeuDame());
    }

    public static int premierJoueur() {
        int premierJ = 2, r;
        r = (int) Math.random();

        if (r < 0.5)
            premierJ = 1;
        return premierJ;
    }

    public static String creationJ() {
        Scanner scanner = new Scanner(System.in);
        String pseudo;
        pseudo = scanner.nextLine();
        return pseudo;
    }

    public static void afficherTab(String[][] tab) {
        String c = "ABCDEFGHIJ";
        System.out.print("\t"+"\t");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i+1 + "\t");
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

    public static String[][] TableauJeuDame() {
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
                if ((i + j) % 2 != 0)
                    damier[i][j] = "⛀";
            }
        }
        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < damier.length; j++) {
                if ((i + j) % 2 != 0)
                    damier[i][j] = "⛂";
            }
        }return damier;
    }

}
