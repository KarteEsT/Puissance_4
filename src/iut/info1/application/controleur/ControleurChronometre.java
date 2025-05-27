/*
 * ControleurChronometre.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

/**
 * Contrôleur de la vue "optionChrono"
 * @author Gabriel Robache
 */
public class ControleurChronometre {
	
	@FXML private Button activerButton;
	
	@FXML private Button desactiverButton;
	
	@FXML private ComboBox<String> choixTemps;
	
	@FXML
    public void initialize() {
        // Remplir la ComboBox (affichés sous forme de texte)
		choixTemps.getItems().addAll("Désactiver", "5 min", "2 min", "1 min", "30 sec", "10 sec");
		choixTemps.setValue("Désactiver"); // Valeur par défaut
    }
	
    @FXML
    public void gererClicRetourMenu() {
    	VueJeu.activerFenetreOptionJeu();
    }
    
    @FXML
    public void gererClicRetourOrdinateur() {
    	VueJeu.activerFenetreOrdi();
    }
    
    @FXML
    public void gererClicRetourMultijoueur() {
    	VueJeu.activerFenetreMulti();
    }
    
    @FXML
    public void gererClicActiverChrono() {
    	activerButton.setDisable(true);
    	activerButton.setVisible(false);
    	desactiverButton.setDisable(false);
    	desactiverButton.setVisible(true);
    }
    
    @FXML
    public void gererClicDesactiverChrono() {
    	activerButton.setDisable(false);
    	activerButton.setVisible(true);
    	desactiverButton.setDisable(true);
    	desactiverButton.setVisible(false);
    }
}
