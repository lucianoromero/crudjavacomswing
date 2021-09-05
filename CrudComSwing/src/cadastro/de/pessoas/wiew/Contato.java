package cadastro.de.pessoas.wiew;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contato extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contato frame = new Contato();
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
	public Contato() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Contato.class.getResource("/img/feed.png")));
		setTitle("Sistema de Cadastro - Contato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trabalho Realizado: Luciano Luiz Romero \r\n");
		lblNewLabel.setBounds(10, 19, 322, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail: lucianoluizromero@gmail.com");
		lblNewLabel_1.setBounds(10, 42, 322, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Versao: 0.1");
		lblNewLabel_2.setBounds(10, 78, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Clique e Assista ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					URI link = new URI("https://www.youtube.com/watch?v=h3dGKEDIEl0");
					Desktop.getDesktop().browse(link);
				} catch (Exception erro) {
					System.out.println(erro);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Contato.class.getResource("/img/bullet_error.png")));
		btnNewButton.setBounds(163, 69, 187, 23);
		contentPane.add(btnNewButton);
	}
}
