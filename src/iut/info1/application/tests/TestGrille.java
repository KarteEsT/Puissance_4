/*
 * TestGrille.java                                   19 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import iut.info1.application.Grille;

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
       fail("Not yet implemented");
    }

    /**
     * Test method for {@link iut.info1.application.Grille#getJ2()}.
     */
    @Test
    final void testGetJ2() {
        fail("Not yet implemented");
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
     */
    @Test
    final void testPoserPion() {
        fail("Not yet implemented");
    }

}
