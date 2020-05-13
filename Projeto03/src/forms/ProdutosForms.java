package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.ProdutosDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ProdutosForms extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTable table;
	



	/**
	 * Create the frame.
	 */
	public ProdutosForms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 414, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Produto", "Valor"
				}
			));
		scrollPane.setViewportView(table);
		
		JLabel lblCadastrar = new JLabel("Cadastrar nome: ");
		lblCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastrar.setBounds(10, 11, 127, 19);
		contentPane.add(lblCadastrar);
		
		JLabel lblNewLabel = new JLabel("Valor:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(275, 11, 45, 19);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(133, 12, 104, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(320, 12, 104, 20);
		contentPane.add(txtValor);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obter nome e valor
				String nome = txtNome.getText();
				double valor = Double.parseDouble(txtValor.getText());
				
				//Executar método de cadastro
				ProdutosDao.cadastrar(nome, valor);
				
				//Mensagem
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				
				//Limpar campos
				txtNome.setText("");
				txtValor.setText("");
			}
		});
		btnCadastrar.setBounds(149, 235, 136, 23);
		contentPane.add(btnCadastrar);
		
		
	}
}
