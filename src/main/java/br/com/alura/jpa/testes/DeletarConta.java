package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class DeletarConta {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//Busca o objeto desejado para deletar
		// Tranforma de Transient > Managed
		Conta conta = em.find(Conta.class, 4l);
		
		em.getTransaction().begin();
		
		//Deleta o Objeto
		// Tranforma de Managed > Removed;
		em.remove(conta);
		em.getTransaction().commit();
	}
	
}
