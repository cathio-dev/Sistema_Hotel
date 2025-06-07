package services;

public enum TipoServicoSPA {
	MASSAGEM_RELAXANTE("Massagem Relaxante", 150.0),
	BANHO_DE_ERVAS("Banho de Ervas", 100.0),
	LIMPEZA_DE_PELE("Limpeza de Pele", 120.0),
	AROMATERAPIA("Aromaterapia", 130.0);
	
	private final String descricao;
	private final double preco;
	
	private TipoServicoSPA(String descricao, double preco) {
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Double getPreco() {
		return preco;
	}
}
