package jeuDeDamesContenu;

public class DerouleJeu {

    public static void gameLoop(){
        String j1, j2;

        System.out.println("Joueur 1" + " : Entrez votre pseudo");
        j1 = MethodeJeu.creationJ();
        System.out.println("Joueur 2" + " : Entrez votre pseudo");
        j2 = MethodeJeu.creationJ();

    }
}
