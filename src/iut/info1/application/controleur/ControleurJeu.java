
/*
 * ControleurJeu.java                                              16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import iut.info1.application.Grille;
import iut.info1.application.Joueur;

/**
 * Contrôleur de la vue "fenetreJeu"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurJeu {

    /* Labels pour afficher les noms des joueurs */
    @FXML private Label joueur1;
    @FXML private Label joueur2;

    private Grille grille;

    private String couleurJoueur1 = "red";
    private String couleurJoueur2 = "yellow";

    public void initialize() {
        Joueur j1 = new Joueur(1, "Joueur", couleurJoueur1);
        Joueur j2 = new Joueur(2, "Joueur", couleurJoueur2);

        grille = new Grille(6, 7, j1, j2);

        matriceCercle[0] = new Circle[] { A6, A5, A4, A3, A2, A1 }; 
        matriceCercle[1] = new Circle[] { B6, B5, B4, B3, B2, B1 };
        matriceCercle[2] = new Circle[] { C6, C5, C4, C3, C2, C1 };
        matriceCercle[3] = new Circle[] { D6, D5, D4, D3, D2, D1 };
        matriceCercle[4] = new Circle[] { E6, E5, E4, E3, E2, E1 };
        matriceCercle[5] = new Circle[] { F6, F5, F4, F3, F2, F1 };
        matriceCercle[6] = new Circle[] { G6, G5, G4, G3, G2, G1 };
    }

    private void mettreAJourGrille(int ligne, int colonne) {
        Circle cercle = matriceCercle[colonne][ligne];
        int joueurId = grille.getMatrice()[ligne][colonne];

        String couleur = (joueurId == 1) ? couleurJoueur1 : couleurJoueur2;
        cercle.setFill(javafx.scene.paint.Color.web(couleur));
    }


    public void mettreAJourLabels(String nomJoueur1, String nomJoueur2) {
        joueur1.setText(nomJoueur1);
        joueur2.setText(nomJoueur2);
    }

    @FXML
    private ProgressBar progressBar1;

    @FXML
    private ProgressBar progressBar2;

    /* Cercle de la colonne A */
    @FXML private Circle A1;
    @FXML private Circle A2;
    @FXML private Circle A3;
    @FXML private Circle A4;
    @FXML private Circle A5;
    @FXML private Circle A6;

    /* Cercle de la colonne B */
    @FXML private Circle B1;
    @FXML private Circle B2;
    @FXML private Circle B3;
    @FXML private Circle B4;
    @FXML private Circle B5;
    @FXML private Circle B6;

    /* Cercle de la colonne C */
    @FXML private Circle C1;
    @FXML private Circle C2;
    @FXML private Circle C3;
    @FXML private Circle C4;
    @FXML private Circle C5;
    @FXML private Circle C6;

    /* Cercle de la colonne D */
    @FXML private Circle D1;
    @FXML private Circle D2;
    @FXML private Circle D3;
    @FXML private Circle D4;
    @FXML private Circle D5;
    @FXML private Circle D6;

    /* Cercle de la colonne E */
    @FXML private Circle E1;
    @FXML private Circle E2;
    @FXML private Circle E3;
    @FXML private Circle E4;
    @FXML private Circle E5;
    @FXML private Circle E6;

    /* Cercle de la colonne F */
    @FXML private Circle F1;
    @FXML private Circle F2;
    @FXML private Circle F3;
    @FXML private Circle F4;
    @FXML private Circle F5;
    @FXML private Circle F6;

    /* Cercle de la colonne G */
    @FXML private Circle G1;
    @FXML private Circle G2;
    @FXML private Circle G3;
    @FXML private Circle G4;
    @FXML private Circle G5;
    @FXML private Circle G6;

    /* Matrice des cercles */
    @FXML private Circle[][] matriceCercle = new Circle[7][6];
    
    

    /* Boutons pour jouer dans une colonne */

    @FXML
    public void activerColonne1() {
        int ligne = grille.poserPion(0);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 0);
            verifierFinDePartie();
        }
    }

    @FXML
    public void activerColonne2() {
        int ligne = grille.poserPion(1);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 1); 
            verifierFinDePartie();
        }
    }

    @FXML
    public void activerColonne3() {
        int ligne = grille.poserPion(2);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 2);
            verifierFinDePartie();
        }
    }

    @FXML
    public void activerColonne4() {
        int ligne = grille.poserPion(3);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 3);
            verifierFinDePartie();
        }
    }

    @FXML
    public void activerColonne5() {
        int ligne = grille.poserPion(4);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 4);
            verifierFinDePartie();
        }
    }

    @FXML
    public void activerColonne6() {
        int ligne = grille.poserPion(5);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 5);
            verifierFinDePartie();
        }
    }

    @FXML
    public void activerColonne7() {
        int ligne = grille.poserPion(6);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 6);
            verifierFinDePartie();
        }
    }

    private void verifierFinDePartie() {
    	System.out.println(grille.getCompteTour());
        if (grille.verifierVictoire()) {
            int gagnant = (grille.getCompteTour() - 1) % 2 + 1;
            String nomGagnant = (gagnant == 1) ? grille.getJ1().getNom() : grille.getJ2().getNom();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Partie terminée !");
            alert.setHeaderText("Victoire !");
            alert.setContentText(nomGagnant + " a gagné !");
            alert.showAndWait();
            // Optionnel : désactiver les boutons ou relancer
        } else if (grille.isGrilleRemplie()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Égalité !");
            alert.setHeaderText(null);
            alert.setContentText("La grille est pleine. Match nul !");
            alert.showAndWait();
        }
    }

    /**
     * Méthode appelée lors du clic sur le bouton "Options"
     * pour ouvrir les options du jeu.
     */
    @FXML
    public void gererClicOption() {
        VueJeu.activerFenetreOption();
    }
}
