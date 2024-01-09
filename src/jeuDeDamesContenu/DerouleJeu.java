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
        boolean pionBouger = false;
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

                while (pionBouger == false){
                    System.out.println("C'est au tour de " + j1 + " de jouer\n");

                    Pion pionBlancSelect = MethodeJeu.pionBlancSelectionner();

                    if (pionBlancSelect.estDame()){
                        pionBouger = MethodeJeu.deplacerDame(pionBlancSelect, MethodeJeu.coordoneeDameX(), MethodeJeu.coordoneeDameY(), plateauJeuEntier);
                    }
                    else {
                        boolean direction = MethodeJeu.directionPion();
                        pionBouger = MethodeJeu.deplacerOuMangerPionB(pionBlancSelect, direction, plateauJeuEntier);
                        pionBlancSelect.estSurRangéeOpposée();
                    }
                    MethodeJeu.afficherTab(MethodeJeu.rafraichissementTableau(plateauJeuEntier, plateauJeu));
                }
                pionBouger = false;
                tour = false;

            } else {
                System.out.println("\n");

                while (pionBouger == false){
                    System.out.println("C'est au tour de " + j1 + " de jouer\n");

                    Pion pionNoirSelect = MethodeJeu.pionNoirSelectionner();

                    if (pionNoirSelect.estDame()){
                        pionBouger = MethodeJeu.deplacerDame(pionNoirSelect, MethodeJeu.coordoneeDameX(), MethodeJeu.coordoneeDameY(), plateauJeuEntier);
                    }
                    else {
                        boolean direction = MethodeJeu.directionPion();
                        pionBouger = MethodeJeu.deplacerOuMangerPionN(pionNoirSelect, direction, plateauJeuEntier);
                        pionNoirSelect.estSurRangéeOpposée();
                    }
                    MethodeJeu.afficherTab(MethodeJeu.rafraichissementTableau(plateauJeuEntier, plateauJeu));
                }
                pionBouger = false;
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
