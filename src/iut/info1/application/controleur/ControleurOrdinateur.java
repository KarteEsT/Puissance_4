/*
 * ControleurOrdinateur.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.lancement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Contrôleur de la vue "contreOrdi"
 * @author Gabriel Robache
 */
public class ControleurOrdinateur {

	/** Bouton pour retourner au Menu */
    @FXML
    private Button retourMenu;
	
    @FXML
    public void gererClicRetourMenu() {
    	lancement.activerFenetreMenu();
    }
    
    @FXML
    public void gererClicChrono() {
    	lancement.activerFenetreChrono();
    }
    
    @FXML
    public void gererClicCouleurJoueur1() {
    	lancement.activerFenetreCouleur("Joueur 1");
    }
    
    @FXML
    public void gererClicCouleurJoueur2() {
    	lancement.activerFenetreCouleur("Joueur 2");
    }
}
