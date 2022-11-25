package Prova2;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class InterfaceJogo extends JFrame{
	
	public InterfaceJogo() {
		setTitle("Jogo Goleiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 600);
		setLocationRelativeTo(this);
		setVisible(true);
		organizarLayout();
	}
	
	public void organizarLayout() {		
		ReiniciarSair RS = new ReiniciarSair();
		add(BorderLayout.SOUTH, RS);
		Gol gol = new Gol(RS.getGols(), RS.getDefesas());
		add(BorderLayout.CENTER, gol);
	}
	
}
