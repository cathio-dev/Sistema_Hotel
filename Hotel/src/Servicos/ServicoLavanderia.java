package Servicos;


public class ServicoLavanderia implements Servico{

    private String descricao;
    private Double preco;
    private Integer quantidadePecas;

    public ServicoLavanderia(Integer quantidadePecas, TipoServicoLavanderia tipo) {
        this.quantidadePecas = quantidadePecas;
        this.preco = tipo.getPrecoPorPeca();
        this.descricao = tipo.getDescricao();
    }

    @Override
    public String getDescricao() {
        return descricao + " - " + quantidadePecas + " peças";
    }

    @Override
    public Double getPreco() {
        double valorTotal;
        valorTotal = preco * quantidadePecas;
        return valorTotal;
    }

    @Override
    public String toString() {
        return getDescricao() + " = R$ " + String.format("%.2f", getPreco());
    }
}
