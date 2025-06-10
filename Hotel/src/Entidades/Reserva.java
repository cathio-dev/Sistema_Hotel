package Entidades;
import java.time.LocalDate;

import Servicos.GerenciadorDeServicos;

public class Reserva {
    private LocalDate entrada;
    private LocalDate saida;
    private Hospede hospede;
    private GerenciadorDeServicos Servicos;

    private Quarto quarto;

    public Reserva() {

    }

    public Reserva(LocalDate entrada, LocalDate saida, Hospede hospede, GerenciadorDeServicos servicos, Quarto quarto) {
        this.entrada = entrada;
        this.saida = saida;
        this.hospede = hospede;
        Servicos = servicos;
        this.quarto = quarto;
        quarto.reservarQuarto();
    }

    public Double calcularTotalReserva() {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(entrada, saida);
        double valorQuarto = quarto.getValorDiaria() * dias;
        double valorServicos = Servicos.calcularValorServicos();
        double desconto = 0;

        if (hospede instanceof HospedeCorporativo) {
            desconto = HospedeCorporativo.DESCONTO_HOSPEDECORPORATIVO;
        } else if (hospede instanceof HospedeFidelidade) {
            desconto = HospedeFidelidade.DESCONTO_HOSPEDEFIDELIDADE;
        } else if (hospede instanceof HospedeVIP) {
            desconto = HospedeVIP.DESCONTO_HOSPEDEVIP;
        }

        return (valorQuarto + valorServicos) * (1 - desconto);
    }

    public Quarto getQuarto() {
        return this.quarto;
    }
}
