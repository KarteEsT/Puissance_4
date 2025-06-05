/*
 * CouleursGlobales.java                                            3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.utils;

/**
 * Classe qui gère les couleurs
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class CouleursGlobales {
	
	/** couleur par défaut du joueur 1 */
    private static String couleurJoueur1 = "#FF0000";
    
    /** couleur par défaut du joueur 2 */
    private static String couleurJoueur2 = "#FFFF00";

    /**
     * Getter pour la couleur du joueur 1
     * @return la couleur du joueur 1
     */
    public static String getCouleurJoueur1() {
        return couleurJoueur1;
    }

	/**
	 * Setter pour la couleur du joueur 1
	 * @param couleur la nouvelle couleur du joueur 1
	 */
    public static void setCouleurJoueur1(String couleur) {
        couleurJoueur1 = couleur;
    }

	/**
	 * Getter pour la couleur du joueur 2
	 * @return la couleur du joueur 2
	 */
    public static String getCouleurJoueur2() {
        return couleurJoueur2;
    }
    
	/**
	 * Setter pour la couleur du joueur 2
	 * @param couleur la nouvelle couleur du joueur 2
	 */
    public static void setCouleurJoueur2(String couleur) {
        couleurJoueur2 = couleur;
    }
}
