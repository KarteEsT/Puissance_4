/*
 * Main.java                                   16 mai 2025
 * IUT de Rodez, Info1 2024-2025, pas de copyright
 */
package iut.info1.application;


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
        grille.poserPion(0);
        grille.poserPion(1);

        grille.poserPion(0);
        grille.poserPion(1);
        
        grille.poserPion(3);
        grille.poserPion(1);
        
        grille.poserPion(0);

        grille.poserPion(1);

        System.out.println(grille.toString());
        System.out.println(grille.verifierVictoireVerticale());
        

    }
}
