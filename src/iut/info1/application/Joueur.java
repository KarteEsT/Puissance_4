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
    
	/* identifiant du joueur */
    private int id;
	
	/* pseudo du joueur */
    private String nom;
	
	/* couleur du joueur */
    private String couleur;
    
	/* Constructeur d'un joueur */
	
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

        validateId(id);
        validateNom(nom);
        validateCouleur(couleur);

        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
    }
	
	/* getters */
	
    /**
	 * Getter de l'identifiant du joueur
     * @return id du joueur
     */
    public int getId() {
        return id;
    }

    /** 
     * Getter du pseudo du joueur
     * @return nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de la couleur du joueur
     * @return couleur du joueur
     */
    public String getCouleur() {
        return couleur;
    }
	
	/* Méthodes */

    /**
     * Valide l'identifiant du joueur. L'identifiant doit être soit 1 soit 2.
     * 
     * @param id l'identifiant du joueur à valider
     * @throws IllegalArgumentException si l'identifiant est invalide
     */
    private static void validateId(int id) {
        if (id != 1 && id != 2) {
            throw new IllegalArgumentException
            ("L'id du joueur doit être 1 ou 2.");
        }
    }

    /**
     * Valide le nom du joueur. Le nom doit être non nul,
     * non vide, ne contenir que des caractères valides
     * (lettres, espaces, tirets et apostrophes),
     * et ne pas dépasser 30 caractères.
     * 
     * @param nom le nom du joueur à valider
     * @throws IllegalArgumentException si le nom est invalide
     */
    private static void validateNom(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException
                      ("Le nom du joueur ne peut pas être null.");
        }
        if (nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du joueur "
                         + " ne peut pas être vide ou uniquement des espaces.");
        }
        if (nom.length() > 20) {
            throw new IllegalArgumentException
            ("Le nom du joueur ne peut pas dépasser 20 caractères.");
        }
        if (!nom.matches("[A-Za-zÀ-ÿ0-9 \\-']+")) {
            throw new IllegalArgumentException("Le nom du joueur contient "
                                              + " des caractères invalides.");
        }
    }

    /**
     * Valide la couleur du joueur. La couleur doit être non nulle, non vide, ne
     * contenir que des caractères valides, et ne pas dépasser 30 caractères.
     * 
     * @param couleur la couleur du joueur à valider
     * @throws IllegalArgumentException si la couleur est invalide
     */
    private static void validateCouleur(String couleur) {
        if (couleur == null) {
            throw new IllegalArgumentException
            ("La couleur du joueur ne peut pas être null.");
        }
        if (couleur.trim().isEmpty()) {
            throw new IllegalArgumentException("La couleur du joueur "
                         + " ne peut pas être vide ou uniquement des espaces.");
        }
        if (couleur.length() > 30) {
            throw new IllegalArgumentException
            ("La couleur du joueur ne peut pas dépasser 30 caractères.");
        }
    }
}