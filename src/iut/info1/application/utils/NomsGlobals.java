/*
 * NomsGlobals.java                                                  3 juin 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.utils;

/**
 * Classe qui gère les noms des joueurs
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 */
public class NomsGlobals {
	
	private static String nomJoueur1 = ""; // Nom par défaut
	private static String nomJoueur2 = ""; // Nom par défaut
	
	public static String getNomJoueur1() {
		return nomJoueur1;
	}

	public static void setNomJoueur1(String nom) {
		nomJoueur1 = nom;
	}

	public static String getNomJoueur2() {
		return nomJoueur2;
	}

	public static void setNomJoueur2(String nom) {
		nomJoueur2 = nom;
	}
}

