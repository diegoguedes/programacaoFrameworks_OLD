package br.com.diego.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.diego.financas.enumeracao.TipoMovimentacao;
import br.com.diego.financas.modelo.Conta;
import br.com.diego.financas.modelo.Movimentacao;

public class TesteJPAMovimentacao {
	public static void main(String[] args){
		Conta oConta = new Conta();
		oConta.setAgencia("1234");
		oConta.setBanco("ITAU");
		oConta.setNumero("1234");
		oConta.setTitular("Diego");
		
		Movimentacao oMovimentacao = new Movimentacao();
		oMovimentacao.setData(Calendar.getInstance());
		oMovimentacao.setDescricao("Conta de agua");
		oMovimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		oMovimentacao.setValor(new BigDecimal(120.10));
		
		oMovimentacao.setConta(oConta);
		
		EntityManagerFactory oEntityManagerFactory = Persistence.createEntityManagerFactory("financas");
		EntityManager oEntityManager = oEntityManagerFactory.createEntityManager();
		
		oEntityManager.getTransaction().begin();
		oEntityManager.persist(oConta);
		oEntityManager.persist(oMovimentacao);
		oEntityManager.getTransaction().commit();
		
		oEntityManager.close();
	}
}
