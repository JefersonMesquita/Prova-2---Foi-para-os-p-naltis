package Prova2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IniciarJogo extends JFrame implements ActionListener {

	private static JTextField nome;

	public IniciarJogo() {
		setLayout(new FlowLayout());

		setTitle("Jogo Goleiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 80);
		setLocationRelativeTo(this);

		receberNome();
		botoes();

		setVisible(true);
	}

	public static JTextField getNome() {
		if (nome.getText().equals(""))
			nome.setText("Jogador");
		return nome;
	}

	public void receberNome() {
		JLabel digiteNome = new JLabel("Digite seu nome:");
		add(digiteNome);

		nome = new JTextField(20);
		add(nome);
	}

	public void botoes() {
		JButton iniciar = new JButton("	iniciar	");
		add(iniciar);
		iniciar.addActionListener(this);

		JButton sair = new JButton("	sair	");
		add(sair);
		sair.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();

		if (botao.getText() == "	iniciar	") {
			InterfaceJogo jogo = new InterfaceJogo();
			this.dispose();
		} else {
			System.exit(0);
		}
	}	
}
