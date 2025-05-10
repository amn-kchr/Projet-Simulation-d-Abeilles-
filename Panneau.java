import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Définition de la classe Panneau qui étend JPanel et implémente Runnable
public class Panneau extends JPanel implements Runnable {
    // Constantes pour la taille de la grille et de l'écran
    static final int tileSize = 15;
    static final int SCREEN_ROW = 23;
    static final int SCREEN_COL = 38;
    static final int SCREEN_WIDTH = tileSize * SCREEN_COL;
    static final int SCREEN_HEIGHT = tileSize * SCREEN_ROW;

    // Instances de la ruche, de l'employé, de l'observatrice et des tableaux d'éclaireuses et de sources
    Ruche r1 = new Ruche(2, 5);
    Employee e1 = new Employee((int) (Math.random() * SCREEN_WIDTH), (int) (Math.random() * SCREEN_HEIGHT), Color.darkGray);
    Observatrice Obs = new Observatrice((int) (Math.random() * SCREEN_WIDTH), (int) (Math.random() * SCREEN_HEIGHT), Color.darkGray);
    Eclaireuse[] tabEclaireuse;
    Source[] tabFleur;
    int indiceSourceActuelle = 1;

    // Constructeur de la classe Panneau
    Panneau(int nombreSource, int nombreAbbeille) {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.tabEclaireuse = new Eclaireuse[nombreAbbeille];
        this.tabFleur = new Source[nombreSource];

        // Initialisation des tableaux d'éclaireuses et de sources
        for (int i = 0; i < nombreAbbeille; i++) {
            this.tabEclaireuse[i] = new Eclaireuse((int) (Math.random() * SCREEN_WIDTH), (int) (Math.random() * SCREEN_HEIGHT), Color.orange);
            this.tabFleur[i] = new Source((int) (Math.random() * SCREEN_HEIGHT), (int) (Math.random() * SCREEN_WIDTH), (int) (Math.random() * SCREEN_HEIGHT), Color.red);
        }
    }

    // Méthode pour démarrer le jeu
    public void debutJeu() {
        Thread jeuThread = new Thread(this);
        jeuThread.start();
    }

    // Méthode appelée en cas de fin de jeu
    private void gameOver() {
        JOptionPane.showMessageDialog(null, "Game Over ! Meilleur Qualité trouvé " + Obs.getQualiteObs());
        System.exit(0);
    }

    // Méthode pour dessiner les composants du jeu
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner les éclaireuses et les sources
        for (int i = 0; i < this.tabEclaireuse.length; i++) {
            this.tabEclaireuse[i].dessinerAbeille(g, 0);
            this.tabFleur[i].dessinerFleur(g);
        }
        // Dessiner la ruche, l'employé et l'observatrice
        r1.dessinerRuche(g, Obs.getQualiteObs());
        e1.dessinerAbeille(g, e1.getQualiteEm());
        Obs.dessinerAbeille(g, Obs.getQualiteObs());
    }

    // Méthode exécutée par le thread
    public void run() {
        while (true) {
            boolean toutesExplorees = true;

            // Parcours des éclaireuses et des sources
            for (int i = 0; i < tabFleur.length; i++) {
                if (!this.tabEclaireuse[i].aDetecteSource) {
                    this.tabEclaireuse[i].exploreSource(this.tabFleur[i].x, this.tabFleur[i].y);
                    this.tabFleur[i].getpositionSource();
                    this.tabEclaireuse[i].getposition();

                    // Si une éclaireuse détecte une collision avec une source
                    if (this.tabEclaireuse[i].detecterCollision(this.tabFleur[i])) {
                        this.tabEclaireuse[i].deplacerAbeille(this.r1.x, this.r1.y);
                        this.tabFleur[i].explorer();
                        this.tabEclaireuse[i].marquerDetectionSource();
                    } else {
                        toutesExplorees = false;
                    }
                }
            }

            // Si toutes les sources sont explorées
            if (toutesExplorees) {
                if (indiceSourceActuelle <= tabFleur.length) {
                    Source sourceActuelle = tabFleur[indiceSourceActuelle];
                    if (sourceActuelle != null) {
                        e1.exploreSource(sourceActuelle.x, sourceActuelle.y);
                        int qualiteRec = sourceActuelle.getqualite();
                        this.e1.setQualiteEm(qualiteRec);
                        this.e1.getposition();
                        this.Obs.comparerSource(Obs.stockSourceObs, sourceActuelle);

                        // Si l'employé détecte une collision avec la source actuelle
                        if (e1.detecterCollision(tabFleur[indiceSourceActuelle])) {
                            e1.danser();
                            // Si c'est la dernière source, afficher "FIN" et fin du jeu
                            if(indiceSourceActuelle == tabFleur.length - 1) {
                                System.out.println("FIN");
                                gameOver();
                            } else {
                                // Sinon, passer à la source suivante
                                indiceSourceActuelle++;
                            }
                        }
                    } 
                }
            }

            // Redessiner les composants
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }    
}
