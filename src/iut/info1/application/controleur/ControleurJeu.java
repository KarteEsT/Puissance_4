/*
 * ControleurJeu.java                                              16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

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
    {
		matriceCercle[0] = new Circle[] { A1, A2, A3, A4, A5, A6 };
		matriceCercle[1] = new Circle[] { B1, B2, B3, B4, B5, B6 };
		matriceCercle[2] = new Circle[] { C1, C2, C3, C4, C5, C6 };
		matriceCercle[3] = new Circle[] { D1, D2, D3, D4, D5, D6 };
		matriceCercle[4] = new Circle[] { E1, E2, E3, E4, E5, E6 };
		matriceCercle[5] = new Circle[] { F1, F2, F3, F4, F5, F6 };
		matriceCercle[6] = new Circle[] { G1, G2, G3, G4, G5, G6 };
	}

    /* Boutons pour jouer dans une colonne */
    
    @FXML
    public void gererColonne1() {
    	
    }
    
    @FXML
	public void gererColonne2() {

	}
    
    @FXML
    public void gererColonne3() {
    	
    }
    
    @FXML
	public void gererColonne4() {

	}
    
    @FXML
	public void gererColonne5() {

	}
    
    @FXML
	public void gererColonne6() {

	}
    
    @FXML
	public void gererColonne7() {

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