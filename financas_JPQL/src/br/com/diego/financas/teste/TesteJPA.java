package br.com.diego.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.diego.financas.modelo.Conta;

public class TesteJPA {
	public static void main(String[] args){
		Conta oConta = new Conta();
		oConta.setId(1);
		oConta.setAgencia("1234");
		oConta.setBanco("ITAU");
		oConta.setNumero("1234");
		oConta.setTitular("Diego");
		
		EntityManagerFactory oEntityManagerFactory = Persistence.createEntityManagerFactory("financas");
		EntityManager oEntityManager = oEntityManagerFactory.createEntityManager();
		
		oEntityManager.getTransaction().begin();		
		oEntityManager.merge(oConta);
		oEntityManager.getTransaction().commit();
		
		oEntityManager.close();
	}
}
