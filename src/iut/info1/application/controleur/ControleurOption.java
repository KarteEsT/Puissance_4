/*
 * ControleurOption.java                                            19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import java.util.Optional;

import iut.info1.application.VueJeu;
import iut.info1.application.utils.SauvegardeCheminOption;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.shape.Circle;

/**
 * Contrôleur de la vue "option"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurOption {

    /**
     * active la fenêtre des options graphiques
     */
    @FXML
    public void gererClicSauvegarder() {
    	VueJeu.activerFenetreSauvegarde();
    }

    /**
     * active la fenêtre des options de jeu
     */
    @FXML
    public void gererClicOptionJeu() {
        VueJeu.activerFenetreOptionJeu();
        SauvegardeCheminOption.setChemin("Menu");
    }

    /**
     * Gère le clic sur le bouton "Reprendre"
     */
    @FXML
    public void gererClicReprendre() {
    	VueJeu.activerFenetreJeuSansMatrice();    
    }
    
    /**
     * Bouton pour retourner au menu principal
     */
    @FXML
    public void gererClicRetourMenu() {
    	Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION,
                "Êtes-vous sur de vouloir retourner au menu ?",
                ButtonType.YES, ButtonType.NO);
        boiteAlerte.setTitle("Retour menu");

        Optional<ButtonType> option = boiteAlerte.showAndWait();
        if (option.get() == ButtonType.YES) {
    		VueJeu.activerFenetreMenu();
    		
    	}
		
    }

    /**
     * Active une boite d'alerte de confirmation pour quitter le jeu.
     * Si l'utilisateur confirme, le programme se ferme.
     */
    @FXML
    public void gererClicQuitter() {
        Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION,
                "Êtes-vous sur de vouloir quitter ?",
                ButtonType.YES, ButtonType.NO);
        boiteAlerte.setTitle("Quitter le jeu");

        Optional<ButtonType> option = boiteAlerte.showAndWait();
        if (option.get() == ButtonType.YES) {
            Platform.exit();
        }
    }
    
    /**
     * Permet de lancer la vue des règles
     */
    public void gererClicInfo() {  	
    	VueJeu.activerFenetreRegles();
    }
}