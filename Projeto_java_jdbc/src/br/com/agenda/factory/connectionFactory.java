package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionFactory {
	
	//Nome do Usuario do postgresql.
	private static final  String USERNAME = "postgres";
	
	//Senha de acesso ao BD.
	private static final  String PASSWORD = "igor1010";
	
	//url de acesso ao BD.
	private static final  String URL = "jdbc:postgresql://localhost:5432/Agenda";
	
	
	//Conexão com o banco de dados.
	public static Connection createConnection() throws Exception {
	
		
	//Cria a conexão com o BD
	Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	
	return connection;
	};
	
	
	public static void main(String[] args) throws Exception {
		
		
				//Recupera a conexão com banco de dados.
				Connection con = createConnection();
				
				// Testa se a conexão é nula.
				if(con != null) {
					System.out.println("Conexão obtida com sucesso");
					con.close();
				}		
				
			
		
		
	}
	
	

}
