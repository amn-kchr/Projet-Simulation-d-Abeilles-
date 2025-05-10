import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;

// Définition de la classe Employee, qui hérite de la classe Abeille
public class Employee extends Abeille {
    // Qualité de l'employee
    private int qualiteEm = 0;

    // Constructeur de la classe Employee
    public Employee(int xE, int yE, Color couleurE) {
        // Appel au constructeur de la classe parent (Abeille)
        super(xE, yE, couleurE);
    }

    // Méthode pour obtenir la position de l'employee (implémentation de la méthode abstraite de la classe parent)
    @Override
    public void getposition() {
        System.out.println("position x employee =" + this.x + " position y employee =" + this.y);
    }

    // Méthode pour dessiner l'employee (implémentation de la méthode abstraite de la classe parent)
    @Override
    public void dessinerAbeille(Graphics g, int qualiteRec) {
        // Dessiner le corps de l'abeille (un cercle plus petit)
        g.setColor(couleurAb);
        g.fillOval(x, y, Panneau.tileSize, Panneau.tileSize);

        // Dessiner les ailes de l'abeille (deux demi-cercles plus petits)
        g.setColor(Color.white);
        g.fillArc(x + 2, y - 2, 6, 6, 45, 180);
        g.fillArc(x + 6, y - 2, 6, 6, -45, 180);

        // Dessiner la tête de l'abeille (un petit cercle plus petit)
        g.setColor(Color.blue);
        g.fillOval(x + 8, y - 2, 4, 4);

        // Dessiner les antennes de l'abeille (deux lignes plus courtes)
        g.drawLine(x + 10, y - 2, x + 8, y - 4);
        g.drawLine(x + 12, y - 2, x + 14, y - 4);

        // Dessiner la qualité de récolte de l'employee
        g.setColor(Color.gray);
        g.drawString(Integer.toString(qualiteRec), x + 15, y + 10); // Réduire la position du texte
    }

    // Méthode pour détecter une collision entre l'employee et une source de nourriture
    public boolean detecterCollision(Source source) {
        // Vérifier si les coordonnées de l'employee correspondent à celles de la source
        return (x == source.x && y == source.y);
    }

    // Méthode pour faire danser l'employee en changeant sa couleur de façon aléatoire
    public void danser() {
        Random random = new Random();
        // Changer la couleur de l'abeille de façon aléatoire
        couleurAb = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    // Méthode pour définir la qualité de l'employee
    public void setQualiteEm(int qualiteEm) {
        this.qualiteEm = qualiteEm;
    }

    // Méthode pour obtenir la qualité de l'employee
    public int getQualiteEm() {
        return this.qualiteEm;
    }
}
