package cadastro.de.pessoas.wiew;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cadastro.de.pessoas.model.Pessoa;
import dao.PessoaDao;

public class Relatorio extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Relatorio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorio.class.getResource("/img/report.png")));
		setResizable(false);
		setTitle("Sistema de Cadastro - Relatorio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelSul, BorderLayout.SOUTH);

		JButton btnExecutarRelatorio = new JButton("Executar Relatorio");
		btnExecutarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Criando lista
				PessoaDao resultado = new PessoaDao();
				try {
					List<Pessoa> pessoas = resultado.lista();
					// TODO Codigo para popular JTable
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					table.setModel(modelo);
					// TODO Resposalvel pela limpeza das linhas
					int numeroLinhas = modelo.getRowCount();
					for(int i=0; i<numeroLinhas;i++)
						modelo.removeRow(0);
					
					Object[] elementos = new Object[8];
						for (Pessoa p : pessoas) {
							elementos[0] = p.getId();
							elementos[1] = p.getNome();
							elementos[2] = p.getSobrenome();
							elementos[3] = p.getCpf();
							elementos[4] = p.getData_nacimento();
							elementos[5] = p.getSalario();
							elementos[6] = p.getRg();
							elementos[7] = p.getTelefone();
							modelo.addRow(elementos);
						    }
						
					/*** FIM **/
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Verificar a Conexao ao Banco de Dados \n" + "", "Alerta",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnExecutarRelatorio.setIcon(new ImageIcon(Relatorio.class.getResource("/img/arrow_refresh.png")));

		JButton btnFechar = new JButton("Cancelar");
		btnFechar.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(Relatorio.class.getResource("/img/cancel.png")));
		GroupLayout gl_panelSul = new GroupLayout(panelSul);
		gl_panelSul.setHorizontalGroup(gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSul.createSequentialGroup().addGap(170)
						.addComponent(btnExecutarRelatorio, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
						.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
						.addGap(89)));
		gl_panelSul.setVerticalGroup(gl_panelSul.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panelSul.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelSul.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExecutarRelatorio, GroupLayout.PREFERRED_SIZE, 38,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panelSul.linkSize(SwingConstants.VERTICAL, new Component[] { btnExecutarRelatorio, btnFechar });
		gl_panelSul.linkSize(SwingConstants.HORIZONTAL, new Component[] { btnExecutarRelatorio, btnFechar });
		panelSul.setLayout(gl_panelSul);

		JPanel panelNorte = new JPanel();
		panelNorte.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelNorte, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Relatorios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_panelNorte = new GroupLayout(panelNorte);
		gl_panelNorte.setHorizontalGroup(gl_panelNorte.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorte.createSequentialGroup().addContainerGap(400, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
						.addGap(161)));
		gl_panelNorte.setVerticalGroup(
				gl_panelNorte.createParallelGroup(Alignment.LEADING).addGroup(gl_panelNorte.createSequentialGroup()
						.addContainerGap().addComponent(lblNewLabel).addContainerGap(20, Short.MAX_VALUE)));
		panelNorte.setLayout(gl_panelNorte);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelCentro.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Sobre Nome", "CPF", "Data de Nascimento", "Salario", "RG", "Telefone" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, Integer.class, String.class,
					Double.class, Integer.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(4).setPreferredWidth(121);

		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();

		renderer.setHorizontalAlignment(JLabel.LEFT);

		scrollPane.setViewportView(table);
	}
}
