/*
 * ControleurChronometre.java                                 16 mai 2025
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
 * Gère les paramètres de chronomètre pour les parties de jeu
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

    /* Constantes pour les durées */
    private static final int DUREE_5_MINUTES = 300;
    private static final int DUREE_2_MINUTES = 120;
    private static final int DUREE_1_MINUTE = 60;
    private static final int DUREE_30_SECONDES = 30;
    private static final int DUREE_10_SECONDES = 10;

    /* Constantes pour les textes */
    private static final String DESACTIVER = "Désactiver";
    private static final String CINQ_MIN = "5 min";
    private static final String DEUX_MIN = "2 min";
    private static final String UNE_MIN = "1 min";
    private static final String TRENTE_SEC = "30 sec";
    private static final String DIX_SEC = "10 sec";
    
    private static final String LABEL_ACTIVER
    = "Activer le chronomètre de la partie";
    private static final String LABEL_DESACTIVER
    = "Désactiver le chronomètre de la partie";

    /**
     * Initialisation de la vue "optionChrono"
     */
    @FXML
    public void initialize() {
        // Remplir la ComboBox avec les options de temps
        choixTemps.getItems().addAll(DESACTIVER, CINQ_MIN, DEUX_MIN, UNE_MIN,
                                     TRENTE_SEC, DIX_SEC);
        
        // Initialiser l'état des boutons
        activerDesactiverChronoGlobal();
    }
    
    /**
     * Permet de mettre à jour la durée du chronomètre
     */
    @FXML
    public void gererClicValider() {
        String tempsSelectionne = choixTemps.getValue();
        
        // Vérification de sélection
        if (tempsSelectionne == null) {
            return;
        }
        
        ControleurJeu controleurJeu = VueJeu.getControleurJeu();
        
        int duree;
        switch (tempsSelectionne) {
            case DESACTIVER:
                desactiverChronometre(controleurJeu);
                duree = 0;
                break;
            case CINQ_MIN:
                activerChronometre(controleurJeu, DUREE_5_MINUTES);
                duree = DUREE_5_MINUTES;
                break;
            case DEUX_MIN:
                activerChronometre(controleurJeu, DUREE_2_MINUTES);
                duree = DUREE_2_MINUTES;
                break;
            case UNE_MIN:
                activerChronometre(controleurJeu, DUREE_1_MINUTE);
                duree = DUREE_1_MINUTE;
                break;
            case TRENTE_SEC:
                activerChronometre(controleurJeu, DUREE_30_SECONDES);
                duree = DUREE_30_SECONDES;
                break;
            case DIX_SEC:
                activerChronometre(controleurJeu, DUREE_10_SECONDES);
                duree = DUREE_10_SECONDES;
                break;
            default:
                desactiverChronometre(controleurJeu);
                duree = 0;
        }
        ChronosGlobales.setTempsChrono(duree);
    }
    
    /**
     * Active le chronomètre avec la durée spécifiée
     * @param controleurJeu le contrôleur du jeu
     * @param duree la durée en secondes
     */
    private static void activerChronometre(ControleurJeu controleurJeu, int duree) {
        controleurJeu.setDureeTotale(duree);
        ChronosGlobales.setTempsChrono(duree);
        controleurJeu.progressBar1.setVisible(true);
        controleurJeu.progressBar2.setVisible(true);
    }
    
    /**
     * Désactive le chronomètre
     * @param controleurJeu le contrôleur du jeu
     */
    private static void desactiverChronometre(ControleurJeu controleurJeu) {
        controleurJeu.progressBar1.setVisible(false);
        controleurJeu.progressBar2.setVisible(false);
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
        VueJeu.activerFenetreOptionOrdinateur();
    }

    /**
     * Permet de revenir à la fenêtre de lancement du jeu en multijoueur
     */
    @FXML
    public void gererClicRetourMultijoueur() {
        VueJeu.activerFenetreOptionMultijoueur();
    }
    
    /**
     * Active le chronomètre de la partie
     */
    @FXML
    public void gererClicActiver() {
        ChronosGlobales.setChronoPartie(true);
        activerDesactiverChronoGlobal();
    }
    
    /**
     * Désactive le chronomètre de la partie
     */
    @FXML
    public void gererClicDesactiver() {
        ChronosGlobales.setChronoPartie(false);
        activerDesactiverChronoGlobal();
    }
    
    /**
     * Met à jour l'état d'activation/désactivation des boutons de chronomètre global
     * selon l'état actuel du chronomètre de partie
     */
    public void activerDesactiverChronoGlobal() {
        boolean chronoActif = ChronosGlobales.getChronoPartie();
        
        // Gestion du bouton d'activation
        activerChronoGlobal.setDisable(chronoActif);
        activerChronoGlobal.setVisible(!chronoActif);
        
        // Gestion du bouton de désactivation
        desactiverChronoGlobal.setDisable(!chronoActif);
        desactiverChronoGlobal.setVisible(chronoActif);
        
        // Mise à jour du label
        labelChronoGlobal.setText(chronoActif ? LABEL_DESACTIVER : LABEL_ACTIVER);
    }
    
    /**
     * Permet de lancer la vue des règles
     */
    @FXML
    public void gererClicInfo() {       
        VueJeu.activerFenetreRegles();
    }
}