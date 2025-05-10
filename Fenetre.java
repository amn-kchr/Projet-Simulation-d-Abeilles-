import java.awt.*;
import javax.swing.JFrame;

// Définition de la classe Fenetre qui étend JFrame
public class Fenetre extends JFrame {

    // Constructeur de la classe Fenetre
    public Fenetre() {
        super("Jeu abeilles"); // Définit le titre de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indique l'action à effectuer lorsque la fenêtre est fermée
        this.setBackground(Color.red); // Définit la couleur de fond de la fenêtre (à remplacer par la couleur désirée)
        this.setSize(new Dimension(600, 400)); // Définit la taille de la fenêtre
        this.setResizable(false); // Empêche le redimensionnement de la fenêtre
        this.setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        this.setBackground(Color.green); // Définit la couleur de fond de la fenêtre (à remplacer par la couleur désirée)
        
        // Crée un nouveau panneau de jeu avec 20 sources et 20 abeilles, puis démarre le jeu
        Panneau panneauJeu = new Panneau(10, 10);
        panneauJeu.debutJeu();
        this.add(panneauJeu); // Ajoute le panneau de jeu à la fenêtre
        this.setVisible(true); // Rend la fenêtre visible
    }

    // Méthode principale
    public static void main(String[] args) {
        // Crée une nouvelle instance de la classe Fenetre
        Fenetre fenetreJeu = new Fenetre();
    }
}
