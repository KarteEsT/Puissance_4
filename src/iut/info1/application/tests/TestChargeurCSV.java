package iut.info1.application.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import iut.info1.application.ChargeurCSV;
import iut.info1.application.Grille;
import iut.info1.application.Joueur;
import iut.info1.application.utils.NomsGlobals;

class TestChargeurCSV {

	@Test
    void testChargerGrille() {
        try {
            // Chemin vers un fichier CSV de test
            String chemin = "src/test/ressources";
            String nomFichier = "grilleTest.csv";

            // Appel de la méthode à tester
            Grille grille = ChargeurCSV.chargerGrille(nomFichier, chemin);

            // Vérifications
            assertNotNull(grille, "La grille ne doit pas être null après le chargement.");
            assertEquals(7, grille.getColonne(), "La largeur de la grille doit être correcte.");
            assertEquals(6, grille.getLigne(), "La hauteur de la grille doit être correcte.");
            assertEquals("Alice", grille.getJ1().getNom(), "Le nom du joueur 1 doit être correct.");
            assertEquals("Bob", grille.getJ2().getNom(), "Le nom du joueur 2 doit être correct.");
            assertEquals("#FF0000", grille.getJ1().getCouleur(), "La couleur du joueur 1 doit être correcte.");
            assertEquals("#FFFF00", grille.getJ2().getCouleur(), "La couleur du joueur 2 doit être correcte.");
            assertEquals(0, grille.getCompteTour(), "Le compteTour doit être correct.");
        } catch (Exception e) {
            fail("Une exception a été levée lors du chargement de la grille : " + e.getMessage());
        }
    }

    @Test
    void testSauvegarderGrille() {
        try {
            // Création d'une grille de test
        	Joueur joueur1 = new Joueur(1, "Alice", "red");
        	Joueur joueur2 = new Joueur(2, "Bob", "yellow");
        	NomsGlobals.setNomJoueur1(joueur1.getNom());
        	NomsGlobals.setNomJoueur2(joueur2.getNom());
            Grille grille = new Grille(6, 7, joueur1, joueur2);

            // Chemin et nom du fichier de sauvegarde
            String chemin = "src/test/ressources";
            String nomFichier = "grilleSauvegarde.csv";

            // Appel de la méthode à tester
            ChargeurCSV.sauvegarderGrille(grille, nomFichier, chemin);

            // Vérifications
            File fichierSauvegarde = new File(chemin + File.separator + nomFichier);
            assertTrue(fichierSauvegarde.exists(), "Le fichier de sauvegarde doit exister.");
            assertTrue(fichierSauvegarde.length() > 0, "Le fichier de sauvegarde ne doit pas être vide.");
        } catch (Exception e) {
            fail("Une exception a été levée lors de la sauvegarde de la grille : " + e.getMessage());
        }
    }

}
