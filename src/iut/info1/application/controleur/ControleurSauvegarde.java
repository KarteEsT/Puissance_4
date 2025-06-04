/*
 * ControleurSauvegarde.java                                                       3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.ChargeurCSV;
import iut.info1.application.Grille;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

/**
 * Contrôleur de la classe de sauvegarde.
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurSauvegarde {

	@FXML
	private TextField nomSauvegarde;

	@FXML
	private TextField emplacementSauvegarde;

	@FXML
	private void gererClicAnnuler() {
		nomSauvegarde.getScene().getWindow().hide();
	}
	
	@FXML
	private void gererClicEnregistrer() {
		String nom = nomSauvegarde.getText();
	    String emplacement = emplacementSauvegarde.getText();

	    // Vérifier que les champs ne sont pas vides
	    if (nom.isEmpty() || emplacement.isEmpty()) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Erreur de sauvegarde");
	        alert.setHeaderText("Champs manquants");
	        alert.setContentText("Veuillez remplir tous les champs avant de sauvegarder.");
	        alert.showAndWait();
	        return;
	    }

	    try {
	        Grille grille = Grille.getInstance();
	        ChargeurCSV.sauvegarderGrille(grille, nom, emplacement);
	        nomSauvegarde.getScene().getWindow().hide();
	    } catch (Exception e) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Erreur de sauvegarde");
	        alert.setHeaderText("Échec de la sauvegarde");
	        alert.setContentText("Impossible de sauvegarder le fichier. Veuillez vérifier l'emplacement.");
	        alert.showAndWait();
	        e.printStackTrace();
	    }
	}
	
	
}
