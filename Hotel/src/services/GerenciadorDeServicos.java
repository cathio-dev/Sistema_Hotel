package services;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeServicos {
	private List<Servico> servicos;
	
	public GerenciadorDeServicos() {
		this.servicos = new ArrayList<>();
	}
	
	public void adicionarServico(Servico servico) {
		servicos.add(servico);
	}
	
	public void removerServico(Servico servico) {
		servicos.remove(servico);
	}
	
	public Double calcularValorServicos() {
		double valorServico= 0.00;
		for(Servico servico : servicos) {
			valorServico += servico.getPreco();
		}
		
		return valorServico;
	}

}
