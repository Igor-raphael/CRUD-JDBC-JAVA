package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.Contato;
import br.com.agenda.factory.connectionFactory;

public class ContatoDAO {
	
	/*
	 * CRUD
	 * 
	 * C: CREATE - OK - INSERT
	 * R: READ  - OK - SELECT
	 * U: UPDATE - OK - UPDATE
	 * D: DELETE - OK - DELETE
	 */

	public void save (Contato contato) {
		
		String sql = "INSERT INTO contatos (nome, idade, datacadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criamos a conexão com o Banco de Dados.
			conn = connectionFactory.createConnection();
			
			//Criamos uma PreparedStatement, para executar a Query
			pstm = conn.prepareStatement(sql);
			
			//Adionando os valores esperados pela Query
		   pstm.setString(1, contato.getNome());
		   pstm.setInt(2, contato.getIdade());
		   pstm.setDate(3, new Date (contato.getDataCadastro().getTime()));
		   
		   //Executar a Query
		   pstm.execute();
		   
		   System.out.println("Contato Salvo com Sucesso");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			// Fechar as conexões
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
		}
		
	}
	
	
	
	public static List<Contato> getContatos() {

		String sql = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<Contato>();

		Connection conn = null;

		PreparedStatement pstm = null;
		
       //Classe que vai recuperar os dados do banco
		ResultSet rset = null;

		try {

			conn = connectionFactory.createConnection();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Contato contato = new Contato();

				// Recupera o ID
				contato.setId(rset.getInt("id"));

				// Recupera o NOME
				contato.setNome(rset.getString("nome"));

				// Recupera a IDADE
				contato.setIdade(rset.getInt("idade"));

				// Recupera a DATA DO CADASTRO
				contato.setDataCadastro(rset.getDate("datacadastro"));

				contatos.add(contato);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return contatos;

	}
	
	
	
	public void update(Contato contato) {
		
		String sql = " UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? " +
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria a conexão com o banco de dados
			conn = connectionFactory.createConnection();
			
			//Cria a classe para executar a Query
			pstm = conn.prepareStatement(sql);
			
			//Adicionar os valores esperados pela Query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Aqui é onde sera colocado o ID escolhido.
			pstm.setInt(4, contato.getId());
			
			//Executar a Query
			pstm.execute();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				   if(pstm != null) {
					   pstm.close();
				   }
				   
				   if(conn != null) {
					   conn.close();
				   }
				   
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//Sera deletado via ID por conveniência ao Banco de dados.
	public void deleteByID(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = connectionFactory.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			System.out.println("Contato Deletado com Sucesso.");
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			try {
		          	if(pstm != null) {
				         pstm.close();
			           }
			
			
			        if(conn != null) {
				         conn.close();
			           }
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
}
