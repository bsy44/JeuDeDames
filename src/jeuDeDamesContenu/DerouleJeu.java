package jeuDeDamesContenu;

public class DerouleJeu {

    public static void debutPartie(){
        String j1, j2;

        System.out.println("Joueur 1 : Entrez votre pseudo");
        j1 = MethodeJeu.creationJ();
        System.out.println("Joueur 2 : Entrez votre pseudo");
        j2 = MethodeJeu.creationJ();

        if (MethodeJeu.premierJoueur() == 1){
            System.out.println(j1 + " Vous jouez les pions blancs");
            System.out.println(j2 + " Vous jouez les pions noirs");
        }
        else {
            System.out.println(j2 + " Vous jouez les pions blancs");
            System.out.println(j1 + " Vous jouez les pions noirs");
        }

        System.out.println();

        System.out.println("La partie peut commencer\n" +
                "A vous de jouer " + j1);

        gameLoop();
    }

    public static void gameLoop(){

    }
}
