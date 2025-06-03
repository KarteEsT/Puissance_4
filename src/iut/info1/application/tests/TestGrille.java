/*
 * TestGrille.java                                   19 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import iut.info1.application.Grille;
import iut.info1.application.Joueur;

/**
 * Classe permettant de créer une Grille
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 * @version 1.0
 */
class TestGrille {

    /**
     * Test method for {@link iut.info1.application.Grille#Grille
     * (int, int, iut.info1.application.Joueur, iut.info1.application.Joueur)}.
     */
    @Test
    final void testGrille() {
        // Test de la création d'une grille avec des joueurs
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        
        Grille grille = new Grille(6, 7, j1, j2);
        assertEquals(6, grille.getLigne());
        assertEquals(7, grille.getColonne());
        assertNotNull(grille.getMatrice());
        assertEquals(0, grille.getCompteTour());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getLigne()}.
     */
    @Test
    final void testGetLigne() {
        
        // Test de la méthode getLigne
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");

       Grille grille = new Grille(6, 7, j1, j2);
       assertEquals(6, grille.getLigne());
       assertNotEquals(5, grille.getLigne());
       assertNotNull(grille.getLigne());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getColonne()}.
     */
    @Test
    final void testGetColonne() {
        
        // Test de la méthode getColonne
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        
        Grille grille = new Grille(6, 7,j1,j2);
        assertEquals(7, grille.getColonne());
        assertNotEquals(8, grille.getColonne());
        assertNotNull(grille.getColonne());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getJ1()}.
     */
    @Test
    final void testGetJ1() {
        
        // Test de la méthode getJ1
       Joueur j1 = new Joueur(1, "Joueur", "Jaune");
       Grille grille = new Grille(6, 7, j1, null);
       assertEquals(j1, grille.getJ1());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getJ2()}.
     */
    @Test
    final void testGetJ2() {
        
        // Test de la méthode getJ2
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        Grille grille = new Grille(6, 7, null, j2);
        assertEquals(j2, grille.getJ2());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getMatrice()}.
     */
    @Test
    final void testGetMatrice() {
        
        // Test de la méthode getMatrice
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        Grille grille = new Grille(6, 7, j1, j2);
        int[][] matrice = grille.getMatrice();
        assertNotNull(matrice);
        assertEquals(6, matrice.length);
        assertEquals(7, matrice[0].length);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                assertEquals(0, matrice[i][j]);
            }
        }
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getCompteTour()}.
     */
    @Test
    final void testGetCompteTour() {
        
        // Test de la méthode getCompteTour
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        
        Grille grille = new Grille(6, 7, j1, j2);
        assertEquals(0, grille.getCompteTour());
        grille.poserPion(0);
        assertEquals(1, grille.getCompteTour());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#poserPion(int)}.
     * Test de la méthode poserPion pour une position valide
     */
    @Test
    final void testPoserPionOk() {
        
        // Test de la méthode poserPion pour une position valide
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        
        Grille grille = new Grille(6, 7, j1, j2);
        
        grille.poserPion(3);
        
        assertTrue(grille.poserPion(3)!=-1);
        
        int[][] matrice = grille.getMatrice();
        assertEquals(1, matrice[5][3]);
        assertEquals(2, grille.getCompteTour());
    }
    
    /**
     * Test method for {@link iut.info1.application.Grille#poserPion(int)}.
     * Test de la méthode poserPion d'une position invalide (hors de la grille,
     * ou colonne pleine)
     */
    @Test
    final void testPoserPionKo() {
        
        // Test de la méthode poserPion d'une position invalide
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        
        Grille grille = new Grille(6, 7, j1, j2);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            grille.poserPion(-1); // Colonne invalide
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            grille.poserPion(7); // Colonne invalide
        });
        for (int i = 0; i < 10; i++) {
            grille.poserPion(3); 
            
        }
        assertFalse(grille.poserPion(3)!=-1);
    }
    
    /**
     * Test method for
     * {@link iut.info1.application.Grille#verifierVictoireVerticale()}.
     */
    @Test
    final void testVerifierVictoireVerticale() {
        
        // Test de la méthode verifierVictoireVerticale
        Joueur j1 = new Joueur(1,"Joueur","Jaune");
        Joueur j2 = new Joueur(2,"Joueur","Rouge");
        
        Grille grille = new Grille(6, 7, j1, j2);
        
        grille.poserPion(0);
        grille.poserPion(1);

        grille.poserPion(0);
        grille.poserPion(1);
        
        grille.poserPion(0);
        grille.poserPion(1);
        
        grille.poserPion(0);
        
        assertTrue(grille.verifierVictoireVerticale());
    }
    
    /**
     * Test method for {@link iut.info1.application.Grille#toString()}.
     */
    @Test
    final void testToString() {
        
        // Test de la méthode toString pour une grille vide
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");
        
        Grille grille = new Grille(6, 7, j1, j2);
        String expected = ("0 0 0 0 0 0 0 \n"
                + "0 0 0 0 0 0 0 \n"
                + "0 0 0 0 0 0 0 \n"
                + "0 0 0 0 0 0 0 \n"
                + "0 0 0 0 0 0 0 \n"
                + "0 0 0 0 0 0 0 \n");
        assertEquals(expected, grille.toString());
    }
    
    /**
     * Test method for
     * {@link iut.info1.application.Grille#verifierVictoireHorizontale()}.
     */
    @Test
    final void testVerifierVictoireHorizontale() {
        
        // Test de la méthode verifierVictoireHorizontale
        Joueur j1 = new Joueur(1,"Joueur","Jaune");
        Joueur j2 = new Joueur(2,"Joueur","Rouge");
        
        Grille grille = new Grille(6,7,j1,j2);
        
        /* Test victoire horizontale */
        
        grille.poserPion(0);
        grille.poserPion(0);
        
        grille.poserPion(1);
        grille.poserPion(1);
        
        grille.poserPion(2);
        grille.poserPion(2);
        
        grille.poserPion(3);
        
        assertTrue(grille.verifierVictoireHorizontale());

    }
    
    /**
     * Test method for
     * {@link iut.info1.application.Grille#verifierVictoireDiagonaleMontante()}.
     */
    @Test
    final void testVerifierVictoireDiagonaleMontante() {

        // Test de la méthode verifierVictoireDiagonaleMontante
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");

        Grille grille = new Grille(6, 7, j1, j2);

        /* Test victoire diagonale montante */

        grille.poserPion(0);
        grille.poserPion(1);
        
        grille.poserPion(1);
        grille.poserPion(2);
        
        grille.poserPion(2);
        grille.poserPion(3);
        
        grille.poserPion(3);
        grille.poserPion(3);
        
        grille.poserPion(2);
        grille.poserPion(1);
        
        grille.poserPion(3);
        
        assertTrue(grille.verifierVictoireDiagonaleMontante());
    }
    
    /**
     * Test method for
     * {@link iut.info1.application.Grille
     * #verifierVictoireDiagonaleDescendante()}.
     */
    @Test
    final void testVerifierVictoireDiagonaleDescendante() {

        // Test de la méthode verifierVictoireDiagonaleDescendante
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");

        Grille grille = new Grille(6, 7, j1, j2);

        /* Test victoire diagonale descendante */

        grille.poserPion(0);
        grille.poserPion(1);

        grille.poserPion(1);
        grille.poserPion(2);

        grille.poserPion(2);
        grille.poserPion(3);

        grille.poserPion(3);
        grille.poserPion(3);

        grille.poserPion(4);
        grille.poserPion(4);

        grille.poserPion(2);
        grille.poserPion(1);
        
        grille.poserPion(1);
        

        System.out.println(grille);
        assertTrue(grille.verifierVictoireDiagonaleDescendante());
    }
    
    
    /**
     * Test method for {@link iut.info1.application.Grille#isGrilleRemplie()}.
     */
    @Test
    final void testIsGrilleRemplie() {
        
        // Test de la méthode isGrilleRemplie
        Joueur j1 = new Joueur(1, "Joueur", "Jaune");
        Joueur j2 = new Joueur(2, "Joueur", "Rouge");

        Grille grille = new Grille(6, 7, j1, j2);

        // Remplissage de la grille
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                grille.poserPion(i);
            }
        }

        assertTrue(grille.isGrilleRemplie());
    }
    
}
