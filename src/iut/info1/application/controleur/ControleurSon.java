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

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicRetourMenu() {
        VueJeu.activerFenetreOptionJeu();
    }

    //TODO ajouter les méthodes pour gérer le son
}