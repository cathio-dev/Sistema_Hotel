package Entidades;

public class QuartoSimples extends Quarto{
    public QuartoSimples(Integer numero, Integer andar, boolean status, Double valorBase) {
        super(numero, andar, status);
        this.valorDiaria = calculaDiaria(valorBase);
    }
    @Override
    public Double calculaDiaria(Double valorBase) {
        return valorBase;
    }
}
