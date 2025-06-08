package entidades.Quarto;

public class SuitePresidencial extends Quarto{
    private Integer quantidadeSalas;
    private Boolean jacuzzi;

    public SuitePresidencial(Integer numero, Integer andar, boolean status, Double valorDiaria, int quantidadeSalas, boolean jacuzzi) {
        super(numero, andar, status, valorDiaria);
        this.quantidadeSalas = quantidadeSalas;
        this.jacuzzi = jacuzzi;
    }

    @Override
    public Double calculaDiaria() {
        return null;
    }
}