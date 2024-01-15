package br.com.agenda.aplicação;



import java.util.Date;

import br.com.agenda.Contato;
import br.com.agenda.dao.ContatoDAO;

public class Main {
	
	public static void main(String[] args) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato = new Contato();
		
		contato.setNome("Miyamoto Musashi");
		contato.setIdade(24);
		contato.setDataCadastro(new Date());
		
		//Salvando o Contato
		contatoDAO.save(contato);
		
		
		
		Contato c1 = new Contato();
		
		
		//Atualizando o Contato
		c1.setNome("Miyamoto Musashi");
		c1.setIdade(34);
		c1.setDataCadastro(new Date());
		c1.setId(1);
		
		//Método que faz as atualizações.
		contatoDAO.update(c1);
		
		
		
		
		//Deleta o contato pelo seu número de ID
		contatoDAO.deleteByID(1);
		
		
		
		
		
		//Visualização de todos os registros no Banco de dados
		
		for(Contato C : ContatoDAO.getContatos()) {
			
			System.out.println("Contato: " + C.getNome());
		}
		
		
		
		
	}

}
