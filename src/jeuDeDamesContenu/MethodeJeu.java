package jeuDeDamesContenu;

import java.util.Scanner;

public class MethodeJeu {

    public static int premierJoueur (){
        int premierJ = 2,r;
        r=(int) Math.random();

        if (r<0.5)
            premierJ=1;
        return premierJ;
    }
    public static String creationJ (){
        Scanner scanner = new Scanner(System.in);
        String pseudo;
        pseudo =scanner.nextLine();
        return pseudo;
    }
}
