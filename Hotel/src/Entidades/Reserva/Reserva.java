
import java.time.LocalDate;

public class Reserva{
    private LocalDate entrada;
    private LocalDate saida;
    protected Double valorTotal;
    private GerenciadorQuartos gerenciadorQuartos;
    private GerenciadorServicos gerenciadorServicos;

    public Reserva(){

    }

    public Reserva(LocalDate entrada, LocalDate saida, Double valorTotal) {
        this.entrada = entrada;
        this.saida = saida;
        this.valorTotal = valorTotal;
        this.gerenciadorQuartos = new GerenciadorDeQuartos();
        this.gerenciadorServicos = new GerenciadorDeServicos();
    }

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public LocalDate getSaida() {
		return saida;
	}

	public void setSaida(LocalDate saida) {
		this.saida = saida;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public GerenciadorDeQuartos getGerenciadorQuartos() {
		return gerenciadorQuartos;
	}

	public void setGerenciadorQuartos(GerenciadorDeQuartos gerenciadorQuartos) {
		this.gerenciadorQuartos = gerenciadorQuartos;
	}

	public GerenciadorDeServicos getGerenciadorServicos() {
		return gerenciadorServicos;
	}

	public void setGerenciadorServicos(GerenciadorDeServicos gerenciadorServicos) {
		this.gerenciadorServicos = gerenciadorServicos;
	}

    @Override
public String toString() {
    return "Reserva {" +
            "entrada=" + entrada +
            ", saida=" + saida +
            ", valorTotal=" + valorTotal +
            ", gerenciadorQuartos=" + (gerenciadorQuartos != null ? gerenciadorQuartos.toString() : "null") +
            ", gerenciadorServicos=" + (gerenciadorServicos != null ? gerenciadorServicos.toString() : "null") +
            '}';
}

}