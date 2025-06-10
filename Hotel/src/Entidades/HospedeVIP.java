package Entidades;

public class HospedeVIP implements Hospede{

    private String nome;
    private Integer cadastro;

    //Desconto fixo para hospede vip
    public static final double DESCONTO_HOSPEDEVIP = 0.2;

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
