/*
 * ControleurOrdinateur.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Contrôleur de la vue "contreOrdi"
 * @author Gabriel Robache
 */
public class ControleurOrdinateur {

	/** Bouton pour retourner au Menu */
    @FXML
    private Button retourMenu;
    
    @FXML
    private TextField nomJoueur1;
    
    @FXML
    private TextField nomJoueur2;
	
    @FXML
    public void gererClicRetourMenu() {
    	VueJeu.activerFenetreMenu();
    }
    
    @FXML
    public void gererClicChrono() {
    	VueJeu.activerFenetreChronoLancementOrdinateur();
    }
    
    @FXML
    public void gererClicCouleurJoueur1() {
    	VueJeu.activerFenetreCouleur("Joueur 1");
    }
    
    @FXML
    public void gererClicCouleurJoueur2() {
    	VueJeu.activerFenetreCouleur("Joueur 2");
    }
    
    @FXML
    public void gererClicLancer() {
    	if (nomJoueur1.getText().isEmpty() || nomJoueur2.getText().isEmpty()) {
			Alert boiteAlerte = new Alert(Alert.AlertType.ERROR);
            boiteAlerte.setTitle("Erreur");
	    	boiteAlerte.setHeaderText("Veuillez choisir un nom pour chaque joueur.");
	    	boiteAlerte.showAndWait();
		} else {
			VueJeu.activerFenetreJeu();
		}
    }
}
