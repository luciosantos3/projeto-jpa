package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamento {

	public static void main(String[] args) {

		//Transient
		Conta conta = new Conta();
		conta.setAgencia(0001);
		conta.setNumero(678901);
		conta.setTitular("Layla Lima");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal(60.0));
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			//Tranformando os estados de Transient > Managed.
			em.persist(conta);
			em.persist(movimentacao);
		
		em.getTransaction().commit();
		
	}

}
