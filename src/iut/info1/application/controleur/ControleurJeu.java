/*
 * ControleurJeu.java                                              16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.Grille;
import iut.info1.application.Joueur;
import iut.info1.application.utils.ChronosGlobales;
import iut.info1.application.utils.CouleursGlobales;
import iut.info1.application.VueJeu;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ButtonType;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur de la vue "fenetreJeu"
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ControleurJeu {

    /* Boolean de l'aide au joueur */
    private boolean aideJoueur;
	
    /* Chronomètre Global */
    @FXML private Label chronoGlobal;
	
    /* Labels pour afficher les noms des joueurs */
    @FXML private Label joueur1;
    @FXML private Label joueur2;

    /* ProgressBar pour afficher le temps restant pour chaque joueur */
    @FXML ProgressBar progressBar1;
    @FXML ProgressBar progressBar2;

    /* Cercle de la colonne A */
    @FXML private Circle A1;
    @FXML private Circle A2;
    @FXML private Circle A3;
    @FXML private Circle A4;
    @FXML private Circle A5;
    @FXML private Circle A6;

    /* Cercle de la colonne B */
    @FXML private Circle B1;
    @FXML private Circle B2;
    @FXML private Circle B3;
    @FXML private Circle B4;
    @FXML private Circle B5;
    @FXML private Circle B6;

    /* Cercle de la colonne C */
    @FXML private Circle C1;
    @FXML private Circle C2;
    @FXML private Circle C3;
    @FXML private Circle C4;
    @FXML private Circle C5;
    @FXML private Circle C6;

    /* Cercle de la colonne D */
    @FXML private Circle D1;
    @FXML private Circle D2;
    @FXML private Circle D3;
    @FXML private Circle D4;
    @FXML private Circle D5;
    @FXML private Circle D6;

    /* Cercle de la colonne E */
    @FXML private Circle E1;
    @FXML private Circle E2;
    @FXML private Circle E3;
    @FXML private Circle E4;
    @FXML private Circle E5;
    @FXML private Circle E6;

    /* Cercle de la colonne F */
    @FXML private Circle F1;
    @FXML private Circle F2;
    @FXML private Circle F3;
    @FXML private Circle F4;
    @FXML private Circle F5;
    @FXML private Circle F6;

    /* Cercle de la colonne G */
    @FXML private Circle G1;
    @FXML private Circle G2;
    @FXML private Circle G3;
    @FXML private Circle G4;
    @FXML private Circle G5;
    @FXML private Circle G6;

    /* Matrice des cercles */
    @FXML private Circle[][] matriceCercle = new Circle[7][6];

    /* Grille du jeu */
    private Grille grille;

    /* Couleurs du joueur n°1 */
    private String couleurJoueur1 = "red";
    /* Couleurs du joueur n°2 */
    private String couleurJoueur2 = "yellow";
    
    /* Chronomètre du joueur n°1 */
    private Timeline chronoJoueur1;
    /* Chronomètre du joueur n°2 */
    private Timeline chronoJoueur2;
    
    /* Durée totale du chronomètre */
    private double dureeTotaleParTour;
    /** Progression actuelle de la barre de progression */
    public static double progressionActuelle;
    
    /* Temps écoulé global en secondes */
    private int tempsEcouleGlobal = 0;
    /* Chronomètre global pour la partie */
    private Timeline chronoGlobalTimeline;
    
    /* Progression du joueur 1 au niveau du temps */
    private double progressionJoueur1 = 1.0;
    /* Progression du joueur 2 au niveau du temps */
    private double progressionJoueur2 = 1.0;

    /**
     * Méthode pour initialiser le jeu avec les joueurs et la grille
     */
    public void initialize() {
        
        int tempsChrono = ChronosGlobales.getTempsChrono();
        // Les barres de progression n'aparaissent pas au début
        progressBar1.setVisible(false);
        progressBar2.setVisible(false);

        // Arrêter les chronomètres s'ils existent
        if (chronoJoueur1 != null) {
            chronoJoueur1.stop();
            chronoJoueur1 = null;
        }
        if (chronoJoueur2 != null) {
            chronoJoueur2.stop();
            chronoJoueur2 = null;
        }
        
        Joueur j1 = new Joueur(1, joueur1.getText() , couleurJoueur1);
        Joueur j2 = new Joueur(2, joueur2.getText(), couleurJoueur2);

        grille = new Grille(6, 7, j1, j2);

        matriceCercle[0] = new Circle[] { A6, A5, A4, A3, A2, A1 }; 
        matriceCercle[1] = new Circle[] { B6, B5, B4, B3, B2, B1 };
        matriceCercle[2] = new Circle[] { C6, C5, C4, C3, C2, C1 };
        matriceCercle[3] = new Circle[] { D6, D5, D4, D3, D2, D1 };
        matriceCercle[4] = new Circle[] { E6, E5, E4, E3, E2, E1 };
        matriceCercle[5] = new Circle[] { F6, F5, F4, F3, F2, F1 };
        matriceCercle[6] = new Circle[] { G6, G5, G4, G3, G2, G1 };
        
        couleurJoueur1 = CouleursGlobales.getCouleurJoueur1();
        couleurJoueur2 = CouleursGlobales.getCouleurJoueur2();
        mettreAJourCouleur(couleurJoueur1, couleurJoueur2);
        configurerPrevisualisation();
    }
    
    /**
     * Méthode pour mettre à jour la grille en fonction de la position du pion
     * @param ligne ligne du cercle à mettre à jour
     * @param colonne colonne du cercle à mettre à jour
     */
    public void mettreAJourGrille(int ligne, int colonne) {
        Circle cercle = matriceCercle[colonne][ligne];
        int joueurId = grille.getMatrice()[ligne][colonne];

        String couleur = (joueurId == 1) ? couleurJoueur1 : couleurJoueur2;
        cercle.setFill(javafx.scene.paint.Color.web(couleur));
    }

    /**
     * Méthode pour mettre à jour les labels des joueurs
     * @param nomJoueur1 nom du joueur 1
     * @param nomJoueur2 nom du joueur 2
     */
    public void mettreAJourLabels(String nomJoueur1, String nomJoueur2) {
        joueur1.setText(nomJoueur1);
        joueur2.setText(nomJoueur2);
    }
    
    /**
     * Met à jour les couleurs des boutons de sélection
     * @param couleur1 
     * @param couleur2 
     */
    public void mettreAJourCouleur(String couleur1, String couleur2) {
        if (couleur1 != null) {
            joueur1.setStyle("-fx-background-color: " + couleur1 + ";");
            progressBar1.setStyle("-fx-accent: " + couleur1 + ";");
            couleurJoueur1 = couleur1;
        }
        if (couleur2 != null) {
            joueur2.setStyle("-fx-background-color: " + couleur2 + ";");
            progressBar2.setStyle("-fx-accent: " + couleur2 + ";");
            couleurJoueur2 = couleur2;
        }
    }
    
    /**
     * Méthode pour démarrer la barre de progression pour un joueur
     * @param progressBar la barre de progression à démarrer
     * @return un objet Timeline qui gère la progression de la barre
     */
    public Timeline demarrerBarreDeProgression(ProgressBar progressBar) {
        final double intervalle = 0.1;  // Intervalle en secondes
        final double decrement = intervalle / dureeTotaleParTour;

        int joueurPerdant = (grille.getCompteTour() % 2 == 0) ? 1 : 2;
        String nomPerdant = (joueurPerdant == 1) ? joueur1.getText()
                                                 : joueur2.getText();

        progressBar.setProgress(1.0); // Initialiser la barre à pleine capacité

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
            new KeyFrame(Duration.seconds(intervalle), event -> {

                progressionActuelle = progressBar.getProgress();
                if (progressionActuelle > 0) {
                    progressBar.setProgress(progressionActuelle - decrement);
                } else if (progressionActuelle <= 0) {
                    // Si la barre est vide, afficher une alerte
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Temps écoulé !");
                        alert.setContentText(nomPerdant
                                       + " a perdu car son temps est écoulé !");

                        ButtonType relancer = new ButtonType("Relancer");
                        ButtonType quitter = new ButtonType("Quitter");
                        alert.getButtonTypes().clear(); //Efface boutons de base
                        alert.getButtonTypes().addAll(relancer, quitter);
                        Optional<ButtonType> option = alert.showAndWait();
                        if (option.isPresent() && option.get() == relancer) {
                            // Réinitialiser la grille et les cercles
                            grille.reinitialiserGrille();
                            changementChrono(); // Relance le chrono pour le j1
                        } else if (option.isPresent() &&
                                   option.get() == quitter) {
                            Platform.exit(); // Quitter l'application
                        }
                    });
                    timeline.stop(); // Arrêter la timeline
                }
            })
        );

        timeline.setCycleCount(Timeline.INDEFINITE); // Répéter indéfiniment
        timeline.play();
        return timeline;
    }
    
    /**
     * Méthodes pour activer la colonne 1
     */
    @FXML
    public void activerColonne1() {
        int ligne = grille.poserPion(0);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 0);
            verifierFinDePartie();
            changementChrono();
            if (grille.getCompteTour() == 1) {
                demarrerChronoGlobal();
            }
            if (aideJoueur) {
            	mettreAJourPionAide();
            }
        }
    }

    /**
     * Méthodes pour activer la colonne 2
     */
    @FXML
    public void activerColonne2() {
        int ligne = grille.poserPion(1);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 1); 
            verifierFinDePartie();
            changementChrono();
            if (grille.getCompteTour() == 1) {
                demarrerChronoGlobal();
            }
            if (aideJoueur) {
            	mettreAJourPionAide();
            }
        }
    }

    /**
     * Méthodes pour activer la colonne 3
     */
    @FXML
    public void activerColonne3() {
        int ligne = grille.poserPion(2);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 2);
            verifierFinDePartie();
            changementChrono();
            if (grille.getCompteTour() == 1) {
                demarrerChronoGlobal();
            }
            if (aideJoueur) {
            	mettreAJourPionAide();
            }
        }
    }

    /**
     * Méthodes pour activer la colonne 4
     */
    @FXML
    public void activerColonne4() {
        int ligne = grille.poserPion(3);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 3);
            verifierFinDePartie();
            changementChrono();
            if (grille.getCompteTour() == 1) {
                demarrerChronoGlobal();
            }
            if (aideJoueur) {
            	mettreAJourPionAide();
            }
        }
    }

    /**
     * Méthodes pour activer la colonne 5
     */
    @FXML
    public void activerColonne5() {
        int ligne = grille.poserPion(4);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 4);
            verifierFinDePartie();
            changementChrono();
            if (grille.getCompteTour() == 1) {
                demarrerChronoGlobal();
            }
            if (aideJoueur) {
            	mettreAJourPionAide();
            }
        }
    }
    
    /**
     * Méthodes pour activer la colonne 6
     */
    @FXML
    public void activerColonne6() {
        int ligne = grille.poserPion(5);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 5);
            verifierFinDePartie();
            changementChrono();
            if (grille.getCompteTour() == 1) {
                demarrerChronoGlobal();
            }
            if (aideJoueur) {
            	mettreAJourPionAide();
            }
        }
    }

    /**
     * Méthodes pour activer la colonne 7
     */
    @FXML
    public void activerColonne7() {
        int ligne = grille.poserPion(6);
        if (ligne != -1) {
            mettreAJourGrille(ligne, 6);
            verifierFinDePartie();
            changementChrono();
            if (grille.getCompteTour() == 1) {
                demarrerChronoGlobal();
            }
            if (aideJoueur) {
            	mettreAJourPionAide();
            }
        }
    }
    
        /**
         * Méthode pour configurer la prévisualisation des cercles
         * lorsqu'on survole une colonne.
         */
    private void configurerPrevisualisation() {
        for (int colonne = 0; colonne < matriceCercle.length; colonne++) {
            for (int ligne = 0; ligne < matriceCercle[colonne].length; ligne++){
                final int colonneFinale = colonne; // Capturer la colonne
                Circle cercle = matriceCercle[colonne][ligne];

                cercle.setOnMouseEntered(event -> {
                    // Trouver la première ligne vide dans la colonne
                    int ligneDisponible = -1;
                    for (int i = grille.getLigne() - 1; i >= 0; i--) {
                        if (grille.getMatrice()[i][colonneFinale] == 0) {
                            ligneDisponible = i;
                            break;
                        }
                    }

                    // Si une ligne est disponible, afficher la prévisualisation
                    if (ligneDisponible != -1) {
                        Circle cerclePrevisualisation
                                = matriceCercle[colonneFinale][ligneDisponible];
                        String couleur = (grille.getCompteTour() % 2 == 0)
                                          ? couleurJoueur1
                                          : couleurJoueur2;
                        cerclePrevisualisation.setFill(javafx.scene.paint.
                                                       Color.web(couleur, 0.8));
                    }
                });

                cercle.setOnMouseExited(event -> {
                    // Réinitialiser la couleur des cercles dans la colonne
                    for (int i = 0; i < grille.getLigne(); i++) {
                        if (grille.getMatrice()[i][colonneFinale] == 0) {
                            matriceCercle[colonneFinale][i].setFill(javafx.
                                                scene.paint.Color.web("white"));
                        }
                    }
                });
            }
        }
    }
    
    /**
     * Méthode pour afficher les jetons alignés en cas de victoire.
     * @param jetonsAlignes Liste des positions des jetons alignés
     */
    private void afficherJetonsAlignes(List<int[]> jetonsAlignes) {
        for (int[] position : jetonsAlignes) {
            int ligne = position[0];
            int colonne = position[1];
            Circle cercle = matriceCercle[colonne][ligne];
            cercle.setStroke(javafx.scene.paint.Color.web("white"));
            cercle.setStrokeWidth(3);
        }
    }
    
	/**
	 * Méthode pour réinitialiser le jeu en cas de relance. 
	 * Réinitialise la
	 * grille, les cercles et les chronomètres.
	 */
    public void reinitialiserJeu() {
    	List<int[]> jetonsAlignes = grille.verifierVictoire();

    	grille.reinitialiserGrille();
        jetonsAlignes.clear();
        
        for (Circle[] colonne : matriceCercle) {
            for (Circle cercle : colonne) {
                cercle.setFill(javafx.scene.paint.Color.web("white"));
                cercle.setStroke(javafx.scene.paint.Color.web("black"));
                cercle.setStrokeWidth(1);
            }
        }
        
        
        // Relancer le chrono pour le joueur 1 (début de partie)
        changementChrono();
    }
    
    /**
     * Méthode pour vérifier si la partie est terminée et afficher une alerte en
     * conséquence.
     */
    private void verifierFinDePartie() {
        List<int[]> jetonsAlignes = grille.verifierVictoire();
        if (!jetonsAlignes.isEmpty()) {
            
            // Arrêter les chronomètres
            if (chronoJoueur1 != null) chronoJoueur1.stop();
            if (chronoJoueur2 != null) chronoJoueur2.stop();
            arreterChronoGlobal();
            
            int gagnant = (grille.getCompteTour() - 1) % 2 + 1;
            String nomGagnant = (gagnant == 1) ? joueur1.getText() 
                                                : joueur2.getText();
            
            afficherJetonsAlignes(jetonsAlignes);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Victoire !");
            alert.setTitle("Partie terminée !");
            
            ButtonType menuPrincipal = new ButtonType("Menu principal");
            ButtonType relancer = new ButtonType("Relancer");
            ButtonType quitter = new ButtonType("Quitter");
            
            alert.setContentText(nomGagnant + " a gagné !");
            
            alert.getButtonTypes().clear(); // Efface les boutons par défaut
            alert.getButtonTypes().addAll(menuPrincipal, relancer, quitter);
            
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get() == relancer) {
                reinitialiserJeu();
            }
            if (option.get() == quitter) {
                Platform.exit();
            }
            if (option.get() == menuPrincipal) {
            	reinitialiserJeu();
                VueJeu.activerFenetreMenu();
            }
            
            // Optionnel : désactiver les boutons ou relancer
        } else if (grille.isGrilleRemplie()) {
            
            arreterChronoGlobal();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Égalité !");
            alert.setTitle("Partie terminée !");
            
            ButtonType menuPrincipal = new ButtonType("Menu principal");
            ButtonType relancer = new ButtonType("Relancer");
            ButtonType quitter = new ButtonType("Quitter");
            
            alert.setContentText("La grille est pleine. Match nul !");
            
            alert.getButtonTypes().clear(); // Efface les boutons par défaut
            alert.getButtonTypes().addAll(menuPrincipal, relancer, quitter);
            
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get() == relancer) {
                reinitialiserJeu();
            }
            if (option.get() == menuPrincipal) {
            	reinitialiserJeu();
                VueJeu.activerFenetreMenu();
            }
            if (option.get() == quitter) {
                Platform.exit();
            }
        }
    }
    
    /**
     * Méthode appelée lors du clic sur le bouton "Options"
     * pour ouvrir les options du jeu.
     */
    @FXML
    public void gererClicOption() {
        mettreEnPauseChronos();
        Grille.setInstance(grille);
        VueJeu.activerFenetreOption();
    }

    /**
     * Méthode pour mettre à jour la matrice de la grille avec les 
     * valeurs fournies
     * @param matrice la matrice utilisée pour mettre à jour
     * 			la grille
     */
    public void mettreAJourMatrice(int[][] matrice) {
    	for (int i = 0; i < matrice.length; i++) {
    		for (int j = 0; j < matrice[i].length; j++) {
    			grille.getMatrice()[i][j] = matrice[i][j];
    			if (matrice[i][j] != 0) {
    				mettreAJourGrille(i, j);
    			}
    		}
    	}
    }

    /**
     * Méthode pour mettre à jour le compte de tours
     * 
     * @param compteTour le compte de tours à mettre à jour
     */
    public void mettreAJourCompteTour(int compteTour) {
    	grille.setCompteTour(compteTour);

    }

    /**
     * Permet de lancer la vue des règles
     */
    public void gererClicInfo() {       
        VueJeu.activerFenetreRegles();
    }
    
    /**
     * Arrêter le chrono du joueur actuel et
     * démarrer celui du joueur suivant ainsi que
     * réinitialiser la barre de progression
     */
    public void changementChrono() {
        // Arrêter les deux chronos s'ils existent
        if (chronoJoueur1 != null) {
            chronoJoueur1.stop();
            chronoJoueur1 = null;
        }
        if (chronoJoueur2 != null) {
            chronoJoueur2.stop();
            chronoJoueur2 = null;
        }

        // Réinitialiser les barres de progression
        progressBar1.setProgress(1.0);
        progressBar2.setProgress(1.0);

        /**
         *  Démarrer le chrono uniquement si un pion a été posé
         *  ET si la durée est > 0
         */
        if (grille.getCompteTour() > 0 && this.dureeTotaleParTour > 0) {
            if (grille.getCompteTour() % 2 == 0) {
                chronoJoueur1 = demarrerBarreDeProgression(progressBar1);
            } else {
                chronoJoueur2 = demarrerBarreDeProgression(progressBar2);
            }
        }
    }
    
    /**
     * @return la durée totale du chronomètre
     */
    public double getDureeTotaleParTour() {
        return dureeTotaleParTour;
    }

    /**
     * Permet de définir la durée totale du chronomètre.
     * @param duree la durée totale à définir
     */
    public void setDureeTotaleParTour(double duree) {
        this.dureeTotaleParTour = duree;
    }
    
    /**
     * Permet de définir le chronomètre pour le joueur 1.
     * @param chrono le chronomètre à définir pour le joueur 1
     */
    public void setChronoJoueur1(Timeline chrono) {
        this.chronoJoueur1 = chrono;
    }

    /**
     * Permet de définir le chronomètre pour le joueur 2.
     * @param chrono le chronomètre à définir pour le joueur 2
     */
    public void setChronoJoueur2(Timeline chrono) {
        this.chronoJoueur2 = chrono;
    }
    
    /**
     * @return le chronomètre du joueur 1
     */
    public Timeline getChronoJoueur1() {
        return chronoJoueur1;
    }

    /**
     * @return le chronomètre du joueur 2
     */
    public Timeline getChronoJoueur2() {
        return chronoJoueur2;
    }
    
    /**
     * Mettre à jour le chronomètre de la partie selon le choix de l'utilisateur
     * @param booleanChrono true si chrono actif false sinon
     */
    public void mettreAJourChronoGlobal(boolean booleanChrono) {
    	chronoGlobal.setVisible(booleanChrono);
    }
    
    /**
     * Met à jour la matrice avec le pion d'aide
     */
    public void mettreAJourPionAide() {

    	int[] coordonneesAide = grille.aideVerifierVictoire();
        if (coordonneesAide != null) {
	        int ligne = coordonneesAide[0];
	        int colonne = coordonneesAide[1];
	        Circle cercleAide = matriceCercle[colonne][ligne];
	        cercleAide.setStroke(javafx.scene.paint.Color.web("white"));
            cercleAide.setStrokeWidth(5);
        } else {
        	for (int colonne = 0;colonne < matriceCercle.length;colonne++) {
                for (int ligne = 0; ligne < matriceCercle[colonne].length;
                                                                   ligne++) {
                    if (grille.getMatrice()[ligne][colonne] == 0) {
                        matriceCercle[colonne][ligne].setStroke(javafx.
                                                scene.paint.Color.web("black"));
                        matriceCercle[colonne][ligne].setStrokeWidth(1);
                    }
                }
            }
        }
    }
    
    
    /**
     * Méthode pour visualisé les pions de la méthode Aide
     * @param aideJoueur Boolean pour savoir si l'utilisateur active ou
     * désactive l'aide au joueur
     */
    public void mettreAJourAide(boolean aideJoueur) {
    	this.aideJoueur = aideJoueur;
    }
    
    /**
     * Démarre le chronomètre global pour la partie.
     */
    public void demarrerChronoGlobal() {
        // Arrêter le chrono global s'il existe déjà
        if (chronoGlobalTimeline != null) {
            chronoGlobalTimeline.stop();
        }

        // Initialiser le temps écoulé
        tempsEcouleGlobal = 0;

        // Créer un Timeline pour incrémenter le temps chaque seconde
        chronoGlobalTimeline = new Timeline(new KeyFrame(Duration.seconds(1),
                                                                    event -> {
            tempsEcouleGlobal++;
            Platform.runLater(() -> {
                int minutes = tempsEcouleGlobal / 60;
                int secondes = tempsEcouleGlobal % 60;
                chronoGlobal.setText(String.
                                     format("%02d:%02d", minutes, secondes));
            });
        }));

        chronoGlobalTimeline.setCycleCount(Timeline.INDEFINITE);
        chronoGlobalTimeline.play();
    }

    /**
     * Arrête le chronomètre global pour la partie.
     */
    public void arreterChronoGlobal() {
        if (chronoGlobalTimeline != null) {
            chronoGlobalTimeline.stop();
        }
    }
    
    /**
     * Met en pause tous les chronomètres de la partie.
     */
    public void mettreEnPauseChronos() {
        // Sauvegarder l'état actuel des barres de progression
        if (progressBar1 != null) {
            progressionJoueur1 = progressBar1.getProgress();
        }
        if (progressBar2 != null) {
            progressionJoueur2 = progressBar2.getProgress();
        }

        // Mettre en pause les chronomètres des joueurs
        if (chronoJoueur1 != null) {
            chronoJoueur1.pause();
        }
        if (chronoJoueur2 != null) {
            chronoJoueur2.pause();
        }

        // Mettre en pause le chronomètre global
        if (chronoGlobalTimeline != null) {
            chronoGlobalTimeline.pause();
        }
    }
    
    /**
     * Reprendre les chronomètres de la partie après une pause.
     */
    public void reprendreChronos() {
        // Restaurer l'état des barres de progression
        if (progressBar1 != null) {
            progressBar1.setProgress(progressionJoueur1);
        }
        if (progressBar2 != null) {
            progressBar2.setProgress(progressionJoueur2);
        }

        // Reprendre les chronomètres des joueurs
        if (chronoJoueur1 != null) {
            chronoJoueur1.play();
        }
        if (chronoJoueur2 != null) {
            chronoJoueur2.play();
        }

        // Reprendre le chronomètre global
        if (chronoGlobalTimeline != null) {
            chronoGlobalTimeline.play();
        }
    }
    
}