/*
 * ControleurOrdinateur.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Contrôleur de la vue "contreOrdi"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurOrdinateur {

	String joueur1;
	String joueur2;
	
    /** Bouton pour retourner au Menu */
    @FXML
    private Button retourMenu;

    @FXML
    private TextField nomJoueur1;

    @FXML
    private TextField nomJoueur2;

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicRetourMenu() {
        VueJeu.activerFenetreMenu();
    }

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicChrono() {
        VueJeu.activerFenetreChronoLancementOrdinateur();
    }

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicCouleurJoueur1() {
        VueJeu.activerFenetreCouleur("Joueur 1");
    }

    /**
     * TODO commenter le rôle de cette méthode (SRP)
     */
    @FXML
    public void gererClicCouleurJoueur2() {
        VueJeu.activerFenetreCouleur("Joueur 2");
    }

    /**
     * Permet de lancer la partie en transmettant les noms des joueurs.
     */
    @FXML
    public void gererClicLancer() {
        joueur1 = nomJoueur1.getText().isEmpty() ? "JOUEUR 1" : nomJoueur1.getText();
        joueur2 = nomJoueur2.getText().isEmpty() ? "JOUEUR 2" : nomJoueur2.getText();

        if (nomJoueur1.getText().isEmpty() || nomJoueur2.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Champs vides");
            alert.setHeaderText("Un ou plusieurs champs sont vides.");
            alert.setContentText("Les noms par défaut seront utilisés : " + joueur1 + " et " + joueur2 + ". Voulez-vous continuer ?");

            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    VueJeu.activerFenetreJeu(joueur1, joueur2);
                }
            });
        } else {
            VueJeu.activerFenetreJeu(joueur1, joueur2);
        }
    }
}
