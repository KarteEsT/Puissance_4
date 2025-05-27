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
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 * @version 1.0
 */
public class TestJoueur {

    private List<Joueur> joueursValides;
    
    @BeforeEach
    void setUp() {
        joueursValides = List.of(
                new Joueur(1, "Alice", "Rouge"),
                new Joueur(2, "Bob", "Jaune"),
                new Joueur(1, "Charlie", "Vert"),
                new Joueur(2, "David", "Bleu"),
                new Joueur(1, "Eve", "Orange"),
                new Joueur(2, "Frank", "Violet"),
                new Joueur(1, "Grace", "Rose"),
                new Joueur(2, "Heidi", "Cyan"),
                new Joueur(1, "Ivan", "Magenta"),
                new Joueur(2, "Judy", "Turquoise"),
                new Joueur(1, "Karl", "Blanc"),
                new Joueur(2, "Laura", "Noir"),
                new Joueur(1, "Mike", "Gris"),
                new Joueur(2, "Nina", "Doré"),
                new Joueur(1, "Oscar", "Argent"),
                new Joueur(2, "Paul", "Marron"),
                new Joueur(1, "Quentin", "Beige"),
                new Joueur(2, "Rachel", "Bordeaux"),
                new Joueur(1, "Steve", "Olive"),
                new Joueur(2, "Tina", "Lavande"),
                new Joueur(1, "Uma", "Sable"),
                new Joueur(2, "Victor", "Émeraude"),
                new Joueur(1, "Wendy", "Azur"),
                new Joueur(2, "Xavier", "Indigo"),
                new Joueur(1, "Yasmine", "Saumon"),
                new Joueur(2, "Zack", "Fuchsia"));
    }
    
    @Test
    void testConstructeursValides() {
        for (Joueur joueur : joueursValides) {
            assertNotNull(joueur);
            assertTrue(joueur.getId() == 1 || joueur.getId() == 2);
        }
    }
    

    @Test
    void testConstructeursInvalides() {
        // Id invalides
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(3, "Alice", "Rouge"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(0, "Bob", "Jaune"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(-1, "Charlie", "Vert"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(100, "David", "Bleu"));
        
        // Nom vide, null, uniquement espaces
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "", "Orange"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(2, null, "Violet"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "   ", "Rose"));
        
        // Nom avec caractères invalides
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(2, "@lice", "Cyan"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(2, "Al!ce", "Vert"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "Bob#", "Bleu"));
        
        // Nom trop long (> 30)
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "A".repeat(31), "Magenta"));
        
        // Couleur vide, null, uniquement espaces
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "Charlie", ""));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(2, "David", null));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "Eve", "   "));
        
        // Couleur avec caractères invalides
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(2, "Frank", "@blue"));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "Grace", "Bl@ck"));
        
        // Couleur trop longue (> 30)
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(2, "Grace", "B".repeat(31)));
        
        // Combinaison nom et couleur invalides
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "", ""));
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(2, null, null));
        
        // Nom et couleur avec uniquement espaces
        assertThrows(IllegalArgumentException.class, () 
                -> new Joueur(1, "   ", "   "));
    }

    
    @Test
    void testGetId() {
        for (int index = 0; index < joueursValides.size(); index++) {
            Joueur joueur = joueursValides.get(index);
            int idAttendu = index % 2 + 1;
            assertEquals(idAttendu, joueur.getId());
        }
    }
    
    @Test
    void testGetNom() {
        List<String> nomsAttendus = List.of(
                "Alice", "Bob", "Charlie", "David", "Eve",
                "Frank", "Grace", "Heidi", "Ivan", "Judy",
                "Karl", "Laura", "Mike", "Nina", "Oscar",
                "Paul", "Quentin", "Rachel", "Steve", "Tina",
                "Uma", "Victor", "Wendy", "Xavier", "Yasmine", "Zack"
        );
        
        for (int index = 0; index < joueursValides.size(); index++) {
            assertEquals(nomsAttendus.get(index), joueursValides.get(index).getNom());
        }
    }
    
    @Test
    void testGetCouleur() {
        List<String> couleursAttendus = List.of(
                "Rouge", "Jaune", "Vert", "Bleu", "Orange",
                "Violet", "Rose", "Cyan", "Magenta", "Turquoise",
                "Blanc", "Noir", "Gris", "Doré", "Argent",
                "Marron", "Beige", "Bordeaux", "Olive", "Lavande",
                "Sable", "Émeraude", "Azur", "Indigo", "Saumon", "Fuchsia"
        );

        for (int index = 0; index < joueursValides.size(); index++) {
            assertEquals(couleursAttendus.get(index),
                    joueursValides.get(index).getCouleur());
        }
    }
    
    @Test
    void testNomInvalideVide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, "", "Rouge");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(2, "   ", "Jaune");
        });
    }
    
    @Test
    void testNomInvalideNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, null, "Rouge");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(2, null, "Jaune");
        });
    }
    
    @Test
    void testCouleurInvalideVide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, "Alice", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(2, "Bob", "   ");
        });
    }

    @Test
    void testCouleurInvalideNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(1, "Alice", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(2, "Bob", null);
        });
    }
    
    @Test
    void testNomLong() {
        String nomLong = "A".repeat(30);
        Joueur joueur = new Joueur(1, nomLong, "Rouge");
        assertEquals(nomLong, joueur.getNom());
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(2, "A".repeat(31), "Jaune");
        });
    }
    
    @Test
    void testIdInvalide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(3, "Alice", "Rouge");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Joueur(0, "Bob", "Jaune");
        });
    }
    
    @Test
    void testNomAvecEspaces() {
        Joueur joueur = new Joueur(1, "Jean Pierre", "Rouge");
        assertEquals("Jean Pierre", joueur.getNom());
    }
}