/*
 * ControleurChronometre.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * Contrôleur de la vue "optionChrono"
 * @author Gabriel Robache
 */
public class ControleurChronometre {
	
	@FXML private ComboBox<String> choixTemps;
	
	@FXML
    public void initialize() {
        // Remplir la ComboBox (affichés sous forme de texte)
		choixTemps.getItems().addAll("Désactiver", "5 min", "2 min", "1 min", "30 sec", "10 sec");
		choixTemps.setValue("Désactiver"); // Valeur par défaut
    }
	
    @FXML
    public void gererClicRetourMultijoueur() {
    	VueJeu.activerFenetreMulti();
    }
    
}
