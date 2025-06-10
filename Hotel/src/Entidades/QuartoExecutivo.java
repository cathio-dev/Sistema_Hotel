package Entidades;

public class QuartoExecutivo extends Quarto{
    private Boolean cafeteira;

    public QuartoExecutivo(Integer numero, Integer andar, boolean status, Double valorBase, boolean cafeteira) {
        super(numero, andar, status);
        this.cafeteira = cafeteira;
        this.valorDiaria = calculaDiaria(valorBase);
    }

    @Override
    public Double calculaDiaria(Double valorBase) {
    	double extra = 0.0;
    	if(cafeteira != null && cafeteira) {
    		extra += 20.00;
    	}
        return valorBase + extra;
    }
}
