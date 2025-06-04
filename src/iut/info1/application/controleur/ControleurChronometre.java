/*
 * ControleurChronometre.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;

import iut.info1.application.utils.ChronosGlobales;

/**
 * Contrôleur de la vue "optionChrono"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurChronometre {

	@FXML private ProgressBar progressBar1;
	@FXML private ProgressBar progressBar2;
	
    @FXML private ComboBox<String> choixTemps;

    /**
     * Initialisation de la vue "optionChrono"
     */
    @FXML
    public void initialize() {
        
        // Remplir la ComboBox (affichés sous forme de texte)
        choixTemps.getItems().addAll("Désactiver", "5 min", "2 min", "1 min",
                                         "30 sec", "10 sec");
    }
    
    /**
     *  Permet de mettre à jour la durée du chronomètre
     */
    @FXML
    public void gererClicValider() {
        
       	String tempsSelectionne = choixTemps.getValue();
        
       	switch (tempsSelectionne) {
       	case "Désactiver":
       	    ChronosGlobales.setTempsChrono(0);
       	    break;
       	case "5 min":
       	    ChronosGlobales.setTempsChrono(300);
       	    break;
       	case "2 min":
  	    	ChronosGlobales.setTempsChrono(120);
  	    break;
        case "1 min":
            ChronosGlobales.setTempsChrono(60);
            break;
        case "30 sec":
            ChronosGlobales.setTempsChrono(30);
            break;
        case "10 sec":
            ChronosGlobales.setTempsChrono(10);
            break;
        default:
            // Ne devrait pas arriver
            break;
       	}
    }

    /**
     * Permet de revenir sur le menu du jeu
     */
    @FXML
    public void gererClicRetourMenu() {
        VueJeu.activerFenetreOptionJeu();
    }

    /**
     * Permet de revenir à la fenêtre de lancement du jeu contre l'ordinateur
     */
    @FXML
    public void gererClicRetourOrdinateur() {
    	VueJeu.activerFenetreOrdi();
    }

    /**
     * Permet de revenir à la fenêtre de lancement du jeu en multijoueur
     */
    @FXML
    public void gererClicRetourMultijoueur() {
        VueJeu.activerFenetreMulti();
    }
    
	/**
	 * Met à jour le temps du chronomètre.
	 * @param temps Le temps restant en secondes.
	 */
    public void mettreAJourChrono(int temps) {
    	
    	String tempsAffiche ="";
    	
    	switch (temps) {
       	case 0 :
       		tempsAffiche = "Désactiver";
       	    break;
       	case 300 :
       		tempsAffiche = "5 min";
       	    break;
       	case 120 :
			tempsAffiche = "2 min";
			break;
        case 60 :
        	tempsAffiche = "1 min";
            break;
        case 30 :
        	tempsAffiche = "30 sec";
            break;
        case 10 :
        	tempsAffiche = "10 sec";
            break;
        default:
            // Ne devrait pas arriver
            break;
       	}
    	
    	choixTemps.setValue(tempsAffiche);
    }
    
    /**
     * Permet de lancer la vue des règles
     */
    public void gererClicInfo() {  	
    	VueJeu.activerFenetreRegles();
    }
}