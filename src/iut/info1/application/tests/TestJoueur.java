/*
 * TestJoueur.java                                   19 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.application.Joueur;

/**
 * Cette classe permet de tester la classe Joueur.java.
 * @author Esteban
 */
public class TestJoueur {

    private Joueur joueur;
    
    @BeforeEach
    void setUp() {
        joueur = new Joueur(1, "Alice", "Rouge");
    }
    
    @Test
    void test() {
        
    }
    
    /**
     * Test de la méthode getId() de la classe Joueur.
     */
    @Test
    void testGetId() {
        assertEquals(1, joueur.getId());
    }
    
    /**
     * Test de la méthode getNom() de la classe Joueur.
     */
    @Test
    void testGetNom() {
        assertEquals("Alice", joueur.getNom());
    }
    
    /**
     * Test de la méthode getCouleur() de la classe Joueur.
     */
    @Test
    void testGetCouleur() {
        assertEquals("Rouge", joueur.getCouleur());
    }
}