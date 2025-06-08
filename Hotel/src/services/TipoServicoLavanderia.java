package services;

public enum TipoServicoLavanderia {
	ROUPAS_COMUNS("Lavagem de roupas comuns", 3.50),
	ROUPAS_DELICADAS("Lavagem de roupas delicadas", 7.0);
	
	private final String descricao;
	private final double precoPorPeca;
	
	private TipoServicoLavanderia(String descricao, double precoPorPeca) {
		this.descricao = descricao;
		this.precoPorPeca = precoPorPeca;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPrecoPorPeca() {
		return precoPorPeca;
	}
	
}
