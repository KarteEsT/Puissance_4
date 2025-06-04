/*
 * Grille.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

import java.util.ArrayList;
import java.util.List;

import iut.info1.application.controleur.ControleurJeu;

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
        setInstance(this);
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

    /* Instance unique de la grille */
    private static Grille instance;

    /**
     * Méthode pour récupérer l'instance unique de la grille
     * @return l'instance de la grille
     */
    public static Grille getInstance() {
        if (instance == null) {
            throw new IllegalStateException("La grille n'a pas encore été initialisée.");
        }
        return instance;
    }

    /**
     * Méthode pour définir ou mettre à jour l'instance de la grille
     * @param nouvelleInstance la nouvelle instance de la grille
     */
    public static void setInstance(Grille nouvelleInstance) {
        instance = nouvelleInstance;
    }

    /**
     * Setter le nombre de tour
     * @param compteTour
     * @return le nombre de tour
     */
    public int setCompteTour(int compteTour) {
        this.compteTour = compteTour;
        return this.compteTour;
    }

    /**
     * On va verifier si la grille est remplie
     * 
     * @return true si la grille est remplie false sinon
     * @throws NullPointerException si la matrice est nulle
     */
    public boolean isGrilleRemplie() {
        if (getMatrice() == null) {
            throw new NullPointerException("La matrice est nulle");
        }
        boolean isRemplie = true;
        for (int i = 0 ; i < getColonne() && isRemplie ; i++) {
            if (getMatrice()[0][i] == 0) {
                isRemplie = false;
            }
        }
        return isRemplie;
    }


    /**
     * On va remonter la matrice en partant du bas de la colonne
     * afin de chercher une place libre, si on la trouve on pose le pion
     * sinon on -1 false (le joueur doit rejouer sur une colonne libre)
     * @param colonneJouee
     * @return la ligne où le pion a été posé, ou -1 si la colonne est pleine
     */
    public int poserPion(int colonneJouee) {
        if (colonneJouee < 0 || colonneJouee >= getColonne()) {
            throw new ArrayIndexOutOfBoundsException("Colonne invalide");
        }

        for (int ligne = getLigne() - 1; ligne >= 0; ligne--) {
            if (matrice[ligne][colonneJouee] == 0) {
                matrice[ligne][colonneJouee] = (compteTour % 2) + 1;
                compteTour++;
                setInstance(this);
                return ligne;
            }
        }

        return -1; // Colonne pleine
    }


    /**
     * Méthode pour remettre les couleurs des pions déjà joués dans la grille en
     * fonction de la matrice de la grille.
     * 
     * @param grille La grille dont on veut remettre les couleurs des pions.
     * @param controleur Le contrôleur du jeu qui permet de mettre à jour la grille visuelle.
     */
    public static void remettreCouleursPions(Grille grille, ControleurJeu controleur) {
        int[][] matrice = grille.getMatrice();

        for (int ligne = 0; ligne < matrice.length; ligne++) {
            for (int colonne = 0; colonne < matrice[ligne].length; colonne++) {
                if (matrice[ligne][colonne] != 0) {
                    // Met à jour la grille visuelle via le contrôleur
                    controleur.mettreAJourGrille(ligne, colonne);
                }
            }
        }
    }



    /**
     * On va verifier si il y a une victoire verticale
     * 
     * @return true si il y a une victoire 
     *         false sinon
     */
    public List<int[]> verifierVictoireVerticale() {
        List<int[]> jetonsAlignes = new ArrayList<>();
        int[][] mat = matrice;
        int joueur = ((compteTour - 1) % 2) + 1;

        for (int i = 0; i < getLigne() - 3; i++) {
            for (int j = 0; j < getColonne(); j++) {
                if (mat[i][j] == joueur &&
                        mat[i + 1][j] == joueur &&
                        mat[i + 2][j] == joueur &&
                        mat[i + 3][j] == joueur) {
                    jetonsAlignes.add(new int[] { i, j });
                    jetonsAlignes.add(new int[] { i + 1, j });
                    jetonsAlignes.add(new int[] { i + 2, j });
                    jetonsAlignes.add(new int[] { i + 3, j });
                }
            }
        }
        return jetonsAlignes;
    }


    /**
     * On va verifier si il y a une victoire dans une ligne
     * 
     * @return true si il y a une victoire false sinon
     */
    public List<int[]> verifierVictoireHorizontale() {
        List<int[]> jetonsAlignes = new ArrayList<>();
        int[][] mat = matrice;
        int joueur = ((compteTour - 1) % 2) + 1;

        for (int i = 0; i < getLigne(); i++) {
            for (int j = 0; j < getColonne() - 3; j++) {
                if (mat[i][j] == joueur &&
                        mat[i][j + 1] == joueur &&
                        mat[i][j + 2] == joueur &&
                        mat[i][j + 3] == joueur) {
                    jetonsAlignes.add(new int[] { i, j });
                    jetonsAlignes.add(new int[] { i, j + 1 });
                    jetonsAlignes.add(new int[] { i, j + 2 });
                    jetonsAlignes.add(new int[] { i, j + 3 });
                }
            }
        }
        return jetonsAlignes;
    }

    /**
     * On va verifier si il y a une victoire dans la diagonale montante
     * 
     * @return true si il y a une victoire
     *         false sinon
     */
    public List<int[]> verifierVictoireDiagonaleMontante() {
        List<int[]> jetonsAlignes = new ArrayList<>();
        int[][] mat = matrice;
        int joueur = ((compteTour - 1) % 2) + 1;

        for (int i = 3; i < getLigne(); i++) {
            for (int j = 0; j < getColonne() - 3; j++) {
                if (mat[i][j] == joueur &&
                        mat[i - 1][j + 1] == joueur &&
                        mat[i - 2][j + 2] == joueur &&
                        mat[i - 3][j + 3] == joueur) {
                    jetonsAlignes.add(new int[] { i, j });
                    jetonsAlignes.add(new int[] { i - 1, j + 1 });
                    jetonsAlignes.add(new int[] { i - 2, j + 2 });
                    jetonsAlignes.add(new int[] { i - 3, j + 3 });
                }
            }
        }
        return jetonsAlignes;
    }

    /**
     * On va verifier si il y a une victoire dans la diagonale descendante
     * 
     * @return true si il y a une victoire
     *         false sinon
     */
    public List<int[]> verifierVictoireDiagonaleDescendante() {
        List<int[]> jetonsAlignes = new ArrayList<>();
        int[][] mat = matrice;
        int joueur = ((compteTour - 1) % 2) + 1;

        for (int i = 0; i < getLigne() - 3; i++) {
            for (int j = 0; j < getColonne() - 3; j++) {
                if (mat[i][j] == joueur &&
                        mat[i + 1][j + 1] == joueur &&
                        mat[i + 2][j + 2] == joueur &&
                        mat[i + 3][j + 3] == joueur) {
                    jetonsAlignes.add(new int[] { i, j });
                    jetonsAlignes.add(new int[] { i + 1, j + 1 });
                    jetonsAlignes.add(new int[] { i + 2, j + 2 });
                    jetonsAlignes.add(new int[] { i + 3, j + 3 });
                }
            }
        }
        return jetonsAlignes;
    }

    /**
     * On va verifier si il y a une victoire dans la grille
     * @param colonneJouee par le joueur
     * 
     * @return true si il y a une victoire false sinon
     */
    public List<int[]> verifierVictoire() {
        List<int[]> jetonsAlignes = new ArrayList<>();
        jetonsAlignes.addAll(verifierVictoireVerticale());
        jetonsAlignes.addAll(verifierVictoireHorizontale());
        jetonsAlignes.addAll(verifierVictoireDiagonaleMontante());
        jetonsAlignes.addAll(verifierVictoireDiagonaleDescendante());
        return jetonsAlignes;
    }

    /**
     * méthode pour réinitialiser la grille
     */
    public void reinitialiserGrille() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = 0;
            }
        }
        setInstance(this);
        compteTour = 0;
    }


    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        String grille = "";
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                grille += matrice[i][j] + " ";
            }
            grille += "\n";
        }
        return grille;
    }


}
