package br.com.diego.financas.teste;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.diego.financas.modelo.Conta;
import br.com.diego.financas.modelo.Movimentacao;
import br.com.diego.financas.modelo.TipoMovimentacao;
import br.com.diego.financas.util.JPAUtil;

public class TesteJPA {
	public static void main(String[] args){
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta oConta = new Conta();
		Conta oConta2;
		oConta.setId(1234);
		oConta.setAgencia("1234");
		
		Movimentacao oMovimentacao = new Movimentacao();
		oMovimentacao.setData(Calendar.getInstance());
		oMovimentacao.setDescricao("pagamento bol");
		oMovimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		oMovimentacao.setValor(new BigDecimal("110.20"));
		
		em.getTransaction().begin();
		oConta2 = em.merge(oConta);
		oMovimentacao.setConta(oConta2);
		
		em.persist(oMovimentacao);		
		em.getTransaction().commit();
		em.close();
	}

}
