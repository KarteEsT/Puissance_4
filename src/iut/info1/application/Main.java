/*
 * Main.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

import iut.info1.application.utils.NomsGlobals;
import iut.info1.application.utils.CouleursGlobales;

import java.util.Scanner;

/**
 * Main pour lancer l'application Puissance 4
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 * @version 1.0
 */
public class Main {
    
    /**
     * Lance l'application
     * @param args
     */
    public static void main(String[] args) {
        
//        Joueur j1 = new Joueur(1,"Joueur","Jaune");
//        Joueur j2 = new Joueur(2,"Joueur","Rouge");
//        
//        Grille grille = new Grille(6,7,j1,j2);
//        
//        
//        /* Test victoire verticale */
//        grille.poserPion(1);
//        grille.poserPion(0);
//        grille.poserPion(1);
//        grille.poserPion(0);
//        grille.poserPion(1);
//        grille.poserPion(0);
//        grille.poserPion(1);
//
//        System.out.println(grille.toString());
//        System.out.println(grille.verifierVictoireVerticale());
//        
//        /* Test victoire horizontale */
//        grille = new Grille(6,7,j1,j2);
//
//        grille.poserPion(1);
//        grille.poserPion(1);
//        
//        grille.poserPion(2);
//        grille.poserPion(2);
//        
//        grille.poserPion(3);
//        grille.poserPion(3);
//        
//        grille.poserPion(4);
//
//        System.out.println(grille.toString());
//        System.out.println(grille.verifierVictoireHorizontale());
//        
//        grille = new Grille(6,7,j1,j2);
//        grille.poserPion(5); 
//        grille.poserPion(0);
//        grille.poserPion(0);
//        
//        grille.poserPion(1);
//        grille.poserPion(1);
//        
//        grille.poserPion(2);
//        grille.poserPion(2);
//        
//        grille.poserPion(3);
//        System.out.println(grille.toString());
//        System.out.println(grille.verifierVictoireHorizontale());
//        
//        grille = new Grille(6,7,j1,j2);
//        Scanner entree = new Scanner(System.in);
//        do {
//        	System.out.println(grille);
//        	System.out.println("Où voulez-vous jouer : ");
//			if (!entree.hasNextInt()) {
//				System.out.println("Veuillez saisir un nombre entier");
//				entree.next();
//				continue;
//			} else {
//				int colonne = entree.nextInt();
//				try {
//					if (grille.poserPion(colonne-1)==-1) {
//						System.out.println("Colonne pleine, veuillez en choisir une autre.");
//						continue;
//					};
//					
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    System.out.println(e.getMessage());
//				}
//			}
//        } while (!grille.verifierVictoire() && !grille.isGrilleRemplie());
//        System.out.println(grille.isGrilleRemplie() ? "Le joueur n° " + ((grille.getCompteTour() - 1)%2  + 1)+ " a gagné !" : "grille pleine pas de gagnants");
//        System.out.println(grille);
//        
//        grille.reinitialiserGrille();
//        System.out.println(grille.toString());
//        
//        
    	Scanner scanner = new Scanner(System.in);

        try {
            // Création d'une grille pour le test
            Grille grilleTest = new Grille(6, 7, new Joueur(1, "Gabriel", "#FF0088"), new Joueur(2, "Esteban", "#00D1C7"));

            // Simuler quelques tours de jeu
            grilleTest.poserPion(0);
            grilleTest.poserPion(1);
            grilleTest.poserPion(0);
            grilleTest.poserPion(1);
            grilleTest.poserPion(0);

            // Afficher la grille avant sauvegarde
            System.out.println("Grille avant sauvegarde :");
            System.out.println(grilleTest);

            // Sauvegarder la grille
            System.out.print("Entrez le nom du fichier CSV pour sauvegarder la grille : ");
            String nomFichierSauvegarde = scanner.hasNextLine() ? scanner.nextLine() : "";

            System.out.print("Entrez l'emplacement pour sauvegarder le fichier CSV : ");
            String emplacementSauvegarde = scanner.hasNextLine() ? scanner.nextLine() : "";

            chargeurCSV.sauvegarderGrille(grilleTest, nomFichierSauvegarde, emplacementSauvegarde);

            // Charger la grille
            System.out.print("Entrez le nom du fichier CSV pour charger la grille : ");
            String nomFichierCharge = scanner.hasNextLine() ? scanner.nextLine() : "";

            System.out.print("Entrez l'emplacement pour charger le fichier CSV : ");
            String emplacementCharge = scanner.hasNextLine() ? scanner.nextLine() : "";

            Grille grilleChargee = chargeurCSV.chargerGrille(nomFichierCharge, emplacementCharge);

            // Récupérer les noms et couleurs des joueurs depuis les classes globales
            String nomJoueur1 = NomsGlobals.getNomJoueur1();
            String nomJoueur2 = NomsGlobals.getNomJoueur2();
            String couleurJoueur1 = CouleursGlobales.getCouleurJoueur1();
            String couleurJoueur2 = CouleursGlobales.getCouleurJoueur2();

            // Afficher les informations après chargement
            System.out.println("Noms des joueurs : " + nomJoueur1 + " / " + nomJoueur2);
            System.out.println("Couleurs des joueurs : " + couleurJoueur1 + " / " + couleurJoueur2);
            System.out.println("Grille après chargement :");
            System.out.println(grilleChargee);

            // Vérifier le joueur actif
            int joueurActif = (grilleChargee.getCompteTour() % 2) + 1;
            System.out.println("Joueur actif après chargement : Joueur " + joueurActif);

        } finally {
            scanner.close();
        }
        
    }

}
