/*
 * ControleurPopup.java                                             16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Contrôleur de la vue "couleurPopup"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
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

    @FXML
    private void activerRouge() {
        changerCouleur("#FF0000");
    }

    @FXML
    private void activerOrange() {
        changerCouleur("#FFBF00");
    }

    @FXML
    private void activerBleu() {
        changerCouleur("#2600FF");
    }

    @FXML
    private void activerRose() {
        changerCouleur("#FF0088");
    }

    @FXML
    private void activerVert() {
        changerCouleur("#00FF11");
    }

    @FXML
    private void activerViolet() {
        changerCouleur("#FF00FD");
    }

    @FXML
    private void activerJaune() {
        changerCouleur("#E5FF00");
    }

    @FXML
    private void activerTurquoise() {
        changerCouleur("#00D1C7");
    }

    private void changerCouleur(String couleur) {
        
    }
}