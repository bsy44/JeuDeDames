package jeuDeDamesContenu;

import java.util.Scanner;

public class MenuJeu {

    public static void menuDebutJeu(){
        Scanner scanner = new Scanner(System.in);

        int menu;
        System.out.println("1. afficher les règles");
        System.out.println("2. démarrer une partie");
        System.out.println("3. quitter");
        menu = scanner.nextInt();

        switch (menu){

            case 1 :
                System.out.println("2 joueurs s'affrontent sur un plateau de 10 cases en largeur et 10 cases en longuer (pion blanc VS pion noir)." +
                                    "\nChaque Joueur possède 20 pions et peuvent les déplacer sur leur diagonale vers l'avant." +
                                    "\n\nLe premier coup est toujours joué par les blancs. Les adversaires jouent un coup chacun à tour de rôle avec leurs pièces." +
                                    "\nUn pion se déplace vers l’avant, en diagonale, sur une case libre de la rangée suivante. Lorsqu'il atteint la dernière rangée, le pion devient une dame." +
                                    "\nUn pion effectue une prise en passant au-dessus d'un pion adverse. Il se rend alors sur la case suivante et enlève le pion adverse." +
                                    "\n\nUne partie se fini quand : " +
                                    "\n \t- un des 2 joueurs n'a plus de pion." +
                                    "\n \t- un joueur se trouve dans l’impossibilité de jouer alors qu’il a le trait." +
                                    "\n \t- abandonne la partie" +
                                    "\n\nBonne Partie ^^ \n");

            case 2 :
                DerouleJeu.gameloop();
                break;

            case 3 :
                System.out.println("Au revoir");
                break;
        }
    }
}
