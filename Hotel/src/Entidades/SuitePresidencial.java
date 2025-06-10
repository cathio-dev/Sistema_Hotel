package Entidades;

public class SuitePresidencial extends Quarto{
    private Integer quantidadeSalas;
    private Boolean jacuzzi;

    public SuitePresidencial(Integer numero, Integer andar, boolean status, Double valorBase, int quantidadeSalas, boolean jacuzzi) {
        super(numero, andar, status);
        this.quantidadeSalas = quantidadeSalas;
        this.jacuzzi = jacuzzi;
        this.valorDiaria = calculaDiaria(valorBase);
    }

    @Override
    public Double calculaDiaria(Double valorBase) {
    	double taxasSuite = 0.00;
    	double adicionalSalas = 0.00;
        if(jacuzzi != null && jacuzzi) {
        	taxasSuite += 100.00;
        }
        if(quantidadeSalas != null) {
        	adicionalSalas = quantidadeSalas * 50.0;
        }
        
        
        return valorBase + adicionalSalas + taxasSuite;
    }
}