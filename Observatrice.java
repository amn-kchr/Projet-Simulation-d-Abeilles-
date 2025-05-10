import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

// Définition de la classe Observatrice, qui hérite de la classe Abeille
public class Observatrice extends Abeille {
    // Liste des sources détectées par l'observatrice
    public ArrayList<Source> stockSourceObs;
    // Qualité observée par l'observatrice
    private int qualiteObs = 0;

    // Constructeur de la classe Observatrice
    public Observatrice(int xE, int yE, Color couleurE) {
        // Appel au constructeur de la classe parent (Abeille)
        super(xE, yE, couleurE);
        // Initialisation de la liste des sources détectées
        stockSourceObs = new ArrayList<>();
    }

    // Méthode pour obtenir la position de l'observatrice (implémentation de la méthode abstraite de la classe parent)
    @Override
    public void getposition() {
        System.out.println("position x Observatrice =" + this.x + " position y Observatrice =" + this.y);
    }

    // Méthode pour dessiner l'observatrice (implémentation de la méthode abstraite de la classe parent)
    @Override
    public void dessinerAbeille(Graphics g,int qualiteRec) {
        // Dessiner le corps de l'observatrice (un cercle plus grand)
        g.setColor(Color.green);
        g.fillOval(x, y, Panneau.SCREEN_ROW, Panneau.SCREEN_COL);

        // Dessiner les ailes de l'observatrice (deux demi-cercles plus petits)
        g.setColor(Color.yellow);
        g.fillArc(x + 2, y - 2, 6, 6, 45, 120);
        g.fillArc(x + 6, y - 2, 6, 6, -45, 120);

        // Dessiner la tête de l'observatrice (un petit cercle plus petit)
        g.setColor(Color.red);
        g.fillOval(x + 10, y - 2, 6, 6);

        // Dessiner les antennes de l'observatrice (deux lignes plus courtes)
        g.drawLine(x + 12, y - 2, x + 10, y - 6);
        g.drawLine(x + 14, y - 2, x + 16, y - 6);

        // Dessiner la qualité de récolte de l'observatrice
        g.setColor(Color.white);
        g.drawString(Integer.toString(qualiteRec), x + 20, y + 15);
    }


    // Méthode pour définir la qualité observée par l'observatrice
    public void setQualiteObs(int qualiteObs) {
        this.qualiteObs = qualiteObs;
    }
    
    // Méthode pour obtenir la qualité observée par l'observatrice
    public int getQualiteObs() {
        return this.qualiteObs;
    }

    // Méthode pour comparer une nouvelle source avec les sources existantes et la stocker si elle est de meilleure qualité
    public void comparerSource(ArrayList<Source> sourcesExistantes, Source nouvelleSource) {
        // Variable pour suivre si la nouvelle source est de meilleure qualité que les sources existantes
        boolean meilleureQualite = true;
    
        // Parcourir les sources existantes
        for (Source source : sourcesExistantes) {
            // Si la qualité de la nouvelle source est inférieure ou égale à une source existante, la nouvelle source n'est pas de meilleure qualité
            if (nouvelleSource.getqualite() <= source.getqualite()) {
                meilleureQualite = false;
                break;
            }
        }
    
        // Si la nouvelle source est de meilleure qualité, l'ajouter à la liste des sources détectées et mettre à jour la qualité observée
        if (meilleureQualite) {
            stockSourceObs.add(nouvelleSource);
            qualiteObs = nouvelleSource.getqualite();
        }
    }
}
