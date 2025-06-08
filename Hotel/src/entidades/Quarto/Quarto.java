package entidades.Quarto;

public abstract class Quarto {
    private Integer numero;
    private Integer andar;
    private boolean status;

    private Double valorDiaria;

    public Quarto(Integer numero, Integer andar, boolean status, Double valorDiaria) {
        this.numero = numero;
        this.andar = andar;
        this.status = status;
        this.valorDiaria = valorDiaria;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", andar=" + andar +
                ", status=" + status +
                ", valorDiaria=" + valorDiaria +
                '}';
    }

    public abstract Double calculaDiaria();

    //sera feito no gerenciador

    // public void reservarQuarto(){

    // }

    // public void liberarQuarto(){

    // }

}
