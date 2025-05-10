import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

// Définition de la classe abstraite Abeille
public abstract class Abeille {
    // Déclaration des variables membres
    int x, y, radius = 4; // Coordonnées et rayon de l'abeille
    protected Color couleurAb; // Couleur de l'abeille
    Source source = null; // Référence à la source de nourriture associée à l'abeille (non utilisée dans ce code)

    // Constructeur de la classe Abeille
    public Abeille(int x, int y, Color couleur) {
        this.x = x;
        this.y = y;
        this.couleurAb = couleur;
    }

    // Méthode abstraite pour obtenir la position de l'abeille
    public abstract void getposition();

    // Méthode abstraite pour dessiner l'abeille
    public abstract void dessinerAbeille(Graphics g,int qualiteRec);

    // Méthode pour faire explorer l'abeille à une source de nourriture
    public void exploreSource(int sourceX, int sourceY) {
        // Calculer la distance en x et en y entre l'abeille et la source
        int deltaX = sourceX - x;
        int deltaY = sourceY - y;

        // Calculer le déplacement en x et en y pour que l'abeille se rapproche de la source
        int newX = x + Integer.compare(deltaX, 0); // Déplacement d'une unité dans la direction de la source en x
        int newY = y + Integer.compare(deltaY, 0); // Déplacement d'une unité dans la direction de la source en y

        // Mettre à jour la position de l'abeille en évitant de sortir de l'écran
        x = Math.max(0, Math.min(newX, Panneau.SCREEN_WIDTH - 1));
        y = Math.max(0, Math.min(newY, Panneau.SCREEN_HEIGHT - 1));
    }

    // Méthode pour déplacer l'abeille vers une source de nourriture
    public void deplacerAbeille(int sourceX, int sourceY) {
        int deltaX = sourceX - x;
        int deltaY = sourceY - y;

        x += deltaX;
        y += deltaY;
    }

    // Méthode pour obtenir la couleur de l'abeille
    public Color getColor() {
        return this.couleurAb;
    }
}
