package jeuDeDamesContenu;

public class Pion {
    private int x;
    private int y;
    private int couleurPion;
    private String idPion;

    private boolean estDame;
    public static int compteur = 0;


    public Pion(int x, int y, int couleurPion) {
        this.x = x;
        this.y = y;
        this.couleurPion = couleurPion;
        this.estDame = false;
        this.idPion = "#" + compteur;
        compteur++;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getCouleurPion() {
        return couleurPion;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getIdPion() {
        return idPion;
    }
    public boolean estDame() {
        return estDame;
    }
    public boolean estSurRangéeOpposée() {
        if (this.couleurPion == 3 && this.getY() == 0) {
            this.estDame=true;
            return true;
        } else if (this.couleurPion == 2 && this.getY() == 9) {
            this.estDame=true;
            return true;
        } else {
            return false;
        }
    }

}

