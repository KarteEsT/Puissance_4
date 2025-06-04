/*
 * ChronosGlobales.java                                             4 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.utils;

/**
 * Classe qui gère les paramètres globaux des chronomètres.
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class ChronosGlobales {
	
	/**
	 * Temps du chronomètre, en secondes.
	 */
	private static int tempsChrono;
	
	/**
	 * Retourne le temps du chronomètre
	 * @return le temps du chronomètre
	 */
	public static int getTempsChrono() {
        return tempsChrono;
    }

	/**
	 * Définit le temps des chronomètres
	 * @param temps le temps à définir pour le chronomètre
	 */
    public static void setTempsChrono(int temps) {
        tempsChrono = temps;
    }

}