import java.time.LocalDate;

public class Reserva {
    private LocalDate entrada;
    private LocalDate saida;
    private Double valorTotal;
    private Quarto quarto;
    private Hospede hospede;
    private GerenciadorDeServicos gerenciadorServicos;

    public Reserva() {

        this.gerenciadorServicos = new GerenciadorDeServicos();
    }

    public Reserva(LocalDate entrada, LocalDate saida, Double valorTotal) {
        this.entrada = entrada;
        this.saida = saida;
        this.valorTotal = valorTotal;
        this.gerenciadorServicos = new GerenciadorDeServicos();
    }

    // Getters e Setters
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

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
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
                ", quarto=" + (quarto != null ? quarto.toString() : "null") +
                ", hospede=" + (hospede != null ? hospede.getNome() : "null") +
                ", gerenciadorServicos=" + (gerenciadorServicos != null ? gerenciadorServicos.toString() : "null") +
                '}';
    }
}
