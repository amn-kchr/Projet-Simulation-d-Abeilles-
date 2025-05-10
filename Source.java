import java.awt.Color;
import java.awt.Graphics;

// Définition de la classe Source
public class Source {
    // Attributs de la classe
    int x, y, radius = 4; // Coordonnées et rayon de la source
    private int qualiteS; // Qualité de la source
    private Color couleurS; // Couleur de la source
    public boolean exploree = false; // Indicateur si la source a été explorée

    // Constructeur de la classe Source
    public Source(int qualiteS, int x, int y, Color couleur) {
        this.qualiteS = qualiteS; // Initialisation de la qualité
        this.x = x; // Initialisation de la coordonnée x
        this.y = y; // Initialisation de la coordonnée y
        this.couleurS = couleur; // Initialisation de la couleur
    }

    // Méthode pour obtenir la qualité de la source
    public int getqualite() {
        return this.qualiteS;
    }

    // Méthode pour obtenir la couleur de la source
    public Color getColor() {
        return this.couleurS;
    }

    // Méthode pour dessiner visuellement la source sous forme de fleur
    public void dessinerFleur(Graphics g) {
        // Dessin du pédoncule
        g.setColor(Color.green);
        g.fillRect(x + 3, y + 5, 2, 20);

        // Dessin des pétales de la fleur
        g.setColor(Color.red);
        g.fillOval(x, y, 5, 5);
        g.fillOval(x + 5, y, 5, 5);
        g.fillOval(x + 2, y + 2, 5, 5);
        g.fillOval(x, y + 5, 5, 5);
        g.fillOval(x + 5, y + 5, 5, 5);
        g.setColor(Color.yellow);
        g.fillOval(x + 5, y + 5, 5, 5);

        // Dessin du texte indiquant la qualité de la source
        g.setColor(Color.white);
        g.drawString(Integer.toString(qualiteS), x + 10, y + 30);
    }

    // Méthode pour obtenir la position de la source
    public void getpositionSource() {
        System.out.println("position x=" + this.x + " position y=" + this.y);
    }

    // Méthode pour vérifier si la source a été explorée
    public boolean estExploree() {
        return exploree;
    }

    // Méthode pour marquer la source comme explorée
    public void explorer() {
        exploree = true;
    }
}
