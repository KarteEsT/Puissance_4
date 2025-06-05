
/*
 * GrilleGlobales.java                                              3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.utils;

/**
 * Classe qui gère la matrice de la grille et le compteur de tours
 *
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class GrilleGlobales {
	
	/** Matrice par défaut */
    private static int[][] matrice = new int[0][0];
    
    /** Compteur de tours par défaut */
    private static int compteTour = 0;

    /* Getters */
    
    /**
     * Récupère la matrice de la grille.
     * @return la matrice de la grille
     */
    public static int[][] getMatrice() {
        return matrice;
    }
    
    /**
     * Récupère le compteur de tours.
     * @return le compteur de tours
     */
    public static int getCompteTour() {
        return compteTour;
    }

    /* Setters */
    
    /**
     * Modifie la matrice de la grille.
     * @param nouvelleMatrice la nouvelle matrice à définir
     */
    public static void setMatrice(int[][] nouvelleMatrice) {
        matrice = nouvelleMatrice;
    }

    /**
     * Modifie le compteur de tours.
     * @param nouveauCompteTour le nouveau compteur de tours à définir
     */
    public static void setCompteTour(int nouveauCompteTour) {
        compteTour = nouveauCompteTour;
    }
}
