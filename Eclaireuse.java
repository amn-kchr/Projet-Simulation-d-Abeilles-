import java.awt.Color;
import java.awt.Graphics;

// Définition de la classe Eclaireuse, qui hérite de la classe Abbeille
public class Eclaireuse extends Abeille {

    // Indicateur pour suivre si l'éclaireuse a déjà détecté une source
    public boolean aDetecteSource;

    // Constructeur de la classe Eclaireuse
    public Eclaireuse(int xE, int yE, Color couleurE) {
        // Appel au constructeur de la classe parent (Abbeille)
        super(xE, yE, couleurE);
        // Initialisation de l'indicateur de détection de source
        aDetecteSource = false;
    }

    // Méthode pour obtenir la position de l'éclaireuse (implémentation de la méthode abstraite de la classe parent)
    @Override
    public void getposition() {
        System.out.println("position x Eclaireuse =" + this.x + " position y Eclaireuse =" + this.y);
    }

    // Méthode pour marquer la détection d'une source par l'éclaireuse
    public void marquerDetectionSource() {
        this.aDetecteSource = true;
    }

    // Méthode pour dessiner l'éclaireuse (implémentation de la méthode abstraite de la classe parent)
    @Override
    public void dessinerAbeille(Graphics g, int qualiteRec) {
        // Dessiner le corps de l'éclaireuse (un cercle plus petit)
        g.setColor(couleurAb);
        g.fillOval(x, y, Panneau.tileSize, Panneau.tileSize);
    
        // Dessiner les ailes de l'éclaireuse (deux demi-cercles plus petits)
        g.setColor(Color.white);
        g.fillArc(x + 2, y - 2, 6, 6, 45, 180);
        g.fillArc(x + 6, y - 2, 6, 6, -45, 180);
    
        // Dessiner la tête de l'éclaireuse (un petit cercle plus petit)
        g.setColor(Color.red);
        g.fillOval(x + 8, y - 2, 4, 4);
    
        // Dessiner les antennes de l'éclaireuse (deux lignes plus courtes)
        g.drawLine(x + 10, y - 2, x + 8, y - 4);
        g.drawLine(x + 12, y - 2, x + 14, y - 4);
    }

    // Méthode pour détecter une collision entre l'éclaireuse et une source de nourriture
    public boolean detecterCollision(Source source) {
        // Vérifier si l'éclaireuse a déjà détecté une source, si oui, ne pas détecter de nouvelle collision
        if (aDetecteSource) {
            return false;
        }
        // Vérifier si les coordonnées de l'éclaireuse correspondent à celles de la source
        return (x == source.x && y == source.y);
    }
}
