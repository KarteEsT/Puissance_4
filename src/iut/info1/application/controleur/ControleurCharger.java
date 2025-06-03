/*
 * ControleurCharger.java                                                       3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.chargeurCSV;
import iut.info1.application.Grille;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
		// TODO fermer la fenêtre de chargement
	}
	
	@FXML
	private void gererClicCharger() {
		String nom = nomCharger.getText();
		String emplacement = emplacementCharger.getText();
		Grille grille = chargeurCSV.chargerGrille(nom, emplacement);
		VueJeu.activerFenetreJeu();
	}
}
