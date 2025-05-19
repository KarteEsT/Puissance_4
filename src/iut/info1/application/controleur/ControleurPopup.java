/*
 * ControleurPopup.java                                             16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Contrôleur de la vue "couleurPopup"
 * @author Gabriel Robache
 */
public class ControleurPopup {

    @FXML
    private Label joueurLabel;

    /**
     * @param joueur Nom du joueur.
     */
    public void setJoueur(String joueur) {
        if (joueurLabel != null) {
            joueurLabel.setText("Choix de couleur pour : " + joueur);
        }
    }
}