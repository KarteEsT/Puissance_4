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
     * Test method for {@link iut.info1.application.Grille#Grille(int, int, iut.info1.application.Joueur, iut.info1.application.Joueur)}.
     */
    @Test
    final void testGrille() {
        Grille grille = new Grille(6, 7);
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
       Grille grille = new Grille(6, 7);
       assertEquals(6, grille.getLigne());
       assertNotEquals(5, grille.getLigne());
       assertNotNull(grille.getLigne());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getColonne()}.
     */
    @Test
    final void testGetColonne() {
        Grille grille = new Grille(6, 7);
        assertEquals(7, grille.getColonne());
        assertNotEquals(8, grille.getColonne());
        assertNotNull(grille.getColonne());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getJ1()}.
     */
    @Test
    final void testGetJ1() {
       Joueur j1 = new Joueur(1, "Joueur 1", "Jaune");
       Grille grille = new Grille(6, 7, j1, null);
       assertEquals(j1, grille.getJ1());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getJ2()}.
     */
    @Test
    final void testGetJ2() {
        Joueur j2 = new Joueur(2, "Joueur 2", "Rouge");
        Grille grille = new Grille(6, 7, null, j2);
        assertEquals(j2, grille.getJ2());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getMatrice()}.
     */
    @Test
    final void testGetMatrice() {
        Grille grille = new Grille(6, 7);
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
        Grille grille = new Grille(6, 7);
        assertEquals(0, grille.getCompteTour());
        grille.poserPion(3);
        assertEquals(1, grille.getCompteTour());
        grille.poserPion(4);
        assertEquals(2, grille.getCompteTour());
    }

    /**
     * Test method for {@link iut.info1.application.Grille#poserPion(int)}.
     * Test de la méthode poserPion pour une position valide
     */
    @Test
    final void testPoserPionOk() {
        Grille grille = new Grille(6, 7);
        
        assertTrue(grille.poserPion(3));
        int[][] matrice = grille.getMatrice();
        assertEquals(1, matrice[5][3]); // Le pion doit être placé en bas de la colonne
        

        assertTrue(grille.poserPion(3));
        assertEquals(2, matrice[4][3]); // Le pion doit être placé juste au-dessus

        assertTrue(grille.poserPion(4));
        assertEquals(1, matrice[5][4]); // Le pion doit être placé dans une autre colonne
    }
    
    /**
     * Test method for {@link iut.info1.application.Grille#poserPion(int)}.
     * Test de la méthode poserPion pour une position invalide (hors de la grille,
     * ou colonne pleine)
     */
    @Test
    final void testPoserPionKo() {
        Grille grille = new Grille(6, 7);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            grille.poserPion(-1); // Colonne invalide
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            grille.poserPion(7); // Colonne invalide
        });
        for (int i = 0; i < 6; i++) {
            grille.poserPion(3); // Remplir la colonne
        }
        assertFalse(grille.poserPion(3)); // Colonne pleine
    }
    
    /**
     * Test method for
     * {@link iut.info1.application.Grille#verifierVictoireVerticale()}.
     */
    @Test
    final void testVerifierVictoireVerticale() {
        Grille grille = new Grille(6, 7);
        // Remplir une colonne avec 4 pions du même joueur
        grille.poserPion(3);
        grille.poserPion(3);
        grille.poserPion(3);
        grille.poserPion(3);

        assertTrue(grille.verifierVictoireVerticale());

        // Remplir une colonne sans victoire
        grille = new Grille(6, 7);
        grille.poserPion(3);
        grille.poserPion(3);
        grille.poserPion(4);
        grille.poserPion(4);

        assertFalse(grille.verifierVictoireVerticale());
    }
}
