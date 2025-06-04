/*
 * AideTampon.java                                                  4 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.utils;

/**
 * Cette classe permet de dire à la vue si l'aide est activer ou désactiver
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 * @version 1.0
 */
public class AideTampon {

	/**
	 * Boolean pour savoir si l'aide est activer ou non
	 */
	private static boolean aide;
	
	/**
     * Retourne le boolean du chronomètre de la partie
     * @return aide le boolean de l'aide
     */
    public static boolean getAideBoolean() {
    	return aide;
    }
    
    /**
     * Définit le boolean du chronomètre de la partie
     * @param booleanAide le boolean du chronomètre de la partie
     */
    public static void setAideBoolean(boolean booleanAide) {
    	aide = booleanAide;
    }
	
}
