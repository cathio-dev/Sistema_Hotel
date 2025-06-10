package Entidades;

public class QuartoFamilia extends Quarto{
    private Integer capacidadePessoas;
    private Boolean cozinha;
    public QuartoFamilia(Integer numero, Integer andar, boolean status, Double valorBase, int capacidadePessoas, boolean cozinha) {
        super(numero, andar, status);
        this.capacidadePessoas = capacidadePessoas;
        this.cozinha = cozinha;
        this.valorDiaria = calculaDiaria(valorBase);
    }

    @Override
    public Double calculaDiaria(Double valorBase) {
    	double taxasQuartoFamilia = 0.00;
    	
    	if (cozinha != null && cozinha) {
    		taxasQuartoFamilia += 35.00;
    	}
    	
    	if(capacidadePessoas > 1) {
    		taxasQuartoFamilia += capacidadePessoas * 10.00;
    	} else if(capacidadePessoas == 1){
    		taxasQuartoFamilia += 10.00;
    	}
        return valorBase + taxasQuartoFamilia;
    }
}
