/*
 * Joueur.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

/**
 * Cette classe représente un joueur dans le jeu Puissance 4.
 * Un joueur a un identifiant (1 ou 2), un nom, et une couleur.
 * 
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
     * 
     * @param id identifiant du joueur, ici 1 ou 2
     * @param nom nom du joueur, ici joueur
     * @param couleur couleur du joueur qu'il aura choisit
     * @throws IllegalArgumentException si les paramètres sont invalides
     */
    public Joueur(int id, String nom, String couleur) {
        if (id != 1 && id != 2) {
            throw new IllegalArgumentException("L'id du joueur "
                                              + " doit être 1 ou 2.");
        }

        if (nom == null) {
            throw new IllegalArgumentException("Le nom du joueur "
                                              + " ne peut pas être null.");
        }

        if (nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas "
                                     + " être vide ou uniquement des espaces.");
        }

        if (nom.length() > 30) {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas "  
                                              + " dépasser 30 caractères.");
        }

        if (!nom.matches("[A-Za-zÀ-ÿ \\-']+")) {
            throw new IllegalArgumentException("Le nom du joueur contient "
                                              + " des caractères invalides.");
        }

        if (couleur == null) {
            throw new IllegalArgumentException("La couleur du joueur ne peut "
                                              + " pas être null.");
        }

        if (couleur.trim().isEmpty()) {
            throw new IllegalArgumentException("La couleur du joueur ne peut "
                                 + " pas être vide ou uniquement des espaces.");
        }

        if (couleur.length() > 30) {
            throw new IllegalArgumentException("La couleur du joueur ne peut "
                                              + " pas dépasser 30 caractères.");
        }
        
        if (!couleur.matches("[A-Za-zÀ-ÿ \\-']+")) {
            throw new IllegalArgumentException("La couleur du joueur contient "
                                              + " des caractères invalides.");
        }

        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * Retourne l'identifiant du joueur (1 ou 2).
     * 
     * @return id du joueur
     */
    public int getId() {
        return id;
    }

    /**
     * Retourne le nom du joueur.
     * 
     * @return nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la couleur du joueur.
     * 
     * @return couleur du joueur
     */
    public String getCouleur() {
        return couleur;
    }
}