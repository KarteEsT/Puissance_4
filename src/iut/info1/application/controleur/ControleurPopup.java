/*
 * ControleurPopup.java                                             16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import iut.info1.application.VueJeu;
import iut.info1.application.utils.CouleursGlobales;

import javafx.scene.control.Button;

/**
 * Contrôleur de la vue "couleurPopup"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurPopup {

	private String idButton;
	private String joueur;
	
	@FXML
	private Button rouge; //utiliser pour la fermeture de la fenêtre
	
	/**
     * Initialise les informations nécessaires pour la gestion des couleurs.
     * @param joueur Le nom du joueur.
     * @param idButton L'identifiant du bouton.
     */
    public void setInformations(String joueur, String idButton) {
        this.joueur = joueur;
        this.idButton = idButton;
    }
	
    @FXML
    private void activerRouge() {
    	ouvrirConfirmation(joueur, idButton, "#FF0000");
    }

    @FXML
    private void activerOrange() {
    	ouvrirConfirmation(joueur, idButton, "#FFBF00");
    }

    @FXML
    private void activerBleu() {
    	ouvrirConfirmation(joueur, idButton, "#2600FF");
    }

    @FXML
    private void activerRose() {
    	ouvrirConfirmation(joueur, idButton, "#FF0088");
    }

    @FXML
    private void activerVert() {
    	ouvrirConfirmation(joueur, idButton, "#00FF11");
    }

    @FXML
    private void activerViolet() {
    	ouvrirConfirmation(joueur, idButton, "#FF00FD");
    }

    @FXML
    private void activerJaune() {
    	ouvrirConfirmation(joueur, idButton, "#E5FF00");
    }

    @FXML
    private void activerTurquoise() {
    	ouvrirConfirmation(joueur, idButton, "#00D1C7");
    }
    
    private void ouvrirConfirmation(String joueur, String idButton, String couleur) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Confirmation de couleur");
        alert.setTitle("Confirmation de couleur");

        ButtonType oui = new ButtonType("Oui");
        ButtonType annuler = new ButtonType("Annuler");

		alert.setContentText("Voulez-vous appliquer la couleur " + couleur
											+ " au joueur " + joueur + " ?");
        alert.getButtonTypes().clear(); // Efface les boutons par défaut
        alert.getButtonTypes().addAll(oui, annuler);

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == oui) {
        	rouge.getScene().getWindow().hide();
            if ("buttonCouleur1".equals(idButton)) {
                appliquerCouleurJoueur1(couleur);
            } else if ("buttonCouleur2".equals(idButton)) {
                appliquerCouleurJoueur2(couleur);
            }
        }
    }
    
    @FXML
    private void appliquerCouleurJoueur1(String couleur) {
        CouleursGlobales.setCouleurJoueur1(couleur);
        VueJeu.mettreAJourCouleurJoueur1(couleur);
    }

    @FXML
    private void appliquerCouleurJoueur2(String couleur) {
        CouleursGlobales.setCouleurJoueur2(couleur);
        VueJeu.mettreAJourCouleurJoueur2(couleur);
    }
}