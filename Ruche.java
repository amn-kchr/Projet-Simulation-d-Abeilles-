import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

// Définition de la classe Ruche
public class Ruche {
    // Liste des sources stockées dans la ruche
    public ArrayList<Source> stockSource;
    // Qualité totale du stock de sources dans la ruche
    int stockqualite = 0;
    // Coordonnées de la ruche
    int x, y;

    // Constructeur de la classe Ruche
    public Ruche(int xR, int yR) {
        this.x = xR;
        this.y = yR;
        // Initialisation de la liste des sources
        stockSource = new ArrayList<>();
    }

    // Méthode pour dessiner la ruche
    public void dessinerRuche(Graphics g, int qualiteS) {
        // Dessiner le corps de la ruche
        g.setColor(Color.orange);
        g.fillRect(2, 1, 50, 30);

        // Dessiner l'entrée de la ruche
        g.setColor(Color.black);
        g.fillRect(12, 27, 15, 20);

        // Afficher la qualité totale du stock de sources dans la ruche
        g.setColor(Color.red);
        g.drawString("Qualité: " + qualiteS, 55, 25);
    }

    // Méthode pour obtenir la liste des sources dans la ruche
    public ArrayList<Source> getSources() {
        return stockSource;
    }

    // Méthode pour ajouter une source à la ruche
    public void addSourceRuche(Source meilleurSource) {
        stockSource.add(meilleurSource);
        // Mettre à jour la qualité totale du stock de sources dans la ruche
        stockqualite = meilleurSource.getqualite();
    }
}
