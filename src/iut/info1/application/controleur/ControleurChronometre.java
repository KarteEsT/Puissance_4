/*
 * ControleurChronometre.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

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
	
	String couleur1 = "#FF0000"; // Rouge par défaut
	String couleur2 = "#FFFF00"; // Jaune par défaut
	
    @FXML private ComboBox<String> choixTemps;

    @FXML
    public void initialize() {
        // Remplir la ComboBox (affichés sous forme de texte)
        choixTemps.getItems().addAll("Désactiver", "5 min", "2 min", "1 min", "30 sec", "10 sec");
        choixTemps.setValue("Désactiver"); // Valeur par défaut
        
    }
    
	/**
	 * Permet de mettre à jour la durée du chronomètre
	 */
    @FXML
	public void gererClicValider() {
		String tempsSelectionne = choixTemps.getValue();

		switch (tempsSelectionne) {
		case "Désactiver":
			VueJeu.activerChronometre(false, 0);
			break;
		case "5 min":
			VueJeu.activerChronometre(true, 300);
			break;
		case "2 min":
			VueJeu.activerChronometre(true, 120);
			break;
		case "1 min":
			VueJeu.activerChronometre(true, 60);
			break;
		case "30 sec":
			VueJeu.activerChronometre(true, 30);
			break;
		case "10 sec":
			VueJeu.activerChronometre(true, 10);
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
    	VueJeu.activerFenetreMulti(couleur1, couleur2);
    }

    /**
     * Permet de revenir à la fenêtre de lancement du jeu en multijoueur
     */
    @FXML
    public void gererClicRetourMultijoueur() {
        VueJeu.activerFenetreMulti(couleur1, couleur2);
    }
}