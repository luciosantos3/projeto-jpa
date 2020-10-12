package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteDeEstados {
	
	public static void main(String[] args) {
		
		//Transient
		Conta conta = new Conta();
		conta.setAgencia(0001);
		conta.setNumero(567890);
		conta.setTitular("Miguel Paula");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			//Transient > Managed
			em.persist(conta);
		
			//Managed > Removed
			em.remove(conta);
		
		em.getTransaction().commit();
	}
}
