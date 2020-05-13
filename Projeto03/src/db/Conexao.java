package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	//Atributos
	private static final String usuario = "root";
	private static final String senha = "160997";
	private static final String base = "java03";
	private static final String endereco = "jdbc:mysql://localhost/";
	
	public static Connection con = null;
	
	//Efetuar conexão
	public static void obterConexao() {
		
		try {
			con = DriverManager.getConnection(endereco+base, usuario, senha);
			System.out.println("Conexao OK");
		}catch(Exception erro) {
			System.out.println(erro.getMessage());
			
		}
		
	}
	//remover conexao
	public static void removerConexao() {
		try {
			con.close();
		}catch(Exception erro) {
			System.out.println("Falha ao remover conexao");
		}
	}
}
