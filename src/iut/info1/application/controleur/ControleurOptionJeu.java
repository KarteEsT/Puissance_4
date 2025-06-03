/*
 * ControleurOptionJeu.java                                         19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;
import iut.info1.application.VueJeu;
import javafx.fxml.FXML;

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
        VueJeu.activerFenetreSon();
    }

    /**
     * Active la fenêtre d'aide
     */
    @FXML
    public void gererAide() {
        //TODO Permet d'activer et de désactiver l'aide
    	//avec une fenêtre pop-up
    	//TODO a faire
    }

}
