/*
 * ControleurSauvegarde.java                                                       3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.chargeurCSV;
import iut.info1.application.Grille;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
		//TODO fermer la fenêtre de sauvegarde
	}
	
	@FXML
	private void gererClicEnregistrer() {
		String nom = nomSauvegarde.getText();
		String emplacement = emplacementSauvegarde.getText();
		//chargeurCSV.sauvegarderGrille(TODO, nom, emplacement);
	}
	
	
}
