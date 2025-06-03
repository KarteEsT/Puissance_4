/*
 * ControleurOptionGraphique.java                                   19 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;
import iut.info1.application.VueJeu;
import javafx.fxml.FXML;

/**
 * Contrôleur de la vue "optionGraphique"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurOptionGraphique {

    /**
     * Méthode appelée lors du clic sur le bouton "Retour au menu"
     */
    @FXML
    public void gererClicRetourMenu() {
        VueJeu.activerFenetreOption();
    }

}