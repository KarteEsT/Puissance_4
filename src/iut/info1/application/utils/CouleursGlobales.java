/*
 * Coule.java                                                       3 juin 2025
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
    private static String couleurJoueur1 = "#FF0000"; // Couleur par défaut
    private static String couleurJoueur2 = "#FFFF00"; // Couleur par défaut

    public static String getCouleurJoueur1() {
        return couleurJoueur1;
    }

    public static void setCouleurJoueur1(String couleur) {
        couleurJoueur1 = couleur;
    }

    public static String getCouleurJoueur2() {
        return couleurJoueur2;
    }

    public static void setCouleurJoueur2(String couleur) {
        couleurJoueur2 = couleur;
    }
}
