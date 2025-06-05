/*
 * SauvegardeCheminOption.java                                                       5 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.utils;

/**
 * Classe qui permet de sauvegarder l'emplacement d'activation des options
 * Soit depuis Multijoueur, soit depuis Ordinateur ou soit depuis le Menu
 * 
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class SauvegardeCheminOption {

	/** String qui permettait de sauvegarder le chemin */
	private static String chemin = "";
	
	/** 
	 * getter du chemin
	 * @return chemin Le chemin d'accès
	 */
	public static String getChemin() {
		return chemin;
	}
	
	/**
	 * Setter du chemin
	 * @param nouveauChemin Définit le nouveau chemin d'accès
	 */
	public static void setChemin(String nouveauChemin) {
		chemin = nouveauChemin;
	}
}
