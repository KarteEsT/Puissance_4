/*
 * ControleurOptionJeu.java                                         19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;
import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Contrôleur de la vue "optionJeu"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurOptionJeu {

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
     * Active la fenêtre d'aide
     */
    @FXML
    public void gererAide() {
    	
    	Alert boiteAlerte = new Alert(Alert.AlertType.INFORMATION,
        		"Cette fonctionnalité est en cours de développement.\n"
        		+ "Merci de votre compréhension.", ButtonType.OK);
        boiteAlerte.setTitle("En travaux");
        boiteAlerte.showAndWait(); // ctrl + shift + /
        
        //TODO 
    }

    /**
     * Permet de lancer la vue des règles
     */
    public void gererClicInfo() {  	
    	VueJeu.activerFenetreRegles();
    }
    
}
