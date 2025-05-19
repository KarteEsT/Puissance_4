/*
 * ControleurOptionGraphique.java                                                       19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;
import iut.info1.application.VueJeu;
import javafx.fxml.FXML;

/**
 * Contrôleur de la vue "optionGraphique"
 * @author Gabriel Robache
 */
public class ControleurOptionGraphique {

	@FXML
	public void gererClicRetourMenu() {
		VueJeu.activerFenetreOption();
	}
	
}
