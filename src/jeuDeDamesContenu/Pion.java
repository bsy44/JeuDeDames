package jeuDeDamesContenu;

public class Pion {
    private int x;
    private int y;
    private String couleurPion;
    private String idPion;
    public static int compteur = 0;

    public Pion(int x, int y, String couleurPion){
        this.x = x;
        this.y = y;
        this.couleurPion = couleurPion;
        this.idPion = "#"+compteur;
        compteur++;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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

    @Override
    public String toString() {
        return couleurPion+idPion;
    }
}
