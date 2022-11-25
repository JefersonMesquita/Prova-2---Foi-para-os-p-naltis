package Prova2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Botao extends JButton {

	public int x;
	public int y;
	private boolean trave;
	private boolean dentro;
	private boolean defesa;
	private int quantGols;
	private int quantDefesas;
	private int auxiliar;

	public Botao(int x, int y) {
		this.x = x;
		this.y = y;
		setText(x + "-" + y);
		setOpaque(true);
		dentroDoGol(x, y);
		traves(x, y);
	}

	public boolean isTrave() {
		return trave;
	}

	public boolean isDentro() {
		return dentro;
	}

	public boolean isDefesa() {
		return defesa;
	}

	public void setDefesa(boolean defesa) {
		this.defesa = defesa;
	}

	public int getQuantGols() {
		return quantGols;
	}

	public void setQuantGols(int quantGols) {
		this.quantGols = quantGols;
	}

	public int getQuantDefesas() {
		return quantDefesas;
	}

	public void setQuantDefesas(int quantDefesas) {
		this.quantDefesas = quantDefesas;
	}
	
	public int getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(int auxiliar) {
		this.auxiliar = auxiliar;
	}

	private void dentroDoGol(int x, int y) {
		if (x > 2 && y > 2 && y < 15) {
			this.dentro = true;
			setBackground(Color.GREEN);
		}
		if (x == 1 || y == 1 || y == 16) {
			this.dentro = false;
			setBackground(Color.GREEN);
		}
	}

	private void traves(int x, int y) {
		if ((x == 2 && y > 1 && y < 16) || (x > 1 && y == 2) || (x > 1 && y == 15)) {
			this.trave = true;
			this.setBackground(Color.WHITE);
		}
	}

}