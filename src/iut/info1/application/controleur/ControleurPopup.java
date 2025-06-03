/*
 * ControleurPopup.java                                             16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Optional;

import iut.info1.application.VueJeu;

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
    private Label joueur1;
	
    @FXML
    private Label joueur2;
    
    @FXML
    private Button buttonCouleur1;
    
    @FXML
    private Button buttonCouleur2;

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
    	ouvrirConfirmation("#FF0000");
    }

    @FXML
    private void activerOrange() {
    	ouvrirConfirmation("#FFBF00");
    }

    @FXML
    private void activerBleu() {
    	ouvrirConfirmation("#2600FF");
    }

    @FXML
    private void activerRose() {
    	ouvrirConfirmation("#FF0088");
    }

    @FXML
    private void activerVert() {
    	ouvrirConfirmation("#00FF11");
    }

    @FXML
    private void activerViolet() {
    	ouvrirConfirmation("#FF00FD");
    }

    @FXML
    private void activerJaune() {
    	ouvrirConfirmation("#E5FF00");
    }

    @FXML
    private void activerTurquoise() {
    	ouvrirConfirmation("#00D1C7");
    }
    
    private void ouvrirConfirmation(String couleur) {
        Alert boiteAlerte = new Alert(Alert.AlertType.INFORMATION,
        					"Êtes-vous sûr de vouloir changer la couleur de " + 
        					joueurLabel.getText() + 
        					" ?", ButtonType.YES, ButtonType.NO);
        boiteAlerte.setTitle("Confirmation");
        Optional<ButtonType> option = boiteAlerte.showAndWait();
        if (option.isPresent() && option.get() == ButtonType.YES) {
            if (joueurLabel.getText().contains("Joueur 1")) {
                appliquerCouleurJoueur1(couleur);
            } else if (joueurLabel.getText().contains("Joueur 2")) {
                appliquerCouleurJoueur2(couleur);
            }
        }
    }
    
    @FXML
    private void appliquerCouleurJoueur1(String couleur) {
        VueJeu.mettreAJourCouleurJoueur1(couleur); 
    }

    @FXML
    private void appliquerCouleurJoueur2(String couleur) {
        VueJeu.mettreAJourCouleurJoueur2(couleur); 
    }
}