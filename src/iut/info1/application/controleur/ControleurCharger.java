/*
 * ControleurCharger.java                                                       3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.chargeurCSV;
import iut.info1.application.Grille;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

import iut.info1.application.VueJeu;

/**
 * Contrôleur de la classe de chargement.
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurCharger {
	
	@FXML
	private TextField nomCharger;
	
	@FXML
	private TextField emplacementCharger;
	
	@FXML
	private void gererClicAnnuler() {
		nomCharger.getScene().getWindow().hide();
	}
	
	@FXML
	private void gererClicCharger() {
	    String nom = nomCharger.getText();
	    String emplacement = emplacementCharger.getText();
	    try {

	        // Charger la grille depuis le fichier CSV
	        Grille grille = chargeurCSV.chargerGrille(nom, emplacement);

	        if (grille == null) {
	            throw new Exception("Le fichier CSV est invalide ou introuvable.");
	        }

	        // Lancer la partie
	        VueJeu.activerFenetreJeu();
	        nomCharger.getScene().getWindow().hide();

	    } catch (Exception e) {
	        // Afficher une boîte d'alerte en cas d'erreur
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Erreur de chargement");
	        alert.setHeaderText("Le chargement a échoué");
	        alert.setContentText(e.getMessage());
	        alert.showAndWait();
	    }
	}
}
