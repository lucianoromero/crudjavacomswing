package cadastro.de.pessoas.wiew;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

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

public class Deletar extends JFrame {

	private JPanel contentPane;
	private JTextField TFID;
	private JTextField TFNOME;
	private JTextField TFSOBRENOME;
	private JTextField TFCPF;
	private JTextField TFSALARIO;
	private JTextField TFRG;
	private JTextField TFTELEFONE;
	private JTextField TFDATADENASCIMENTO;
	private JTextField TFIDENTIFICADOR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletar frame = new Deletar();
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
	public Deletar() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Deletar.class.getResource("/img/vcard_delete.png")));
		setTitle("Sistema de Cadastro - Deletar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 387, 37);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Informe o ID");
		lblNewLabel.setBounds(10, 11, 73, 14);
		panel.add(lblNewLabel);

		TFID = new JTextField();
		TFID.setBounds(92, 8, 86, 20);
		panel.add(TFID);
		TFID.setColumns(10);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO evendo te pesquisa
				String ID = TFID.getText();
				int identificacao = 0;
				try {
					identificacao = Integer.parseInt(ID);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Favor verificar o ID digitado: \n" + ID, "Alerta",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				PessoaDao consultaid = new PessoaDao();
				try {
					List<Pessoa> pessoas = consultaid.consultaid(identificacao);
					for (Pessoa p : pessoas) {
						String retornoid = Integer.toString(p.getId());
						TFIDENTIFICADOR.setText(retornoid);
						TFNOME.setText(p.getNome());
						TFSOBRENOME.setText(p.getSobrenome());
						String retornosalario = Double.toString(p.getSalario());
						TFSALARIO.setText(retornosalario);
						String retornocpf = Integer.toString(p.getCpf());
						TFCPF.setText(retornocpf);
						String retornorg = Integer.toString(p.getRg());
						TFRG.setText(retornorg);
						String retornotelefone = Integer.toString(p.getTelefone());
						TFTELEFONE.setText(retornotelefone);
						TFDATADENASCIMENTO.setText(p.getData_nacimento());
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setIcon(new ImageIcon(Deletar.class.getResource("/img/page_find.png")));
		btnNewButton.setBounds(235, 7, 129, 23);
		panel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 104, 46, 14);
		contentPane.add(lblNewLabel_1);

		TFNOME = new JTextField();
		TFNOME.setEditable(false);
		TFNOME.setBounds(84, 101, 294, 20);
		contentPane.add(TFNOME);
		TFNOME.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Sobre Nome:");
		lblNewLabel_2.setBounds(10, 139, 75, 14);
		contentPane.add(lblNewLabel_2);

		TFSOBRENOME = new JTextField();
		TFSOBRENOME.setEditable(false);
		TFSOBRENOME.setBounds(84, 136, 294, 20);
		contentPane.add(TFSOBRENOME);
		TFSOBRENOME.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(10, 174, 46, 14);
		contentPane.add(lblNewLabel_3);

		TFCPF = new JTextField();
		TFCPF.setEditable(false);
		TFCPF.setBounds(84, 171, 294, 20);
		contentPane.add(TFCPF);
		TFCPF.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Salario:");
		lblNewLabel_4.setBounds(10, 209, 46, 14);
		contentPane.add(lblNewLabel_4);

		TFSALARIO = new JTextField();
		TFSALARIO.setEditable(false);
		TFSALARIO.setBounds(84, 206, 294, 20);
		contentPane.add(TFSALARIO);
		TFSALARIO.setColumns(10);

		TFRG = new JTextField();
		TFRG.setEditable(false);
		TFRG.setBounds(84, 241, 294, 20);
		contentPane.add(TFRG);
		TFRG.setColumns(10);

		TFTELEFONE = new JTextField();
		TFTELEFONE.setEditable(false);
		TFTELEFONE.setBounds(84, 276, 294, 20);
		contentPane.add(TFTELEFONE);
		TFTELEFONE.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("RG:");
		lblNewLabel_5.setBounds(10, 244, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(10, 279, 46, 14);
		contentPane.add(lblNewLabel_6);

		TFDATADENASCIMENTO = new JTextField();
		TFDATADENASCIMENTO.setEditable(false);
		TFDATADENASCIMENTO.setBounds(122, 308, 256, 20);
		contentPane.add(TFDATADENASCIMENTO);
		TFDATADENASCIMENTO.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Data de Nascimento:");
		lblNewLabel_7.setBounds(10, 311, 113, 14);
		contentPane.add(lblNewLabel_7);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 339, 387, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("Deletar Registro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO botao deletar
				String rcid = TFIDENTIFICADOR.getText();
				int idenvio = 0;
				idenvio = Integer.parseInt(rcid);
				PessoaDao deletarpessoa = new PessoaDao();
				try {
					boolean retorno = deletarpessoa.deletar(idenvio);
					if (retorno == true) {
						JOptionPane.showMessageDialog(null, "\nDeletado com sucesso !", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// Limpando os campos
				TFIDENTIFICADOR.setText("");
				TFID.setText("");
				TFNOME.setText("");
				TFSOBRENOME.setText("");
				TFCPF.setText("");
				TFSALARIO.setText("");
				TFRG.setText("");
				TFTELEFONE.setText("");
				TFDATADENASCIMENTO.setText("");

			}

		});
		btnNewButton_1.setIcon(new ImageIcon(Deletar.class.getResource("/img/user_delete.png")));
		btnNewButton_1.setBounds(10, 33, 122, 23);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Gerar Relatorio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorio = new Relatorio();
				relatorio.setLocationRelativeTo(null);
				relatorio.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Deletar.class.getResource("/img/arrow_refresh.png")));
		btnNewButton_2.setBounds(142, 33, 125, 23);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Cancelar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Deletar.class.getResource("/img/cancel.png")));
		btnNewButton_3.setBounds(282, 33, 95, 23);
		panel_1.add(btnNewButton_3);

		JLabel lblNewLabel_8 = new JLabel("ID:");
		lblNewLabel_8.setBounds(10, 78, 46, 14);
		contentPane.add(lblNewLabel_8);

		TFIDENTIFICADOR = new JTextField();
		TFIDENTIFICADOR.setEditable(false);
		TFIDENTIFICADOR.setBounds(84, 70, 294, 20);
		contentPane.add(TFIDENTIFICADOR);
		TFIDENTIFICADOR.setColumns(10);
	}
}
