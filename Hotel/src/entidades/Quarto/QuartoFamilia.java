package entidades.Quarto;

public class QuartoFamilia extends Quarto{
    private Integer capacidadePessoas;
    private Boolean cozinha;
    public QuartoFamilia(Integer numero, Integer andar, boolean status, Double valorDiaria, int capacidadePessoas, boolean cozinha) {
        super(numero, andar, status, valorDiaria);
        this.capacidadePessoas = capacidadePessoas;
        this.cozinha = cozinha;
    }

    @Override
    public Double calculaDiaria() {
        return null;
    }
}
