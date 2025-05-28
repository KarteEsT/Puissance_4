/*
 * Main.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;

import java.util.Scanner;

/**
 * Main pour lancer l'application Puissance 4
 * @author Gabriel Robache
 * @author Gabriel Le Goff
 * @author Mael Massicard
 * @author Esteban Roveri
 * @version 1.0
 */
public class Main {
    
    /**
     * Lance l'application
     * @param args
     */
    public static void main(String[] args) {
        
        Joueur j1 = new Joueur(1,"Joueur","Jaune");
        Joueur j2 = new Joueur(2,"Joueur","Rouge");
        
        Grille grille = new Grille(6,7,j1,j2);
        
        
        /* Test victoire verticale */
        grille.poserPion(1);
        grille.poserPion(0);
        grille.poserPion(1);
        grille.poserPion(0);
        grille.poserPion(1);
        grille.poserPion(0);
        grille.poserPion(1);

        System.out.println(grille.toString());
        System.out.println(grille.verifierVictoireVerticale());
        
        /* Test victoire horizontale */
        grille = new Grille(6,7,j1,j2);

        grille.poserPion(1);
        grille.poserPion(1);
        
        grille.poserPion(2);
        grille.poserPion(2);
        
        grille.poserPion(3);
        grille.poserPion(3);
        
        grille.poserPion(4);

        System.out.println(grille.toString());
        System.out.println(grille.verifierVictoireHorizontale());
        
        grille = new Grille(6,7,j1,j2);
        grille.poserPion(5); 
        grille.poserPion(0);
        grille.poserPion(0);
        
        grille.poserPion(1);
        grille.poserPion(1);
        
        grille.poserPion(2);
        grille.poserPion(2);
        
        grille.poserPion(3);
        System.out.println(grille.toString());
        System.out.println(grille.verifierVictoireHorizontale());
        
        grille = new Grille(6,7,j1,j2);
        Scanner entree = new Scanner(System.in);
        do {
        	System.out.println(grille);
        	System.out.println("Où voulez-vous jouer : ");
			if (!entree.hasNextInt()) {
				System.out.println("Veuillez saisir un nombre entier");
				entree.next();
				continue;
			} else {
				int colonne = entree.nextInt();
				try {
					if (!grille.poserPion(colonne-1)) {
						System.out.println("Colonne pleine, veuillez en choisir une autre.");
						continue;
					};
					
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
				}
			}
        } while (!grille.verifierVictoire() && !grille.isGrilleRemplie());
        System.out.println("Le joueur n° " + ((grille.getCompteTour() - 1)%2  + 1)+ " a gagné !");
        System.out.println(grille);
    }
}
