package cadastro.de.pessoas.wiew;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Main {

	private JFrame frmSistemaDeCadastro;
	private JLabel JLHora;
	private JLabel JLData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmSistemaDeCadastro.setVisible(true);
					window.frmSistemaDeCadastro.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeCadastro = new JFrame();
		frmSistemaDeCadastro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// data
				Date dataSistema = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
				JLData.setText(formato.format(dataSistema));

				// hora
				Timer timer = new Timer(1000, new hora());
				timer.start();

			}
		});
		frmSistemaDeCadastro
				.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/layout.png")));
		frmSistemaDeCadastro.setResizable(false);
		frmSistemaDeCadastro.setTitle("Sistema de Cadastro");
		frmSistemaDeCadastro.setBounds(100, 100, 1040, 584);
		frmSistemaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeCadastro.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem MenuItemSair = new JMenuItem("Sair");
		MenuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		MenuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		MenuItemSair.setIcon(new ImageIcon(Main.class.getResource("/img/door_out.png")));
		mnArquivo.add(MenuItemSair);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenu NewMenuPessoas = new JMenu("Pessoas");
		mnCadastro.add(NewMenuPessoas);

		JMenuItem MenuItemAdicionar = new JMenuItem("Adicionar");
		MenuItemAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar adicionar = new Adicionar();
				adicionar.setLocationRelativeTo(null);
				adicionar.setVisible(true);
			}
		});
		MenuItemAdicionar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_MASK));
		MenuItemAdicionar.setIcon(new ImageIcon(Main.class.getResource("/img/user_add.png")));
		NewMenuPessoas.add(MenuItemAdicionar);

		JMenuItem MenuItemAtualizar = new JMenuItem("Atualizar");
		MenuItemAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atualizar atualizar = new Atualizar();
				atualizar.setLocationRelativeTo(null);
				atualizar.setVisible(true);
			}
		});
		MenuItemAtualizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, InputEvent.ALT_MASK));
		MenuItemAtualizar.setIcon(new ImageIcon(Main.class.getResource("/img/user_edit.png")));
		NewMenuPessoas.add(MenuItemAtualizar);

		JMenuItem MenuItemDeletar = new JMenuItem("Deletar");
		MenuItemDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletar deletar = new Deletar();
				deletar.setLocationRelativeTo(null);
				deletar.setVisible(true);
			}
		});
		MenuItemDeletar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, InputEvent.ALT_MASK));
		MenuItemDeletar.setIcon(new ImageIcon(Main.class.getResource("/img/user_delete.png")));
		NewMenuPessoas.add(MenuItemDeletar);

		JMenu mnRelatorio = new JMenu("Relatorio");
		mnRelatorio.setIcon(null);
		menuBar.add(mnRelatorio);

		JMenuItem MenuItemRelatorio = new JMenuItem("Relatorio");
		MenuItemRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorio = new Relatorio();
				relatorio.setLocationRelativeTo(null);
				relatorio.setVisible(true);
			}
		});
		MenuItemRelatorio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, InputEvent.ALT_MASK));
		MenuItemRelatorio.setIcon(new ImageIcon(Main.class.getResource("/img/report.png")));
		mnRelatorio.add(MenuItemRelatorio);

		JMenu mnInformacao = new JMenu("Informacao");
		mnInformacao.setIcon(null);
		menuBar.add(mnInformacao);

		JMenuItem MenuItemContato = new JMenuItem("Contato");
		MenuItemContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contato contato = new Contato();
				contato.setLocationRelativeTo(null);
				contato.setVisible(true);
			}
		});
		MenuItemContato.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, InputEvent.ALT_MASK));
		MenuItemContato.setIcon(new ImageIcon(Main.class.getResource("/img/feed.png")));
		mnInformacao.add(MenuItemContato);
		frmSistemaDeCadastro.getContentPane().setLayout(null);

		JLabel lblNewLabellog = new JLabel("");
		lblNewLabellog.setIcon(new ImageIcon(Main.class.getResource("/img/logo_if_resize.png")));
		lblNewLabellog.setBounds(673, 346, 341, 129);
		frmSistemaDeCadastro.getContentPane().add(lblNewLabellog);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(-13, 477, 1052, 57);
		frmSistemaDeCadastro.getContentPane().add(panel);
		panel.setLayout(null);

		JLHora = new JLabel("");
		JLHora.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLHora.setBounds(890, 11, 121, 21);
		JLHora.setHorizontalAlignment(SwingConstants.CENTER);
		JLHora.setForeground(Color.BLUE);
		JLHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(JLHora);

		JLData = new JLabel("");
		JLData.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLData.setHorizontalAlignment(SwingConstants.CENTER);
		JLData.setForeground(Color.BLUE);
		JLData.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLData.setBounds(760, 11, 121, 21);
		panel.add(JLData);
	}

	// classe hora
	class hora implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar now = Calendar.getInstance();
			JLHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
		}
	}

}// fim da classe principal
