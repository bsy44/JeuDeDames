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
        boolean manger = true;
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

        while ((!MethodeJeu.getListePionBlanc().isEmpty()) || (!MethodeJeu.getListePionNoir().isEmpty())) {
            if (tour) {
                System.out.println("C'est au tour de " + j1 + " de jouer\n");

                while (!MethodeJeu.getListePionBlanc().isEmpty() && !pionBouger) {
                    Pion pionBlancSelect = MethodeJeu.pionBlancSelectionner();
                    boolean pionCapture = false;

                    while (manger) {
                        int cptPionN = MethodeJeu.getListePionNoir().size();

                        if (pionBlancSelect.estDame()) {
                            plateauJeuEntier[pionBlancSelect.getX()][pionBlancSelect.getY()] = 4;
                            pionBouger = MethodeJeu.deplacerDame(pionBlancSelect, MethodeJeu.coordoneeDameX(), MethodeJeu.coordoneeDameY(), plateauJeuEntier);
                        }

                        else {
                            boolean direction = MethodeJeu.directionPion();
                            pionBouger = MethodeJeu.deplacerOuMangerPionB(pionBlancSelect, direction, plateauJeuEntier);
                            MethodeJeu.estSurRangéeOpposée(pionBlancSelect);

                            if (cptPionN != MethodeJeu.getListePionNoir().size()) {
                                pionCapture = true;
                            }
                        }
                        MethodeJeu.afficherTab(MethodeJeu.rafraichissementTableau(plateauJeuEntier, plateauJeu));
                        System.out.println("\n");
                        System.out.println(MethodeJeu.getListePionBlanc().size());
                        System.out.println(MethodeJeu.getListePionNoir().size());
                        if (!pionBouger || !pionCapture) {
                            manger = false;
                        } else {
                            System.out.println("Vous pouvez rejouer !");
                            pionCapture = false;
                        }
                    }
                    manger = true;
                }
                pionBouger = false;
                tour = false; // Changer de joueur après la fin du tour du joueur 1
            } else {
                System.out.println("\nC'est au tour de " + j2 + " de jouer\n");

                while (!MethodeJeu.getListePionNoir().isEmpty() && !pionBouger) {
                    Pion pionNoirSelect = MethodeJeu.pionNoirSelectionner();
                    boolean pionCapture = false;

                    while (manger) {
                        int cptPionB = MethodeJeu.getListePionBlanc().size();

                        if (pionNoirSelect.estDame()) {
                            plateauJeuEntier[pionNoirSelect.getX()][pionNoirSelect.getY()] = 4;
                            pionBouger = MethodeJeu.deplacerDame(pionNoirSelect, MethodeJeu.coordoneeDameX(), MethodeJeu.coordoneeDameY(), plateauJeuEntier);
                        } else {
                            boolean direction = MethodeJeu.directionPion();
                            pionBouger = MethodeJeu.deplacerOuMangerPionN(pionNoirSelect, direction, plateauJeuEntier);
                            MethodeJeu.estSurRangéeOpposée(pionNoirSelect);

                            if (cptPionB != MethodeJeu.getListePionBlanc().size()) {
                                pionCapture = true;
                            }
                        }

                        MethodeJeu.afficherTab(MethodeJeu.rafraichissementTableau(plateauJeuEntier, plateauJeu));
                        System.out.println("\n");
                        System.out.println(MethodeJeu.getListePionBlanc().size());
                        System.out.println(MethodeJeu.getListePionNoir().size());

                        if (!pionBouger || !pionCapture) {
                            manger = false;
                        } else {
                            System.out.println("Vous pouvez rejouer !");
                            pionCapture = false;
                        }
                    }
                    manger = true;
                }
                pionBouger = false;
                tour = true; // Changer de joueur après la fin du tour du joueur 2
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
