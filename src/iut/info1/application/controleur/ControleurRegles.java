/*
 * ControleurRegles.java                                         4 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la vue "regles".
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurRegles {
	
	/** Identifiant du bouton fermer */
	@FXML
	private Button idFermer;
	
	/** Permet de fermer la vue */
	@FXML
	public void gererClicFermer() {
		idFermer.getScene().getWindow().hide();
	}
	
}
