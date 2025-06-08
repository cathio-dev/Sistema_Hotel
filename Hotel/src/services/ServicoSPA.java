package services;

public class ServicoSPA implements Servico{
	private String descricao;
	private Double preco;
	
	public ServicoSPA(TipoServicoSPA tipo) {
		this.descricao = tipo.getDescricao();
		this.preco = tipo.getPreco();
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public Double getPreco() {
		return preco;
	}

	public ServicoSPA(String descricao, Double preco) {
		super();
		this.descricao = descricao;
		this.preco = preco;
	}
	
	
	
	
}
