/*
 * ControleurPopup.java                                             16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;

import iut.info1.application.controleur.ControleurJeu;
import iut.info1.application.controleur.ControleurMultijoueur;
import iut.info1.application.controleur.ControleurOrdinateur;

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
        Stage confirmationStage = new Stage();
        confirmationStage.initModality(Modality.APPLICATION_MODAL);
        confirmationStage.setTitle("Confirmation");
        
        // Positionner la fenêtre à un endroit précis
        confirmationStage.setX(500); // Position horizontale
        confirmationStage.setY(500); // Position verticale

        Label message = new Label("Voulez-vous appliquer cette couleur ?");
        Button validerButton = new Button("Valider");
        Button annulerButton = new Button("Annuler");

        validerButton.setOnAction(event -> {
            //  appliquerCouleur(couleur);
            confirmationStage.close();
            ((Stage) joueurLabel.getScene().getWindow()).close(); // Ferme la fenêtre principale
        });

        annulerButton.setOnAction(event -> confirmationStage.close());

        VBox layout = new VBox(10, message, validerButton, annulerButton);
        layout.setStyle("-fx-padding: 10;");
        Scene scene = new Scene(layout);
        confirmationStage.setScene(scene);
        confirmationStage.showAndWait();
    }

    private void appliquerCouleur(String couleur) {
        joueur1.setStyle("-fx-background-color: " + couleur + ";");
        joueur2.setStyle("-fx-background-color: " + couleur + ";");
        buttonCouleur1.setStyle("-fx-background-color: " + couleur + ";");
        buttonCouleur2.setStyle("-fx-background-color: " + couleur + ";");
    }
}