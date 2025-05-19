/*
 * TestJoueur.java                                   19 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.application.Joueur;

/**
 * Cette classe permet de tester la classe Joueur.java
 * @author Esteban
 */
public class TestJoueur {

    private List<Joueur> joueurs;
    
    @BeforeEach
    void setUp() {
        joueurs = List.of(
                new Joueur(1, "Alice", "Rouge"),
                new Joueur(2, "Bob", "Jaune"),
                new Joueur(1, "Charlie", "Vert"),
                new Joueur(2, "David", "Bleu"),
                new Joueur(1, "Eve", "Orange"),
                new Joueur(2, "Frank", "Violet"),
                new Joueur(1, "Grace", "Rose"),
                new Joueur(2, "Heidi", "Cyan"),
                new Joueur(1, "Ivan", "Magenta"),
                new Joueur(2, "Judy", "Turquoise"));
    }
    
    @Test
    void testConstructeursValides() {
        for (Joueur joueur : joueurs) {
            assertNotNull(joueur);
            assertTrue(joueur.getId() == 1 || joueur.getId() == 2);
        }
    }
    
    @Test
    void testGetId() {
        for (int index = 0; index < joueurs.size(); index++) {
            Joueur joueur = joueurs.get(index);
            int idAttendu = index % 2 + 1;
            assertEquals(idAttendu, joueur.getId());
        }
    }
    
    @Test
    void testGetNom() {
        List<String> nomsAttendus = List.of(
                "Alice", "Bob", "Charlie", "David", "Eve",
                "Frank", "Grace", "Heidi", "Ivan", "Judy"
            );
        
        for (int index = 0; index < joueurs.size(); index++) {
            assertEquals(nomsAttendus.get(index), joueurs.get(index).getNom());
        }
    }
    
    @Test
    void testGetCouleur() {
        List<String> couleursAttendus = List.of(
                "Rouge", "Jaune", "Vert", "Bleu", "Orange",
                "Violet", "Rose", "Cyan","Magenta", "Turquoise");

        for (int index = 0; index < joueurs.size(); index++) {
            assertEquals(couleursAttendus.get(index),
                         joueurs.get(index).getCouleur());
        }
    }
    
    @Test
    void testNomInvalideVide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, "", "Rouge");
        });
    }
    
    @Test
    void testNomInvalideNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, null, "Rouge");
        });
    }
    
    @Test
    void testCouleurInvalideVide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, "Alice", "");
        });
    }

    @Test
    void testCouleurInvalideNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, "Alice", null);
        });
    }
    
    @Test
    void testNomLong() {
        String nomLong = "A".repeat(30);
        Joueur joueur = new Joueur(1, nomLong, "Rouge");
        assertEquals(nomLong, joueur.getNom());
    }
    
    @Test
    void testIdInvalide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(3, "Alice", "Rouge");
        });
    }
    
    @Test
    void testNomAvecEspaces() {
        Joueur joueur = new Joueur(1, "Jean Pierre", "Rouge");
        assertEquals("Jean Pierre", joueur.getNom());
    }
}