/*
 * Grille.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

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
    			return ligne;
    		}
    	}

    	return -1; // Colonne pleine
    }

    
    
    /**
     * On va verifier si il y a une victoire verticale
     * 
     * @return true si il y a une victoire 
     *         false sinon
     */
    public boolean verifierVictoireVerticale() {
        int[][] mat = matrice;
        boolean isGagne = false;
        for (int i = 0 ; i < getLigne() - 3 ; i++) {
			for (int j = 0 ; j < getColonne() ; j++) {
				if (mat[i][j] == ((compteTour-1) % 2) + 1 &&
					mat[i + 1][j] == ((compteTour-1) % 2) + 1 &&
					mat[i + 2][j] == ((compteTour-1) % 2) + 1 &&
					mat[i + 3][j] == ((compteTour-1) % 2) + 1) {
					isGagne = true;
				}
			}
		}
        return isGagne;
    }
    
    /**
     * On va verifier si il y a une victoire dans une ligne
     * 
     * @return true si il y a une victoire false sinon
     */
    public boolean verifierVictoireHorizontale() {
        int[][] mat = getMatrice();
        boolean isGagne = false;
        for (int i = 0 ; i < getLigne() ; i++) {
			for (int j = 0 ; j < getColonne() - 3 ; j++) {
				if (mat[i][j] == ((compteTour-1) % 2) + 1 &&
					mat[i][j + 1] == ((compteTour-1) % 2) + 1 &&
					mat[i][j + 2] == ((compteTour-1) % 2) + 1 &&
					mat[i][j + 3] == ((compteTour-1) % 2) + 1) {
					isGagne = true;
				}
			}
		}
        return isGagne;
    }
    
    /**
     * On va verifier si il y a une victoire dans la diagonale montante
     * 
     * @return true si il y a une victoire
     *         false sinon
     */
    public boolean verifierVictoireDiagonaleMontante() {
        int[][] mat = getMatrice();
        boolean isGagne = false;
        for (int i = 3 ; i < getLigne() ; i++ ) {
			for (int j = 0; j < getColonne() - 4 ; j++ ) {
				if (mat[i][j] == ((compteTour-1) % 2) + 1 &&
					mat[i - 1][j + 1] == ((compteTour-1) % 2) + 1 &&
					mat[i - 2][j + 2] == ((compteTour-1) % 2) + 1 &&
					mat[i - 3][j + 3] == ((compteTour-1) % 2) + 1) {
					isGagne = true;
				}
			}
        }
        
        return isGagne;
    }
    
    /**
     * On va verifier si il y a une victoire dans la diagonale descendante
     * 
     * @return true si il y a une victoire
     *         false sinon
     */
    public boolean verifierVictoireDiagonaleDescendante() {
        int[][] mat = getMatrice();
        boolean isGagne = false;
        for (int i = 0 ; i < getLigne() - 3 ; i++) {
        	for (int j = 0; j < getColonne() - 3; j++) {
				if (mat[i][j] == ((compteTour-1) % 2) + 1 &&
					mat[i + 1][j + 1] == ((compteTour-1) % 2) + 1 &&
					mat[i + 2][j + 2] == ((compteTour-1) % 2) + 1 &&
					mat[i + 3][j + 3] == ((compteTour-1) % 2) + 1) {
					isGagne = true;
				}
			}
        }
        return isGagne;
    }
    
    /**
     * On va verifier si il y a une victoire dans la grille
     * @param colonneJouee par le joueur
     * 
     * @return true si il y a une victoire false sinon
     */
    public boolean verifierVictoire() {
        return verifierVictoireVerticale() || 
               verifierVictoireHorizontale() || 
               verifierVictoireDiagonaleMontante() || 
               verifierVictoireDiagonaleDescendante();
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
