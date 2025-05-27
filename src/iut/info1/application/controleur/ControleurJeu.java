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

/**
 * Contrôleur de la vue "fentreJeu"
 * @author Gabriel Robache
 */
public class ControleurJeu {
	//TODO Mettre en tableau les cercles et les boutons pour éviter la répétition de code
	
	// Labels pour afficher les noms des joueurs
    @FXML private Label joueur1;
    @FXML private Label joueur2;
	
    // Cercle de la colonne A
	@FXML private Circle A1;
	@FXML private Circle A2;
	@FXML private Circle A3;
	@FXML private Circle A4;
	@FXML private Circle A5;
	@FXML private Circle A6;
	
	// Cercle de la colonne B
	@FXML private Circle B1;
	@FXML private Circle B2;
	@FXML private Circle B3;
	@FXML private Circle B4;
	@FXML private Circle B5;
	@FXML private Circle B6;
	
	// Cercle de la colonne C
	@FXML private Circle C1;
	@FXML private Circle C2;
	@FXML private Circle C3;
	@FXML private Circle C4;
	@FXML private Circle C5;
	@FXML private Circle C6;
	
	// Cercle de la colonne D
	@FXML private Circle D1;
	@FXML private Circle D2;
	@FXML private Circle D3;
	@FXML private Circle D4;
	@FXML private Circle D5;
	@FXML private Circle D6;
	
	// Cercle de la colonne E
	@FXML private Circle E1;
	@FXML private Circle E2;
	@FXML private Circle E3;
	@FXML private Circle E4;
	@FXML private Circle E5;
	@FXML private Circle E6;
	
	// Cercle de la colonne F
	@FXML private Circle F1;
	@FXML private Circle F2;
	@FXML private Circle F3;
	@FXML private Circle F4;
	@FXML private Circle F5;
	@FXML private Circle F6;
	
	// Cercle de la colonne G
	@FXML private Circle G1;
	@FXML private Circle G2;
	@FXML private Circle G3;
	@FXML private Circle G4;
	@FXML private Circle G5;
	@FXML private Circle G6;
	
	// Boutons pour jouer dans une colonne
	@FXML private Button colonne0;
	@FXML private Button colonne1;
	@FXML private Button colonne2;
	@FXML private Button colonne3;
	@FXML private Button colonne4;
	@FXML private Button colonne5;
	@FXML private Button colonne6;
	
    @FXML
    public void gererClicOption() {
    	VueJeu.activerFenetreOption();
    }
	
}