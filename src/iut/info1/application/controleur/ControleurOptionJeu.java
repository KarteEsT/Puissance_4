/*
 * ControleurOptionJeu.java                                         19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;
import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Button;

import iut.info1.application.utils.AideTampon;

/**
 * Contrôleur de la vue "optionJeu"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurOptionJeu {
	
	@FXML private Button aideActiver;
	@FXML private Button aideDesactiver;

    /**
     * Active la fenêtre des options graphiques
     */
    @FXML
    public void gererClicRetourOption() {
        VueJeu.activerFenetreOption();
    }

    /**
     * Active la fenêtre des options de jeu
     */
    @FXML
    public void gererClicChronometre() {
        VueJeu.activerFenetreChronoOption();
    }

    /**
     * Active la fenêtre des options de son
     */
    @FXML
    public void gererClicSon() {
    	
    	Alert boiteAlerte = new Alert(Alert.AlertType.INFORMATION,
        		"Cette fonctionnalité est en cours de développement.\n"
        		+ "Merci de votre compréhension.", ButtonType.OK);
        boiteAlerte.setTitle("En travaux");
        boiteAlerte.showAndWait(); // ctrl + shift + /
        
        //VueJeu.activerFenetreSon();
    }

    /**
     * Active l'aide au joueur
     */
    @FXML
    public void gererAideActiver() {
    	aideActiver.setVisible(false);
    	aideActiver.setDisable(true);
    	aideDesactiver.setVisible(true);
    	aideDesactiver.setDisable(false);
    	AideTampon.setAideBoolean(true);
    }
    
    /**
     * Désactive l'aide au joueur
     */
    @FXML
    public void gererAideDesactiver() {
    	aideActiver.setVisible(true);
    	aideActiver.setDisable(false);
    	aideDesactiver.setVisible(false);
    	aideDesactiver.setDisable(true);
    	AideTampon.setAideBoolean(false);
    }

    /**
     * Permet de lancer la vue des règles
     */
    public void gererClicInfo() {  	
    	VueJeu.activerFenetreRegles();
    }
    
}
