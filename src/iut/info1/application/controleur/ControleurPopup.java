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

	/** identifiant des boutons */
	private String idButton;
	
	/** pseudo du joueur sélectionner */
	private String joueur;
	
	/** Identifiant utiliser pour fermer la fenêtre pop-pup */
	@FXML
	private Button rouge;
	
	/**
     * Initialise les informations nécessaires pour la gestion des couleurs.
     * @param joueur Le nom du joueur.
     * @param idButton L'identifiant du bouton.
     */
    public void setInformations(String joueur, String idButton) {
        this.joueur = joueur;
        this.idButton = idButton;
    }
	
    /** Active la couleur rouge */
    @FXML
    private void activerRouge() {
    	ouvrirConfirmation(joueur, idButton, "#FF0000");
    }

    /** Active la couleur orange */
    @FXML
    private void activerOrange() {
    	ouvrirConfirmation(joueur, idButton, "#FFBF00");
    }

    /** Active la couleur bleu */
    @FXML
    private void activerBleu() {
    	ouvrirConfirmation(joueur, idButton, "#2600FF");
    }

    /** Active la couleur rose */
    @FXML
    private void activerRose() {
    	ouvrirConfirmation(joueur, idButton, "#FF0088");
    }

    /** Active la couleur vert */
    @FXML
    private void activerVert() {
    	ouvrirConfirmation(joueur, idButton, "#00FF11");
    }

    /** Active la couleur violette */
    @FXML
    private void activerViolet() {
    	ouvrirConfirmation(joueur, idButton, "#FF00FD");
    }

    /** Active la couleur jaune */ 
    @FXML
    private void activerJaune() {
    	ouvrirConfirmation(joueur, idButton, "#FFFF00");
    }

    /** Active la couleur Turquoise */
    @FXML
    private void activerTurquoise() {
    	ouvrirConfirmation(joueur, idButton, "#00D1C7");
    }
    
    /**
     * Cette méthode permet de mettre une couleur à un joueur
     * @param joueur pseudo du joueur
     * @param idButton identifiant du bouton qui active la fenêtre
     * @param couleur couleur du joueur
     */
    private void ouvrirConfirmation(String joueur, String idButton,
                                                   String couleur) {
        // Vérification des couleurs
        if ("buttonCouleur1".equals(idButton) && 
                couleur.equals(CouleursGlobales.getCouleurJoueur2())) {
            afficherErreurCouleursIdentiques();
            return;
        } else if ("buttonCouleur2".equals(idButton) && 
                couleur.equals(CouleursGlobales.getCouleurJoueur1())) {
            afficherErreurCouleursIdentiques();
            return;
        }

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
    
    /** Fenêtre d'erreur quand deux joueurs ont la même couleur */
    private void afficherErreurCouleursIdentiques() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur de couleur");
        alert.setTitle("Couleurs identiques");
        alert.setContentText("Les deux joueurs ne peuvent pas avoir " +
                            " la même couleur. Veuillez en choisir une autre.");
        alert.showAndWait();
    }
    
    /** Méthode pour envoyer la couleur du joueur 1 dans le tampon */
    @FXML
    private void appliquerCouleurJoueur1(String couleur) {
        CouleursGlobales.setCouleurJoueur1(couleur);
        VueJeu.mettreAJourCouleurJoueur1(couleur);
    }

    /** Méthode pour envoyer la couleur du joueur 2 dans le tampon */
    @FXML
    private void appliquerCouleurJoueur2(String couleur) {
        CouleursGlobales.setCouleurJoueur2(couleur);
        VueJeu.mettreAJourCouleurJoueur2(couleur);
    }
}