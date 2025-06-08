package entidades.Quarto;

public class QuartoSimples extends Quarto{
    public QuartoSimples(Integer numero, Integer andar, boolean status, Double valorDiaria) {
        super(numero, andar, status, valorDiaria);
    }
    @Override
    public Double calculaDiaria() {
        return null;
    }
}
