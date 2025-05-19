/*
 * VueJeu.java                                                     28 avr. 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP3, pas de copyright
 */
package iut.info1.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Modality;


/**
 * Classe principale de l'application Puissance 4. Cette classe gère les
 * différentes fenêtres de l'application. (Vue)
 * 
 * @author Gabriel Robache
 */
public class VueJeu extends Application {

    private static Scene sceneJeu;
    private static Scene sceneMenu;
    private static Scene sceneMulti;
    private static Scene sceneOrdi;
    private static Scene sceneChrono;
    private static Scene sceneOption;
    private static Scene sceneOptionGraphique;
    private static Scene sceneOptionJeu;
    
    private static Stage fenetreMenu;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Menu principal
            FXMLLoader chargeurFXMLMenu = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/menuPrincipal.fxml"));
            Parent conteneurMenu = chargeurFXMLMenu.load();
            sceneMenu = new Scene(conteneurMenu, 800, 1700);
            sceneMenu.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());

            // Multijoueur
            FXMLLoader chargeurFXMLMulti = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/multijoueur.fxml"));
            Parent conteneurMulti = chargeurFXMLMulti.load();
            sceneMulti = new Scene(conteneurMulti, 800, 1700);
            sceneMulti.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());

            // Contre ordinateur
            FXMLLoader chargeurFXMLOrdi = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/contreOrdi.fxml"));
            Parent conteneurOrdi = chargeurFXMLOrdi.load();
            sceneOrdi = new Scene(conteneurOrdi, 800, 1700);
            sceneOrdi.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());

            // Jeu
            FXMLLoader chargeurFXMLJeu = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/fenetreJeu.fxml"));
            Parent conteneurJeu = chargeurFXMLJeu.load();
            sceneJeu = new Scene(conteneurJeu, 800, 1700);
            sceneJeu.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());

            // Paramètres Chronomètre
            FXMLLoader chargeurFXMLChrono = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/optionChrono.fxml"));
            Parent conteneurChrono = chargeurFXMLChrono.load();
            sceneChrono = new Scene(conteneurChrono, 800, 1700);
            sceneChrono.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());
            
            // Paramètres Options
            FXMLLoader chargeurFXMLOption = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/option.fxml"));
            Parent conteneurOption = chargeurFXMLOption.load();
            sceneOption = new Scene(conteneurOption, 800, 1700);
            sceneOption.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());
            
            // Paramètres Options Graphiques
            FXMLLoader chargeurFXMLOptionGraphique = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/optionGraphique.fxml"));
            Parent conteneurOptionGraphique = chargeurFXMLOptionGraphique.load();
            sceneOptionGraphique = new Scene(conteneurOptionGraphique, 800, 1700);
            sceneOptionGraphique.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());
            
            // Paramètres Options Jeu
            FXMLLoader chargeurFXMLOptionJeu = new FXMLLoader(getClass().getResource("/iut/info1/application/vue/optionJeu.fxml"));
            Parent conteneurOptionJeu = chargeurFXMLOptionJeu.load();
            sceneOptionJeu = new Scene(conteneurOptionJeu, 800, 1700);
            sceneOptionJeu.getStylesheets().add(getClass().getResource("/iut/info1/application/css/style.css").toExternalForm());

            // PrimaryStage
            primaryStage.setTitle("Puissance 4");
            primaryStage.setHeight(800);
            primaryStage.setWidth(1500);
            primaryStage.setScene(sceneMenu);
            fenetreMenu = primaryStage;
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des fichiers FXML : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void activerFenetreMenu() {
        fenetreMenu.setScene(sceneMenu);
    }

    public static void activerFenetreMulti() {
        fenetreMenu.setScene(sceneMulti);
    }

    public static void activerFenetreOrdi() {
        fenetreMenu.setScene(sceneOrdi);
    }

    public static void activerFenetreChrono() {
        fenetreMenu.setScene(sceneChrono);
    }
    
    public static void activerFenetreJeu() {
        fenetreMenu.setScene(sceneJeu);
    }
    
	public static void activerFenetreOption() {
		fenetreMenu.setScene(sceneOption);
	}
	
	public static void activerFenetreOptionGraphique() {
		fenetreMenu.setScene(sceneOptionGraphique);
	}
	
	public static void activerFenetreOptionJeu() {
		fenetreMenu.setScene(sceneOptionJeu);
	}

    public static void activerFenetreCouleur(String joueur) {
        try {
            FXMLLoader loader = new FXMLLoader(VueJeu.class.getResource("/iut/info1/application/vue/couleurPopup.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Choix de couleur - " + joueur);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du popup FXML : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
