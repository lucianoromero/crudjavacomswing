package cadastro.de.pessoas.wiew;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import cadastro.de.pessoas.model.Pessoa;
import dao.PessoaDao;

public class Adicionar extends JFrame {
	private JTextField TFNome;
	private JTextField TFSobreNome;
	private JTextField TFCpf;
	private JTextField TFDianasc;
	private JTextField TFSalario;
	private JTextField TFRg;
	private JTextField TFTelefone;
	private JTextField TFMesnasc;
	private JTextField TFAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adicionar frame = new Adicionar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adicionar() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adicionar.class.getResource("/img/vcard_add.png")));
		setTitle("Sistema de Cadastro - Adicionar ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 262);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(27, 24, 39, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sobre Nome:");
		lblNewLabel_1.setBounds(301, 24, 105, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cpf:");
		lblNewLabel_2.setBounds(27, 55, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento:");
		lblNewLabel_3.setBounds(27, 83, 105, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Salario:");
		lblNewLabel_4.setBounds(330, 109, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Rg:");
		lblNewLabel_5.setBounds(330, 49, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(330, 77, 46, 14);
		contentPane.add(lblNewLabel_6);

		TFNome = new JTextField();
		TFNome.setToolTipText("");
		TFNome.setBounds(76, 21, 181, 20);
		contentPane.add(TFNome);
		TFNome.setColumns(10);

		TFSobreNome = new JTextField();
		TFSobreNome.setColumns(10);
		TFSobreNome.setBounds(391, 21, 181, 20);
		contentPane.add(TFSobreNome);

		TFCpf = new JTextField();
		TFCpf.setColumns(10);
		TFCpf.setBounds(76, 52, 181, 20);
		contentPane.add(TFCpf);

		TFDianasc = new JTextField();
		TFDianasc.setText("DIA");
		TFDianasc.setColumns(10);
		TFDianasc.setBounds(27, 109, 57, 20);
		contentPane.add(TFDianasc);

		TFSalario = new JTextField();
		TFSalario.setColumns(10);
		TFSalario.setBounds(391, 106, 181, 20);
		contentPane.add(TFSalario);

		TFRg = new JTextField();
		TFRg.setColumns(10);
		TFRg.setBounds(391, 49, 181, 20);
		contentPane.add(TFRg);

		TFTelefone = new JTextField();
		TFTelefone.setColumns(10);
		TFTelefone.setBounds(391, 74, 181, 20);
		contentPane.add(TFTelefone);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(29, 161, 571, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		
		JButton btnCadastra = new JButton("Cadastra ");
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = TFNome.getText();
				String sobrenome = TFSobreNome.getText();
				String rcpf = TFCpf.getText();
				String dianasc = TFDianasc.getText();
				String mesnasc = TFMesnasc.getText();
				String anonasc = TFAno.getText();
				String rsalario = TFSalario.getText();
				String rrg = TFRg.getText();
				String rtelefone = TFTelefone.getText();

				// Tratamento da conversao
				// CPF
				int cpf = 0;
				try {
					cpf = Integer.parseInt(rcpf);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "CPF digitado invalido verificar: \n" + rcpf, "Alerta",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// Salario
				double salario = 0;
				try {
					salario = Double.parseDouble(rsalario);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Salario digitado invalido verificar: \n" + rsalario, "Alerta",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// RG
				int rg = 0;
				try {
					rg = Integer.parseInt(rrg);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "RG digitado invalido verificar: \n" + rrg, "Alerta",
							JOptionPane.ERROR_MESSAGE);
				}
				// Telefone
				int telefone = 0;
				try {
					telefone = Integer.parseInt(rtelefone);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Telefone digitado invalido verificar: \n" + rtelefone,
							"Alerta", JOptionPane.ERROR_MESSAGE);
				}

				// Criando o Objeto
				String datadenascimento = anonasc.concat("-").concat(mesnasc).concat("-".concat(dianasc));
				String validadata = datadenascimento.replaceAll("[^a-zA-Z0-9]", "");
				if (validadata.matches("[0-9]*")) {
					// Inicio do IF
					Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, datadenascimento, salario, rg, telefone);
					// Adicionando no banco
					PessoaDao conexaoadicionar = new PessoaDao();
					boolean resposta = conexaoadicionar.adicionar(pessoa);

					if (resposta == true) {
						JOptionPane.showMessageDialog(null, "\nincluido com sucesso !", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
					}

					// Limpando os campos
					TFNome.setText("");
					TFSobreNome.setText("");
					TFCpf.setText("");
					TFSalario.setText("");
					TFRg.setText("");
					TFTelefone.setText("");
					TFDianasc.setText("DIA");
					TFAno.setText("ANO");
					TFMesnasc.setText("MES");
					// Fim do IF
				} else {
					JOptionPane.showMessageDialog(null,
							"Verificar a Data de Nascimento Digitada \n Respeira o formato DIA-MES-ANO \n"
									+ datadenascimento,
							"Alerta", JOptionPane.ERROR_MESSAGE);
					TFDianasc.setText("DIA");
					TFAno.setText("ANO");
					TFMesnasc.setText("MES");
				}

			}
		});
		btnCadastra.setIcon(new ImageIcon(Adicionar.class.getResource("/img/user_add.png")));
		btnCadastra.setBounds(63, 11, 198, 23);
		panel.add(btnCadastra);

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(Adicionar.class.getResource("/img/cancel.png")));
		btnCancelar.setBounds(271, 11, 198, 23);
		panel.add(btnCancelar);

		TFMesnasc = new JTextField();
		TFMesnasc.setText("MES");
		TFMesnasc.setColumns(10);
		TFMesnasc.setBounds(94, 109, 57, 20);
		contentPane.add(TFMesnasc);

		TFAno = new JTextField();
		TFAno.setText("ANO");
		TFAno.setColumns(10);
		TFAno.setBounds(161, 109, 86, 20);
		contentPane.add(TFAno);
	}
}
