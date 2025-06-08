package entidades.Quarto;

public class QuartoExecutivo extends Quarto{
    private Boolean cafeteira;

    public QuartoExecutivo(Integer numero, Integer andar, boolean status, Double valorDiaria, boolean cafeteira) {
        super(numero, andar, status, valorDiaria);
        this.cafeteira = cafeteira;
    }

    @Override
    public Double calculaDiaria() {
        return null;
    }
}
