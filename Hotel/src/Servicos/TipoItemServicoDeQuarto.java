package Servicos;

public enum TipoItemServicoDeQuarto {
    //Itens de Alimento
    AGUA("Água", 3.00),
    REFRIGERANTE("Refrigerante", 5.50),
    SANDUICHE("Sanduíche", 12.0),
    DOCE("Sobremesa especial", 7.00),

    //Higiene e outros
    KIT_HIGIENE("Kit de higiene pessoal", 8.00),
    TOALHA_EXTRA("Toalha extra", 5.00),
    TRAVESSEIRO_EXTRA("Travesseiro extra", 6.00),
    COBERTOR_EXTRA("Cobertor extra", 7.00),
    ROUPAO("Aluguel de roupão", 10.00),

    //Entretenimento
    VIDEO_GAME("Consolde de videogame", 18.00);

    private final String descricao;
    private final double preco;

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    private TipoItemServicoDeQuarto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
}
