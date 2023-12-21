package jeuDeDamesContenu;

public class Plateau {

    public static void main(String[] args) {
        MethodeJeu.afficherTab(tableauJeuDame(plateauPion()));
    }



    public static String[][] tableauJeuDame(int[][] tabPionEntier) {
        String[][] damier = new String[10][10];

        for (int i = 0; i < tabPionEntier.length; i++) {
            for (int j = 0; j < tabPionEntier[i].length; j++) {
                if (tabPionEntier[i][j] == 0) {
                    damier[i][j] = "B";
                } else {
                    damier[i][j] = "N";
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tabPionEntier.length; j++) {
                if (tabPionEntier[i][j] == 2) {
                    Pion pionBlanc = new Pion(i, j, 0);
                    MethodeJeu.ajouterPionB(pionBlanc);
                    damier[i][j] = "⛂";
                }
            }
        }

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < tabPionEntier.length; j++) {
                if (tabPionEntier[i][j] == 3) {
                    Pion pionNoir = new Pion(i, j, 1);
                    MethodeJeu.ajouterPionN(pionNoir);
                    damier[i][j] = "⛀";
                }
            }
        }
        return damier;
    }

    public static int[][] plateauPion(){
        int[][] tabPion = new int[10][10];

        for (int i = 0; i < tabPion.length; i++) {
            for (int j = 0; j < tabPion[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    tabPion[i][j] = 0;
                }
                else {
                    tabPion[i][j] = 1;
                }

            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tabPion.length; j++) {
                if ((i + j) % 2 != 0) {
                    tabPion[i][j] = 2;
                }
            }
        }

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < tabPion.length; j++) {
                if ((i + j) % 2 != 0){
                    tabPion[i][j] = 3;
                }
            }
        }
        return tabPion;
    }
}