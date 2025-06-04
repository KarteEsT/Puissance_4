/*
 * ControleurChronometre.java                                        16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import iut.info1.application.utils.ChronosGlobales;

/**
 * Contrôleur de la vue "optionChrono"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurChronometre {

    @FXML private ProgressBar progressBar1;
    @FXML private ProgressBar progressBar2;
        
    @FXML private ComboBox<String> choixTemps;
    
    @FXML private Button activerChronoGlobal;
    @FXML private Button desactiverChronoGlobal;
    
    @FXML private Label labelChronoGlobal;

    /**
     * Initialisation de la vue "optionChrono"
     */
    @FXML
    public void initialize() {
        
        // Remplir la ComboBox (affichés sous forme de texte)
        choixTemps.getItems().addAll("Désactiver", "5 min", "2 min", "1 min",
                                         "30 sec", "10 sec");
    }
    
    /**
     *  Permet de mettre à jour la durée du chronomètre
     */
    @FXML
    public void gererClicValider() {
        String tempsSelectionne = choixTemps.getValue();
        ControleurJeu controleurJeu = VueJeu.getControleurJeu();

        switch (tempsSelectionne) {
            case "Désactiver":
                
                ControleurJeu.progressionActuelle = -1.0;
                
                break;
            case "5 min":
                controleurJeu.setDureeTotale(300.0);
                ChronosGlobales.setTempsChrono(300);
                controleurJeu.progressBar1.setVisible(true);
                controleurJeu.progressBar2.setVisible(true);
                break;
            case "2 min":
                controleurJeu.setDureeTotale(120.0);
                ChronosGlobales.setTempsChrono(120);
                controleurJeu.progressBar1.setVisible(true);
                controleurJeu.progressBar2.setVisible(true);
                break;
            case "1 min":
                controleurJeu.setDureeTotale(60.0);
                ChronosGlobales.setTempsChrono(60);
                controleurJeu.progressBar1.setVisible(true);
                controleurJeu.progressBar2.setVisible(true);
                break;
            case "30 sec":
                controleurJeu.setDureeTotale(30.0);
                ChronosGlobales.setTempsChrono(30);
                controleurJeu.progressBar1.setVisible(true);
                controleurJeu.progressBar2.setVisible(true);
                break;
            case "10 sec":
                controleurJeu.setDureeTotale(10);
                ChronosGlobales.setTempsChrono(10);
                controleurJeu.progressBar1.setVisible(true);
                controleurJeu.progressBar2.setVisible(true);
                break;
            default:
                break;
        }
    }

    /**
     * Permet de revenir sur le menu du jeu
     */
    @FXML
    public void gererClicRetourMenu() {
        VueJeu.activerFenetreOptionJeu();
    }

    /**
     * Permet de revenir à la fenêtre de lancement du jeu contre l'ordinateur
     */
    @FXML
    public void gererClicRetourOrdinateur() {
        VueJeu.activerFenetreOrdi();
    }

    /**
     * Permet de revenir à la fenêtre de lancement du jeu en multijoueur
     */
    @FXML
    public void gererClicRetourMultijoueur() {
        VueJeu.activerFenetreMulti();
    }
    
    /**
     * Activer le chronomètre de la partie
     */
    public void gererClicActiver() {
        activerChronoGlobal.setDisable(true);
        activerChronoGlobal.setVisible(false);
        desactiverChronoGlobal.setDisable(false);
        desactiverChronoGlobal.setVisible(true);
        labelChronoGlobal.setText("Désactiver le choronomètre de la partie");
        ChronosGlobales.setChronoPartie(true);
    }
    
    /**
     * Désactiver le chronomètre de la partie
     */
    public void gererClicDesactiver() {
        activerChronoGlobal.setDisable(false);
        activerChronoGlobal.setVisible(true);
        desactiverChronoGlobal.setDisable(true);
        desactiverChronoGlobal.setVisible(false);
        labelChronoGlobal.setText("Activer le choronomètre de la partie");
        ChronosGlobales.setChronoPartie(false);
    }
    
    /**
     * Permet de lancer la vue des règles
     */
    public void gererClicInfo() {       
        VueJeu.activerFenetreRegles();
    }
}