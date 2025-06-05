/*
 * ControleurSon.java                                               19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.fxml.FXML;
import iut.info1.application.VueJeu;

/**
 * Contrôleur de la vue "optionSon"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurSon {

    /** Active la fenêtre des options de jeu */
    @FXML
    public void gererClicRetourMenu() {
        VueJeu.activerFenetreOptionJeu();
    }
    
    /** Permet de lancer la vue des règles */
    public void gererClicInfo() {  	
    	VueJeu.activerFenetreRegles();
    }

    //TODO ajouter les méthodes pour gérer le son
}