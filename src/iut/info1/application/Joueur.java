/*
 * Joueur.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

/**
 * Classe permettant de créer des joueurs
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
     * TODO commenter l'état initial crée
     * @param id identifiant du joueur, ici 1 ou 2
     * @param nom nom du joueur, ici joueur
     * @param couleur couleur du joueur qu'il aura choisit
     */
    public Joueur(int id ,String nom ,String couleur) {
        
        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
    }
}
