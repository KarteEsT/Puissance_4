/*
 * Joueur.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

/**
 * Cette classe représente un joueur dans le jeu Puissance 4.
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 * @version 1.0
 */
public class Joueur {
    
    private int id;
    
    private String nom;
    
    private String couleur;
    
    /**
     * Initialise un nouveau joueur avec l'identifiant,
     * le nom et la couleur spécifiés.
     * L'état initial comprend :
     * - L'identifiant unique du joueur (`id`), qui est soit 1 soit 2.
     * - Le nom du joueur, qui représente le nom choisi pour le joueur.
     * - La couleur choisie par le joueur utilisée
     * pour le représenter dans le jeu.
     * @param id identifiant du joueur, ici 1 ou 2
     * @param nom nom du joueur, ici joueur
     * @param couleur couleur du joueur qu'il aura choisit
     */
    public Joueur(int id ,String nom ,String couleur) {
        
        if (id != 1 && id != 2) {
            throw new IllegalArgumentException("L'identifiant du joueur "
                                                + " doit être 1 ou 2.");
        }
        
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom du joueur "
                                                + " ne peut pas être vide.");
        }
        
        if (couleur == null || couleur.isEmpty()) {
            throw new IllegalArgumentException("La couleur du joueur "
                                                + " ne peut pas être vide.");
        }
        
        if (nom.length() > 30) {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas "
                                                + " dépasser 30 caractères.");
        }
        
        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * @return nouvelle valeur de id
     */
    public int getId() {
        return id;
    }

    /**
     * @return nouvelle valeur de nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return nouvelle valeur de couleur
     */
    public String getCouleur() {
        return couleur;
    }
}