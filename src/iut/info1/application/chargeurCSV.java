/*
 * chargeurCSV.java                                                 3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application;

import iut.info1.application.utils.NomsGlobals;
import iut.info1.application.utils.CouleursGlobales;
import iut.info1.application.controleur.ControleurJeu;
import iut.info1.application.Grille;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Permet de sauvegarder et de charger des grilles depuis un fichier CSV
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class chargeurCSV {

	/**
     * Charge une grille depuis un fichier CSV
     *
     * @param nomFichier le nom du fichier CSV
     * @param emplacement l'emplacement du fichier CSV
     * @return la grille chargée
     */
	public static Grille chargerGrille(String nomFichier, String emplacement) {
	    try (BufferedReader reader = 
	                new BufferedReader(new FileReader(emplacement + 
	                File.separator + nomFichier))) {
	        // Lire les noms des joueurs
	        String nomJoueur1 = reader.readLine();
	        String nomJoueur2 = reader.readLine();
	        NomsGlobals.setNomJoueur1(nomJoueur1);
	        NomsGlobals.setNomJoueur2(nomJoueur2);

	        // Lire les couleurs des joueurs
	        String couleurJoueur1 = reader.readLine();
	        String couleurJoueur2 = reader.readLine();
	        CouleursGlobales.setCouleurJoueur1(couleurJoueur1);
	        CouleursGlobales.setCouleurJoueur2(couleurJoueur2);

	        // Lire la matrice de la grille
	        List<int[]> matrice = new ArrayList<>();
	        String ligne;
	        while ((ligne = reader.readLine()) != null && !ligne.startsWith("compteTour")) {
	            String[] valeurs = ligne.split(",");
	            int[] ligneMatrice = new int[valeurs.length];
	            for (int i = 0; i < valeurs.length; i++) {
	                ligneMatrice[i] = Integer.parseInt(valeurs[i]);
	            }
	            matrice.add(ligneMatrice);
	        }

	        // Lire le compteTour
	        int compteTour = Integer.parseInt(ligne.split(":")[1].trim());

	        // Créer une grille avec les données chargées
	        int[][] matriceFinale = matrice.toArray(new int[0][]);
	        Grille grille = new Grille(matriceFinale.length, matriceFinale[0].length,
	                                   new Joueur(1, nomJoueur1, couleurJoueur1),
	                                   new Joueur(2, nomJoueur2, couleurJoueur2));

	        // Mettre à jour la matrice et le compteTour de la grille
	        int[][] matriceGrille = grille.getMatrice();
	        for (int i = 0; i < matriceFinale.length; i++) {
	            System.arraycopy(matriceFinale[i], 0, matriceGrille[i], 0, matriceFinale[i].length);
	        }
	        grille.setCompteTour(compteTour);

	        // Mettre à jour l'instance globale de la grille
	        Grille.setInstance(grille);

	        return grille;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

    /**
     * Sauvegarde une grille dans un fichier CSV
     *
     * @param grille     la grille à sauvegarder
     * @param nomFichier le nom du fichier CSV
     * @param emplacement l'emplacement pour sauvegarder le fichier CSV
     */
    public static void sauvegarderGrille(Grille grille, String nomFichier, String emplacement) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(emplacement + File.separator + nomFichier))) {
            // Écrire les noms des joueurs
            writer.write(NomsGlobals.getNomJoueur1());
            writer.newLine();
            writer.write(NomsGlobals.getNomJoueur2());
            writer.newLine();

            // Écrire les couleurs des joueurs
            writer.write(CouleursGlobales.getCouleurJoueur1());
            writer.newLine();
            writer.write(CouleursGlobales.getCouleurJoueur2());
            writer.newLine();

            // Écrire la matrice de la grille
            int[][] matrice = grille.getMatrice();
            for (int[] ligne : matrice) {
                for (int i = 0; i < ligne.length; i++) {
                    writer.write(String.valueOf(ligne[i]));
                    if (i < ligne.length - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }

            // Écrire le compteTour
            writer.write("compteTour:" + grille.getCompteTour());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}