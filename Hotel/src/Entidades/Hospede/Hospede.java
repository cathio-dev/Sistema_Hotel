package Hospede;

public abstract class Hospede {

    private String nome;
    private Integer CPF;
    private Reserva reserva;

    public Hospede(String nome, Integer CPF, Reserva reserva) {
        this.nome = nome;
        this.CPF = CPF;
        this.reserva = reserva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    public Reserva getReserva() {
        return CPF;
    }

    public void setReserva(Integer CPF) {
        this.reserva = reserva;
    }

    public abstract Double calcularDesconto(Reserva reserva) {
        Double valorDesconto = 0.00;
        return valorDesconto;
    }

    @Override
    public String toString() {
        return "Hospede {" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", reserva=" + (reserva != null ? reserva.toString() : "Nenhuma reserva") +
                '}';
    }

}
