package jeuDeDamesContenu;

import java.util.Scanner;

public class DerouleJeu {

    public static void main(String[] args) {
        gameloop();
    }

    public static void gameloop() {
        Scanner scanner = new Scanner(System.in);

        String j1, j2;
        boolean tour = true;
        int saisieUtil;
        boolean reponse;
        int[][] plateauJeuEntier = Plateau.plateauPion();
        String[][] plateauJeu = Plateau.creerDamier(plateauJeuEntier);

        System.out.println("Joueur 1 : Entrez votre pseudo");
        j1 = scanner.nextLine();
        System.out.println("Joueur 2 : Entrez votre pseudo");
        j2 = scanner.nextLine();

        System.out.println(j1 + " vous jouez les pions blancs");
        System.out.println(j2 + " vous jouez les pions noirs");

        System.out.println();

        System.out.println("La partie peut commencer.");

        MethodeJeu.afficherTab(plateauJeu);

        System.out.println();

        while ((!MethodeJeu.getListePionBlanc().isEmpty()) || (!MethodeJeu.getListePionNoir().isEmpty())){
            if (tour) {
                System.out.println("C'est au tour de " + j1 + " de jouer\n");
                Pion pionBlancSelect = MethodeJeu.pionBlancSelectionner();

                if (pionBlancSelect.estDame()){
                    MethodeJeu.deplacerDame(pionBlancSelect, MethodeJeu.coordoneeDameX(), MethodeJeu.coordoneeDameY(), plateauJeuEntier);
                }
                else {
                    boolean direction = MethodeJeu.directionPion();

                    System.out.println("Voulez-vous mangez un pion ? Tapez 0 pour oui. Un autre chiffre pour non");
                    saisieUtil = scanner.nextInt();

                    if (saisieUtil == 0){
                        MethodeJeu.mangerPionN(pionBlancSelect, direction, plateauJeuEntier);
                    }
                    else {
                        MethodeJeu.deplacerPionB(pionBlancSelect,direction,plateauJeuEntier);
                    }
                }
                MethodeJeu.afficherTab(MethodeJeu.rafraichissementTableau(plateauJeuEntier, plateauJeu));
                tour = false;

            } else {
                System.out.println("C'est au tour de " + j2 + " de jouer");

                Pion pionNoirSelect = MethodeJeu.pionNoirSelectionner();

                if (pionNoirSelect.estDame()){
                    MethodeJeu.deplacerDame(pionNoirSelect, MethodeJeu.coordoneeDameX(), MethodeJeu.coordoneeDameY(), plateauJeuEntier);
                }
                else {
                    boolean direction = MethodeJeu.directionPion();

                    System.out.println("Voulez-vous mangez un pion ? Tapez 0 pour oui. Un autre chiffre pour non");
                    saisieUtil = scanner.nextInt();

                    if (saisieUtil == 0){
                        MethodeJeu.mangerPionN(pionNoirSelect, direction, plateauJeuEntier);
                    }
                    else {
                        MethodeJeu.deplacerPionB(pionNoirSelect,direction,plateauJeuEntier);
                    }
                }
                MethodeJeu.deplacerPionB(MethodeJeu.pionBlancSelectionner(),MethodeJeu.directionPion(), plateauJeuEntier);
                MethodeJeu.afficherTab(MethodeJeu.rafraichissementTableau(plateauJeuEntier, plateauJeu));
                tour = true;
            }
        }

        if (MethodeJeu.getListePionNoir().isEmpty()){
            System.out.println("Félicitation " + j1 + " vous avez gagner");
        }
        else{
            if (MethodeJeu.getListePionBlanc().isEmpty()) {
                System.out.println("Félicitation " + j2 + " vous avez gagner");
            }
        }
    }
}
