package Entidades;

public abstract class Quarto {
    private Integer numero;
    private Integer andar;
    private boolean status;

    protected Double valorDiaria;

    public Quarto(Integer numero, Integer andar, boolean status) {
        this.numero = numero;
        this.andar = andar;
        this.status = status;
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
        return "Quarto" +
                " numero " + numero +
                ", andar " + andar +
                ", com diaria no valor de: R$ " + String.format("%.2f", valorDiaria) + ".";
    }

    public abstract Double calculaDiaria(Double valorDiaria);

    public void reservarQuarto(){
        this.status = true;
    }

    public void liberarQuarto(){
        this.status = false;
    }

}
