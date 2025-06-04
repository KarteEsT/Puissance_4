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

    /* Temps du chronomètre, en secondes */
    private static int tempsChrono;
    
    /* Boolean pour savoir si le chronomètre de la partie est activé ou non */
    private static boolean chronoPartie = false;

    
    /**
     * Retourne le boolean du chronomètre de la partie
     * @return chronoPartie le boolean du chronomètre de la partie
     */
    public static boolean getChronoPartie() {
    	return chronoPartie;
    }
    
    /**
     * Définit le boolean du chronomètre de la partie
     * @param booleanPartie le boolean du chronomètre de la partie
     */
    public static void setChronoPartie(boolean booleanPartie) {
    	chronoPartie = booleanPartie;
    }
    
    
    
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