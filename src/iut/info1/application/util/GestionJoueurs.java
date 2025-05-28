/*
 * GestionJoueurs.java                                              28 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.util;

/**
 * Classe utilitaire pour la gestion des noms des joueurs
 */
public class GestionJoueurs {
	
	private static String nomJoueur1 = "JOUEUR 1";
    private static String nomJoueur2 = "JOUEUR 2";

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
