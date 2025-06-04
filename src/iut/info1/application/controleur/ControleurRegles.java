/*
 * ControleurRegles.java                                                       4 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;




/**
 * Contrôleur pour la vue des règles du jeu.
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurRegles {
	
	@FXML
	private Button idFermer;
	
	@FXML
	public void gererClicFermer() {
		idFermer.getScene().getWindow().hide();
	}
	
}
