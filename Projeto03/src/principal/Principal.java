package principal;

import java.sql.SQLException;

import forms.ProdutosForms;

import db.Conexao;

public class Principal {

	public static void main(String[] args) {
		
		//Formulario de login
		ProdutosForms f = new ProdutosForms();
		f.setVisible(true);
	}

}
