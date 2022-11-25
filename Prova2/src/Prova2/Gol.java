package Prova2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gol extends JPanel implements ActionListener {

	private static ArrayList<Botao> botoes;
	private JTextField gols;
	private JTextField defesas;
	private static int contGols;
	private static int contDefesas;

	public Gol(JTextField gols, JTextField defesas) {
		botoes = new ArrayList<Botao>();
		this.gols = gols;
		this.defesas = defesas;

		setLayout(new GridLayout(8, 16));

		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 16; j++) {
				botoes.add(criarBotoes(i, j));
			}
		}
	}

	public static int getContGols() {
		return contGols;
	}

	public static int getContDefesas() {
		return contDefesas;
	}

	public Botao criarBotoes(int x, int y) {
		Botao botao = new Botao(x, y);
		add(botao);
		botao.addActionListener(this);
		return botao;
	}

	public void defesa() {
		Random rand = new Random();

		int a = rand.nextInt(3, 8);
		int b = rand.nextInt(3, 14);

		for (int i = a - 2; i <= a + 2; i++) {
			for (int j = b - 2; j <= b + 2; j++) {
				for (Botao btns : botoes) {
					if ((i <= 8 && j <= 16) && btns.getText().equals(i + "-" + j))
						btns.setDefesa(true);
					if (btns.getText().equals((a - 2) + "-" + (b - 2)))
						btns.setAuxiliar(1);
					if (btns.getText().equals((a - 2) + "-" + (b + 2)))
						btns.setAuxiliar(2);
					if (btns.getText().equals(a + "-" + b))
						btns.setAuxiliar(3);
					if (btns.getText().equals((a + 2) + "-" + (b - 2)))
						btns.setAuxiliar(4);
					if (btns.getText().equals((a + 2) + "-" + (b + 2)))
						btns.setAuxiliar(5);
				}
			}
		}
	}

	public void contabilizarGol(JButton botao) {
		mostrarDefesa();

		botao.setText("");
		botao.setIcon(new ImageIcon("Img/bola.png"));
		contGols++;
		String contadorGols = String.valueOf(contGols);
		gols.setText("Gols: " + contadorGols);
	}

	public void contabilizarDefesa(JButton botao) {
		mostrarDefesa();

		Color verdeEscuro = new Color(34, 139, 34);
		botao.setBackground(verdeEscuro);
		contDefesas++;
		String contadorDefes = String.valueOf(contDefesas);
		defesas.setText("Defesas: " + contadorDefes);
	}

	public void mostrarDefesa() {
		Color verdeEscuro = new Color(50, 205, 50);
		Color cinzaClaro = new Color(220, 220, 220);

		for (Botao btns : botoes) {
			if (btns.isDefesa() == true && btns.isTrave() == false) {
				btns.setText("");
				btns.setBackground(verdeEscuro);
			}
			if (btns.isDefesa() == true && btns.isTrave() == true) {
				btns.setText("");
				btns.setBackground(cinzaClaro);
			}
			if (btns.getAuxiliar() == 1)
				btns.setIcon(new ImageIcon("Img/maoD.png"));
			if (btns.getAuxiliar() == 2)
				btns.setIcon(new ImageIcon("Img/maoE.png"));
			if (btns.getAuxiliar() == 3)
				btns.setIcon(new ImageIcon("Img/sorriso.png"));
			if (btns.getAuxiliar() == 4)
				btns.setIcon(new ImageIcon("Img/peD.png"));
			if (btns.getAuxiliar() == 5)
				btns.setIcon(new ImageIcon("Img/peE.png"));
		}
	}
	
	public void zerarDefesa() {
		for (Botao btns : botoes) {
			btns.setDefesa(false);
			btns.setIcon(null);
			btns.setAuxiliar(0);
			if (btns.isDentro() == true) {
				btns.setText(btns.x + "-" + btns.y);
				btns.setBackground(Color.GREEN);
			}
			if (btns.isTrave() == true) {
				btns.setText(btns.x + "-" + btns.y);
				btns.setBackground(Color.WHITE);
			}
			if (btns.isDentro() == false && btns.isTrave() == false) {
				btns.setText(btns.x + "-" + btns.y);
				btns.setBackground(Color.GREEN);
			}
		}
	}

	public void mostrarClics() {
		for (Botao btns : botoes) {
			if (btns.getQuantGols() > 0) {
				btns.setText("G:" + btns.getQuantGols());
				btns.setForeground(Color.BLUE);
			}
			if (btns.getQuantDefesas() > 0) {
				btns.setText("D:" + btns.getQuantDefesas());
				btns.setForeground(Color.RED);
			}
			if (btns.getQuantGols() > 0 && btns.getQuantDefesas() > 0) {
				btns.setText("G:" + btns.getQuantGols() + "/D:" + btns.getQuantDefesas());
				btns.setForeground(Color.MAGENTA);
			}
		}
	}

	public void zerarClics() {
		for (Botao btns : botoes) {
			btns.setQuantGols(0);
			btns.setQuantDefesas(0);
		}
	}

	public void zerarContadores() {
		zerarClics();

		contGols = 0;
		contDefesas = 0;
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		zerarDefesa();
		defesa();

		if (((Botao) botao).getText() == "	Reiniciar	") {
			zerarContadores();
		}
		if (((Botao) botao).getText() == "	Sair	") {
			mostrarClics();
			JOptionPane.showMessageDialog(null, "Jogador: " + IniciarJogo.getNome().getText() + "\nGols: " + Gol.getContGols()
			+ "\nDefesas: " + Gol.getContDefesas());
			System.exit(0);
		}
		if (((Botao) botao).isDefesa() == false && ((Botao) botao).isDentro() == true) {
			((Botao) botao).setQuantGols(((Botao) botao).getQuantGols() + 1);
			contabilizarGol(botao);	
		}
		if (((Botao) botao).isDefesa() == true && ((Botao) botao).isDentro() == true) {
			((Botao) botao).setQuantDefesas(((Botao) botao).getQuantDefesas() + 1);
			contabilizarDefesa(botao);
		}
	}
}
