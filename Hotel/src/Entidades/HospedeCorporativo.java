package Entidades;


public class HospedeCorporativo implements Hospede{
    private String nome;
    private Integer cadastro;

    //Desconto fixo para hospede corporativo
    public static final double DESCONTO_HOSPEDECORPORATIVO = 0.10;

    @Override
    public String getNome(){
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Integer getCadastro() {
        return cadastro;
    }

    @Override
    public void setCadastro(Integer cadastro) {
        this.cadastro = cadastro;
    }
}