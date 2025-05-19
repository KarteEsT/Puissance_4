/*
 * ControleurOptionJeu.java                                         19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;
import iut.info1.application.VueJeu;
import javafx.fxml.FXML;

/**
 * Contrôleur de la vue "optionJeu"
 * @author Gabriel Robache
 */
public class ControleurOptionJeu {

	@FXML
    public void gererClicRetourOption() {
    	VueJeu.activerFenetreOption();
    }
	
	@FXML
    public void gererClicChronometre() {
    	VueJeu.activerFenetreChronoOption();
    }
	
	@FXML
    public void gererClicSon() {
    	//VueJeu.activerFenetreSon();
    }
	
	@FXML
    public void gererAide() {
    	//TODO Permet d'activer et de désactiver l'aide avec une fenêtre pop-up
    }
	
}
