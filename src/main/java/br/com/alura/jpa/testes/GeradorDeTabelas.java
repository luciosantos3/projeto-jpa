package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorDeTabelas {
	
	public static void main(String[] args) {
		/*
		 * Na primeira vez que essa classe for executada
		   uma tabela sera criada a partir da referência "<persistence-unit name=\"contas\">"
		   no arquivo "persistence.xml" do projeto.
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}
}
