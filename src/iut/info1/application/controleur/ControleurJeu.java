/*
 * ControleurJeu.java                                              16 mai 2025
 * IUT de Rodez, Info 1 2024 - 2025 TP2, pas de copyright
 */
package iut.info1.application.controleur;

import iut.info1.application.VueJeu;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

/**
 * Contrôleur de la vue "fentreJeu"
 * @author Gabriel Robache
 */
public class ControleurJeu {
	
	private Circle A1;
	private Circle A2;
	private Circle A3;
	private Circle A4;
	private Circle A5;
	private Circle A6;
	
	private Circle B1;
	private Circle B2;
	private Circle B3;
	private Circle B4;
	private Circle B5;
	private Circle B6;
	
	private Circle C1;
	private Circle C2;
	private Circle C3;
	private Circle C4;
	private Circle C5;
	private Circle C6;
	
	private Circle D1;
	private Circle D2;
	private Circle D3;
	private Circle D4;
	private Circle D5;
	private Circle D6;
	
	private Circle E1;
	private Circle E2;
	private Circle E3;
	private Circle E4;
	private Circle E5;
	private Circle E6;
	
	private Circle F1;
	private Circle F2;
	private Circle F3;
	private Circle F4;
	private Circle F5;
	private Circle F6;
	
    @FXML
    public void gererClicOption() {
    	VueJeu.activerFenetreOption();
    }
	
}