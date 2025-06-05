/*
 * ControleurMultijoueur.java                                       16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import iut.info1.application.utils.CouleursGlobales;
import iut.info1.application.utils.NomsGlobals;
import iut.info1.application.utils.SauvegardeCheminOption;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Contrôleur de la vue "multijoueur"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurMultijoueur {

    private String joueur1;
    private String joueur2;

    /** Bouton pour retourner au Menu */
    @FXML
    private Button retourMenu;
    
    /** Identifiant du bouton de couleur du joueur 1 */
    @FXML
    private Button buttonCouleur1;
    
    /** Identifiant du bouton de couleur du joueur 2 */
    @FXML
    private Button buttonCouleur2;

    /** Identifiant du textfield du joueur 1 */
    @FXML
    private TextField nomJoueur1;

    /** Identifiant du textfield du joueur 2 */
    @FXML
    private TextField nomJoueur2;
    
	/** Initialisation de la vue "multijoueur" */
    public void initialize() {
        String couleur1 = CouleursGlobales.getCouleurJoueur1();
        String couleur2 = CouleursGlobales.getCouleurJoueur2();
        mettreAJourCouleur(couleur1, couleur2);
    }

    /** Permet de lancer l'interface de gestion des couleurs du joueur 1 */
    @FXML
    public void gererClicCouleurJoueur1() {
        VueJeu.activerFenetreCouleur(nomJoueur1.getText(), buttonCouleur1.getId());
    }

    /** Permet de lancer l'interface de gestion des couleurs du joueur 2 */
    @FXML
    public void gererClicCouleurJoueur2() {
        VueJeu.activerFenetreCouleur(nomJoueur2.getText(), buttonCouleur2.getId());
    }

    /** Permet de lancer la partie en transmettant les noms des joueurs. */
    @FXML
    public void gererClicLancer() {
        joueur1 = nomJoueur1.getText().isEmpty() ? "JOUEUR 1" 
                                                : nomJoueur1.getText();
        joueur2 = nomJoueur2.getText().isEmpty() ? "JOUEUR 2" 
                                                : nomJoueur2.getText();

        if (nomJoueur1.getText().isEmpty() || nomJoueur2.getText().isEmpty()) {
        	
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Champs vides");
            alert.setHeaderText("Un ou plusieurs champs sont vides.");
            alert.setContentText("Les noms par défaut seront utilisés : " 
                                    + joueur1 + " et " + joueur2 
                                    + ". Voulez-vous continuer ?");

            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                	
                	if (NomsGlobals.getNomJoueur1() == null || NomsGlobals.getNomJoueur1().isEmpty()) {
                        NomsGlobals.setNomJoueur1("JOUEUR 1");
                    }
                    if (NomsGlobals.getNomJoueur2() == null || NomsGlobals.getNomJoueur2().isEmpty()) {
                        NomsGlobals.setNomJoueur2("JOUEUR 2");
                    }
                	
                    VueJeu.activerFenetreJeu();
                }
            });
        } else {
            VueJeu.activerFenetreJeu();
        }
    }
    
	/** Permet de gérer la touche "Entrée" pour valider le nom du joueur 1 */
    @FXML
    public void gererToucheNomJoueur1() {
        NomsGlobals.setNomJoueur1(nomJoueur1.getText());
    }

	/** Permet de gérer la touche "Entrée" pour valider le nom du joueur 2 */
    @FXML
    public void gererToucheNomJoueur2() {
        NomsGlobals.setNomJoueur2(nomJoueur2.getText());
    }
    
    /**
     * Méthode pour mettre à jour les labels des joueurs
     * @param joueur1 nom du joueur 1
     * @param joueur2 nom du joueur 2
     */
    public void mettreAJourLabels(String joueur1, String joueur2) {
    	nomJoueur1.setText(joueur1);;
    	nomJoueur2.setText(joueur2);
    }
    
    /**
     * Met à jour les couleurs des boutons de sélection
     * @param couleur1 du joueur 1
     * @param couleur2 du joueur 2
     */
    @FXML
    public void mettreAJourCouleur(String couleur1, String couleur2) {
    	
        if (couleur1 != null) {
            buttonCouleur1.setStyle("-fx-background-color: " + couleur1 + ";");
        }
        if (couleur2 != null) {
            buttonCouleur2.setStyle("-fx-background-color: " + couleur2 + ";");
        }
    }
    
    /* Changer de vue */
    
    /** Permet de retourner au Menu principal */
    @FXML
    public void gererClicRetourMenu() {
        VueJeu.activerFenetreMenu();
    }

    /** Permet de lancer l'interface de gestion du chrono */
    @FXML
    public void gererClicOptionJeu() {
        VueJeu.activerFenetreOptionJeu();
        SauvegardeCheminOption.setChemin("Multi");
    }
    
    /**
     * Permet de lancer la vue des règles
     */
    public void gererClicInfo() {  	
    	VueJeu.activerFenetreRegles();
    }
}