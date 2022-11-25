package Prova2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReiniciarSair extends JPanel implements ActionListener{

	private JTextField gols;
	private JTextField defesas;
	private Botao reiniciar;
	private Botao sair;

	public ReiniciarSair() {
		setLayout(new FlowLayout());
		
		caixasTexto();
		botoes();

		add(reiniciar);
		add(gols);
		add(defesas);
		add(sair);

		setVisible(true);
	}

	public JTextField getGols() {
		return gols;
	}

	public JTextField getDefesas() {
		return defesas;
	}
	
	public void setGols(JTextField gols) {
		this.gols = gols;
	}

	public void setDefesas(JTextField defesas) {
		this.defesas = defesas;
	}

	public void caixasTexto() {
		gols = new JTextField(10);
		gols.setEditable(false);
		gols.setText("Gols: 0");
		gols.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		defesas = new JTextField(10);
		defesas.setEditable(false);
		defesas.setText("Defesas: 0");
		defesas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	}
	
	public void botoes() {
		Gol listener = new Gol(null, null);
		
		reiniciar = new Botao(0, 0);
		reiniciar.setText("	Reiniciar	");
		reiniciar.addActionListener(listener);
		reiniciar.addActionListener(this);
		
		sair = new Botao(0, 0);		
		sair.setText("	Sair	");
		sair.addActionListener(listener);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		
		if(botao == reiniciar) {
			gols.setText("Gols: 0");
			defesas.setText("Defesas: 0");
		}
	}
}
