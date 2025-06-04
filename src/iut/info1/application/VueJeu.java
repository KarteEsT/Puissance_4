/*
 * VueJeu.java                                                   28 avril. 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP3, pas de copyright
 */
package iut.info1.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Modality;

import iut.info1.application.controleur.ControleurJeu;
import iut.info1.application.controleur.ControleurMultijoueur;
import iut.info1.application.controleur.ControleurOrdinateur;
import iut.info1.application.controleur.ControleurPopup;
import iut.info1.application.utils.CouleursGlobales;
import iut.info1.application.utils.GrilleGlobales;
import iut.info1.application.utils.NomsGlobals;

/**
 * Classe principale de l'application Puissance 4. Cette classe gère les
 * différentes fenêtres de l'application. (Vue)
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class VueJeu extends Application {

    private static Scene sceneJeu;
    private static Scene sceneMenu;
    private static Scene sceneMulti;
    private static Scene sceneOrdi;
    private static Scene sceneChronoOption;
    private static Scene sceneChronoLancementMultijoueur;
    private static Scene sceneChronoLancementOrdinateur;
    private static Scene sceneOption;
    private static Scene sceneOptionJeu;
    private static Scene sceneSon;

    private static ControleurJeu controleurJeu; // Instance du contrôleur
    private static ControleurMultijoueur controleurMulti;
    private static ControleurOrdinateur controleurOrdi;

    private static Stage fenetreMenu;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Menu principal
            FXMLLoader chargeurFXMLMenu = new FXMLLoader(getClass().getResource
                    ("/iut/info1/application/vue/menuPrincipal.fxml"));
            Parent conteneurMenu = chargeurFXMLMenu.load();
            sceneMenu = new Scene(conteneurMenu, 800, 1700);
            sceneMenu.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // Multijoueur
            FXMLLoader chargeurFXMLMulti = new FXMLLoader(getClass().getResource
                    ("/iut/info1/application/vue/multijoueur.fxml"));
            Parent conteneurMulti = chargeurFXMLMulti.load();
            controleurMulti = chargeurFXMLMulti.getController();
            sceneMulti = new Scene(conteneurMulti, 800, 1700);
            sceneMulti.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // Contre ordinateur
            FXMLLoader chargeurFXMLOrdi = new FXMLLoader(getClass().getResource
                    ("/iut/info1/application/vue/contreOrdi.fxml"));
            Parent conteneurOrdi = chargeurFXMLOrdi.load();
            controleurOrdi = chargeurFXMLOrdi.getController();
            sceneOrdi = new Scene(conteneurOrdi, 800, 1700);
            sceneOrdi.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // Jeu
            FXMLLoader chargeurFXMLJeu = new FXMLLoader(getClass().getResource
                    ("/iut/info1/application/vue/fenetreJeu.fxml"));
            Parent conteneurJeu = chargeurFXMLJeu.load();
            controleurJeu = chargeurFXMLJeu.getController();
            sceneJeu = new Scene(conteneurJeu, 800, 1700);
            sceneJeu.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // Paramètres Chronomètre Lancement Multijoueur
            FXMLLoader chargeurFXMLChronoLancementMultijoueur =
                    new FXMLLoader(getClass().getResource("/iut/info1/"
                            + "application/vue/optionChronoLancementMultijoueur.fxml"));
            Parent conteneurChronoLancementMultijoueur = 
                    chargeurFXMLChronoLancementMultijoueur.load();
            sceneChronoLancementMultijoueur = 
                    new Scene(conteneurChronoLancementMultijoueur, 800, 1700);
            sceneChronoLancementMultijoueur.getStylesheets().add(getClass()
                    .getResource("/iut/info1/application/css/style.css")
                    .toExternalForm());

            // Paramètres Chronomètre Lancement Ordinateur
            FXMLLoader chargeurFXMLChronoLancementOrdinateur =
                    new FXMLLoader(getClass().getResource("/iut/info1/"
                            + "application/vue/optionChronoLancementOrdinateur.fxml"));
            Parent conteneurChronoLancementOrdinateur =
                    chargeurFXMLChronoLancementOrdinateur.load();
            sceneChronoLancementOrdinateur = 
                    new Scene(conteneurChronoLancementOrdinateur, 800, 1700);
            sceneChronoLancementOrdinateur.getStylesheets().add(getClass()
                    .getResource("/iut/info1/application/css/style.css")
                    .toExternalForm());

            // Paramètres Chronomètre Option
            FXMLLoader chargeurFXMLChronoOption =
                    new FXMLLoader(getClass().getResource
                            ("/iut/info1/application/vue/optionChronoOption.fxml"));
            Parent conteneurChronoOption = chargeurFXMLChronoOption.load();
            sceneChronoOption = new Scene(conteneurChronoOption, 800, 1700);
            sceneChronoOption.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // Paramètres Options
            FXMLLoader chargeurFXMLOption =
                    new FXMLLoader(getClass().getResource
                            ("/iut/info1/application/vue/option.fxml"));
            Parent conteneurOption = chargeurFXMLOption.load();
            sceneOption = new Scene(conteneurOption, 800, 1700);
            sceneOption.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // Paramètres Options Jeu
            FXMLLoader chargeurFXMLOptionJeu =
                    new FXMLLoader(getClass().getResource
                            ("/iut/info1/application/vue/optionJeu.fxml"));
            Parent conteneurOptionJeu = chargeurFXMLOptionJeu.load();
            sceneOptionJeu = new Scene(conteneurOptionJeu, 800, 1700);
            sceneOptionJeu.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // Paramètres Son
            FXMLLoader chargeurFXMLOptionSon = 
                    new FXMLLoader(getClass().getResource
                            ("/iut/info1/application/vue/optionSon.fxml"));
            Parent conteneurOptionSon = chargeurFXMLOptionSon.load();
            sceneSon = new Scene(conteneurOptionSon, 800, 1700);
            sceneSon.getStylesheets().add(getClass().getResource
                    ("/iut/info1/application/css/style.css").toExternalForm());

            // PrimaryStage
            primaryStage.setTitle("Puissance 4");
            primaryStage.setHeight(800);
            primaryStage.setWidth(1500);
            primaryStage.setScene(sceneMenu);
            fenetreMenu = primaryStage;

            primaryStage.show();

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des fichiers FXML : "
                    + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Permet d'activer la fenêtre du menu principal de l'application.
     */
    public static void activerFenetreMenu() {
        fenetreMenu.setScene(sceneMenu);
    }

    /**
     * Permet d'activer la fenêtre de lancement du jeu en multijoueur.
     */
    public static void activerFenetreMulti() {
        fenetreMenu.setScene(sceneMulti);
        redistribuerCouleurs();
        redistribuerNoms();
    }

    /**
     * Permet d'activer la fenêtre de lancement du jeu contre l'ordinateur.
     */
    public static void activerFenetreOrdi() {
        fenetreMenu.setScene(sceneOrdi);
        redistribuerCouleurs();
        redistribuerNoms();
    }

    /**
     * Permet d'activer la fenêtre du chronomètre pour le lancement multijoueur.
     */
    public static void activerFenetreChronoLancementMultijoueur() {
        fenetreMenu.setScene(sceneChronoLancementMultijoueur);
    }

    /**
     * Permet d'activer la fenêtre du chronomètre pour le
     * lancement contre l'ordinateur.
     */
    public static void activerFenetreChronoLancementOrdinateur() {
        fenetreMenu.setScene(sceneChronoLancementOrdinateur);
    }

    /**
     * Permet d'activer la fenêtre des options du chronomètre.
     */
    public static void activerFenetreChronoOption() {
        fenetreMenu.setScene(sceneChronoOption);
    }

    /**
     * Permet d'activer la fenêtre du jeu.
     */
    public static void activerFenetreJeu() {
        fenetreMenu.setScene(sceneJeu);
        redistribuerNoms();
        redistribuerCouleurs();
        redistribuerMatrice();
    }

    /**
     * Permet d'activer la fenêtre des options générales du jeu.
     */
    public static void activerFenetreOption() {
        fenetreMenu.setScene(sceneOption);
    }

    /**
     * Permet d'activer la fenêtre des options du jeu.
     */
    public static void activerFenetreOptionJeu() {
        fenetreMenu.setScene(sceneOptionJeu);
    }

    /**
     * Permet d'activer la fenêtre des options son.
     */
    public static void activerFenetreSon() {
        fenetreMenu.setScene(sceneSon);
    }

    /**
     * Permet d'activer la fenêtre de jeu sans refaire les couleurs
     */
    public static void activerFenetreJeuSansModification() {
        fenetreMenu.setScene(sceneJeu);
    }

    /**
     * Active une fenêtre de choix de couleur pour un joueur spécifique.
     * @param joueur le nom du joueur pour lequel
     * la fenêtre de choix de couleur est activée.
     * @param idButton l'identifiant du bouton qui a été cliqué pour ouvrir la fenêtre.
     */
    public static void activerFenetreCouleur(String joueur, String idButton) {
        try {
            FXMLLoader loader = new FXMLLoader(VueJeu.class.getResource
                    ("/iut/info1/application/vue/couleurPopup.fxml"));
            Parent root = loader.load();

            ControleurPopup controleurPopup = loader.getController();
            controleurPopup.setInformations(joueur, idButton); // Initialise les informations

            Stage popupStage = new Stage();
            popupStage.setTitle("Choix de couleur - " + joueur);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
        } catch (Exception erreurLancement) {
            System.err.println("Erreur lors du chargement du popup FXML : "
                    + erreurLancement.getMessage());
            erreurLancement.printStackTrace();
        }
    }

    /**
     * Activer la fenêtre de sauvegarde du jeu.
     */
    public static void activerFenetreSauvegarde() {
        try {
            FXMLLoader loaderSauvegarde = new FXMLLoader(VueJeu.class.getResource
                    ("/iut/info1/application/vue/sauvegarde.fxml"));

            Parent root = loaderSauvegarde.load();
            Stage popupStage = new Stage();
            popupStage.setTitle("Sauvegarde du jeu");
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du popup de sauvegarde : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Activer la fenêtre de chargement du jeu.
     */
    public static void activerFenetreChargement() {
        try {
            FXMLLoader loaderCharger = new FXMLLoader(VueJeu.class.getResource
                    ("/iut/info1/application/vue/charger.fxml"));

            Parent root = loaderCharger.load();
            Stage popupStage = new Stage();
            popupStage.setTitle("Chargement du jeu");
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du popup de sauvegarde : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Activer la fenêtre des règles du jeu.
     */
    public static void activerFenetreRegles() {
        try {
            FXMLLoader loaderRegles = new FXMLLoader(VueJeu.class.getResource
                    ("/iut/info1/application/vue/regles.fxml"));

            Parent root = loaderRegles.load();
            Stage popupStage = new Stage();
            popupStage.setTitle("Règles du jeu");
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du popup des règles : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Met à jour la couleur du joueur 1 dans tous les contrôleurs.
     * @param couleur1 la couleur du joueur 1
     */
    public static void mettreAJourCouleurJoueur1(String couleur1) {
        controleurMulti.mettreAJourCouleur(couleur1, null);
        controleurOrdi.mettreAJourCouleur(couleur1, null);
    }

    /**
     * Met à jour la couleur du joueur 2 dans tous les contrôleurs.
     * @param couleur2 la couleur du joueur 2
     */
    public static void mettreAJourCouleurJoueur2(String couleur2) {
        controleurMulti.mettreAJourCouleur(null, couleur2);
        controleurOrdi.mettreAJourCouleur(null, couleur2);
    }

    /**
     * Redistribue les couleurs des joueurs à tous les contrôleurs.
     */
    public static void redistribuerCouleurs() {
        String couleur1 = CouleursGlobales.getCouleurJoueur1();
        String couleur2 = CouleursGlobales.getCouleurJoueur2();

        controleurMulti.mettreAJourCouleur(couleur1, couleur2);
        controleurOrdi.mettreAJourCouleur(couleur1, couleur2);
        controleurJeu.mettreAJourCouleur(couleur1, couleur2);
    }

    /**
     * Redistribue les noms des joueurs à tous les contrôleurs.
     */
    public static void redistribuerNoms() {
        String nomJoueur1 = NomsGlobals.getNomJoueur1();
        String nomJoueur2 = NomsGlobals.getNomJoueur2();

        controleurMulti.mettreAJourLabels(nomJoueur1, nomJoueur2);
        controleurOrdi.mettreAJourLabels(nomJoueur1, nomJoueur2);
        controleurJeu.mettreAJourLabels(nomJoueur1, nomJoueur2);
    }

    /**
     * Redistribue la matrice de jeu à tous les contrôleurs.
     */
    public static void redistribuerMatrice() {
        int[][] matrice = GrilleGlobales.getMatrice();
        controleurJeu.mettreAJourMatrice(matrice);
    }

    /**
     * Point d'entrée de l'application JavaFX.
     * @param args non utilisé
     */
    public static void main(String[] args) {
        launch(args);
    }
}