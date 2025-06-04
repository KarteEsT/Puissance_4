/*
 * ControleurMenuPrincipal.java                                    16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import java.util.Optional;

import iut.info1.application.VueJeu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * Contrôleur de la vue "menuPrincipal"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurMenuPrincipal {

    /** Bouton pour aller dans le Menu Multijoueur */
    @FXML
    private Button ButtonMultiplayer;

    /** Bouton pour aller dans le Menu Ordinateur */
    @FXML
    private Button ButtonOrdinateur;
    
    /**
     * Pour aller dans le Menu Multijoueur
     */
    @FXML
    public void gererClicMultiplayer() {
        VueJeu.activerFenetreMulti();
    }

    /**
     * Pour aller dans le Menu Ordinateur
     */
    @FXML
    public void gererClicOrdinateur() {
        VueJeu.activerFenetreOrdi();
    }

	/**
	 * Permet de lancer la vue de création de partie
	 */
    @FXML
    public void gererClicCharger() {
    	VueJeu.activerFenetreChargement();
    }
    
    /**
     * Permet de quitter l'application
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
