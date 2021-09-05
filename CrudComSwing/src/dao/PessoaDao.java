package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import cadastro.de.pessoas.model.Pessoa;
import connection.ConnectFactory;

public class PessoaDao {
	// TODO Classe onde contem os metodos Adicionar Atualizar Deletar

	/******************** Adicionando  *****************/
	public boolean adicionar(Pessoa pessoa) {
		Connection connection = null;
		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into clientes (nome,sobrenome,cpf,data_nascimento,salario,rg,telefone) values(?, ?, ?, ?, ?,?,?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, pessoa.getNome());
			prepare.setString(2, pessoa.getSobrenome());
			prepare.setInt(3, pessoa.getCpf());
			prepare.setString(4, pessoa.getData_nacimento());
			prepare.setDouble(5, pessoa.getSalario());
			prepare.setInt(6, pessoa.getRg());
			prepare.setInt(7, pessoa.getTelefone());
			prepare.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			sucesso = false;
		}
		/* Fechando a conexao Sql */
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return sucesso;
	}


/******************** Metodo Deletar *****************/
	public boolean deletar(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = " DELETE FROM clientes WHERE id = ?";

		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, identificacao);
		// retorna true se foi afetado algum registro
		if (stmt.executeUpdate() > 0) {
			return true;
		}

		stmt.close();
		connection.close();
		return false;

	}

/******************** Metodo Retornando Pessoas *****************/
	public List<Pessoa> lista() throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT * FROM clientes";

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<Pessoa> pessoas = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			String sobrenome = resultado.getString("sobrenome");
			int cpf = resultado.getInt("cpf");
			String data_nacimento = resultado.getString("data_nascimento");
			double salario = resultado.getDouble("salario");
			int rg = resultado.getInt("rg");
			int telefone = resultado.getInt("telefone");
			pessoas.add(new Pessoa(id, nome, sobrenome, cpf, data_nacimento, salario, rg, telefone));
		}

		stmt.close();
		connection.close();

		return pessoas;

	}

	/******************** Consulta por id *****************/
	public List<Pessoa> consultaid(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT id, nome, sobrenome, cpf, data_nascimento, salario,rg,telefone FROM clientes WHERE id = "
				+ identificacao;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<Pessoa> pessoas = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			String sobrenome = resultado.getString("sobrenome");
			int cpf = resultado.getInt("cpf");
			String data_nacimento = resultado.getString("data_nascimento");
			double salario = resultado.getDouble("salario");
			int rg = resultado.getInt("rg");
			int telefone = resultado.getInt("telefone");
			pessoas.add(new Pessoa(id, nome, sobrenome, cpf, data_nacimento, salario, rg, telefone));
		}

		stmt.close();
		connection.close();

		return pessoas;

	}
//**** Metodo UPDATE *****
//TODO REFATORANDO O METODO 	
	
	// Metodo UPDATE
		public boolean atualizar(Pessoa pessoa, int id) throws SQLException {
			Connection connection = ConnectFactory.createConnection();
			String update = "UPDATE clientes SET nome = ?, sobrenome = ?, cpf = ?, "
        			+ "data_nascimento = ?, salario = ?, rg = ?, telefone = ? WHERE clientes.id = ?";
            
			PreparedStatement stmt = connection.prepareStatement(update);
			try {
			stmt = connection.prepareStatement(update);
        	stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSobrenome());
			stmt.setInt(3, pessoa.getCpf());
			stmt.setString(4, pessoa.getData_nacimento());
			stmt.setDouble(5, pessoa.getSalario());
			stmt.setInt(6, pessoa.getRg());
			stmt.setInt(7, pessoa.getTelefone());
			stmt.setInt(8, id);
			stmt.executeUpdate();
			
			stmt.close();
			connection.close();
			return true;
			}catch (SQLException e) {
				return false;
			}
	        
			
			
		}	
	

}
