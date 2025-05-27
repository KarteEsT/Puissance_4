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
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicRetourOption() {
        VueJeu.activerFenetreOption();
    }

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicChronometre() {
        VueJeu.activerFenetreChronoOption();
    }

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicSon() {
        VueJeu.activerFenetreSon();
    }

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererAide() {
        //TODO Permet d'activer et de désactiver l'aide avec une fenêtre pop-up
    }

}
