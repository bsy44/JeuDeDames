package jeuDeDamesContenu;

public class MethodeJeu {

    public static int premierJoueur (){
        int premierJ = 2,r;
        r=(int) Math.random();

        if (r<0.5)
            premierJ=1;
        return premierJ;
    }
}
