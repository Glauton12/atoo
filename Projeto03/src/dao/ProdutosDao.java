package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import db.Conexao;

public class ProdutosDao {
	
	//Inserir
		public static void cadastrar(String nome, double valor) {
			
			//SQL
			String sql = "INSERT INTO produtos (nome, valor) VALUES (?,?)";
			
			//Instanciar um obj da classe conexao
			Conexao.obterConexao();
			
			//Tentativa
			try {
				//PreparedStatement
				PreparedStatement pstmt = Conexao.con.prepareStatement(sql);
				//Parametros
				pstmt.setString(1, nome);
				pstmt.setDouble(2, valor);
				//Executar o comando
				pstmt.execute();
				}catch(Exception erro) {
				System.out.println("Falha ao inserir "+erro.getMessage());
			}finally {
				Conexao.removerConexao();
			}
			
		}
		
		//Selecionar
		
		public static DefaultTableModel  selecionar() {
			
			// DefaultTableModel
			DefaultTableModel dados = new DefaultTableModel();
			
			// Colunas
			dados.addColumn("Código");
			dados.addColumn("Produto");
			dados.addColumn("Valor");
			
			//sql
			String sql = "SELECT * FROM clientes";
			
			//instanciar um obj da classe conexao
			Conexao c = new Conexao();
			
			//Tentativa
			try{
			
			//Interface statement
			Statement stmt = Conexao.con.createStatement();
			
			//Armazenar dados
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dados.addRow(new Object[] {
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3)
				});
			}
		
			}catch(Exception erro) {
				System.out.println("Falha ao listar "+erro.getMessage());
			}finally {
				Conexao.removerConexao();
			}
			
			return dados;
		}




}
