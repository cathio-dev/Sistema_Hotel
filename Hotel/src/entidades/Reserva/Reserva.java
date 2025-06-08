package entidades.Reserva;

import java.time.LocalDate;

import entidades.Hospede.Hospede;
import services.GerenciadorDeServicos;

public class Reserva {
	private LocalDate entrada;
	private LocalDate saida;
	private Hospede hospede;
	private GerenciadorDeServicos Servicos;
	
	public Reserva() {
		
	}

	public Reserva(LocalDate entrada, LocalDate saida, Hospede hospede, GerenciadorDeServicos servicos) {
		this.entrada = entrada;
		this.saida = saida;
		this.hospede = hospede;
		Servicos = servicos;
	}
	
	
}
