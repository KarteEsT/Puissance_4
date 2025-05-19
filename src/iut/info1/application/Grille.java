/*
 * Grille.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

import iut.info1.application.Joueur;

/**
 * Classe permettant de créer une Grille
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 * @version 1.0
 */
public class Grille {
    
    private int colonne;
    
    private int ligne;
    
    private int[][] matrice;
    
    private Joueur j1;
    
    private Joueur j2;
    
    private int compteTour;
    
    /**
     * Grille permettant de jouer au puissance 4 
     * @param colonne
     * @param ligne
     * @param j1 
     * @param j2 
     */
    public Grille (int ligne , int colonne, Joueur j1, Joueur j2) {
        
        this.colonne = colonne;
        this.ligne = ligne;
        this.j1 = j1;
        this.j2 = j2;
        compteTour = 0;
        matrice = new int[ligne][colonne];
    }
    
     /**
     * Grille permettant de jouer au puissance 4
     * @param ligne
     * @param colonne
     */
    public Grille (int ligne , int colonne) {
        
        this.colonne = colonne;
        this.ligne = ligne;
        matrice = new int[ligne][colonne];
        compteTour = 0;

    }
        
    /**
     * 
     * @return le nombre de lignes
     */
    public int getLigne() {
        return ligne;
    }
    
    /**
     * @return colonne
     * 
     */
    public int getColonne() {
        return colonne;
    }
    
    /**
     * C'est le joueur 1
     * @return j1
     */
    public Joueur getJ1() {
        return j1;
    }
    
    /**
     * C'est le joueur 2
     * 
     * @return j2
     */
    public Joueur getJ2() {
        return j2;
    }
    
    /**
     * @return matrice
     */
    public int[][] getMatrice() {
        return matrice;
    }
    
    /**
     * @return le nombre de tour
     */
    public int getCompteTour() {
        return compteTour;
    }
        
    
    
    /**
     * On va remonter la matrice en partant du bas de la colonne
     * afin de chercher une place libre, si on la trouve on pose le pion
     * sinon on renvoie false (le joueur doit rejouer sur une colonne libre)
     * @param colonneJouee 
     * @return true si le pion a pu être posé
     *         false sinon
     */
    public boolean poserPion(int colonneJouee) {
        
        int[][] mat = matrice;
        
        for (int IndiceLigne = getLigne()-1; IndiceLigne >= 0; IndiceLigne --) {
            
            
            if (mat[IndiceLigne][colonneJouee] == 0 ) {
                mat[IndiceLigne][colonneJouee] = (compteTour %2) +1;
                compteTour ++;
            }
        }
    }


    
}
