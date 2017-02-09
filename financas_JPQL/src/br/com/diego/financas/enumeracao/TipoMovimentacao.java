package br.com.diego.financas.enumeracao;

public enum TipoMovimentacao {
	ENTRADA(1),SAIDA(0);
	
	private int valor;

	private TipoMovimentacao(int valor){
		this.valor = valor;
	}
	public Integer getValor(){
		return this.valor;
	}
	
}
