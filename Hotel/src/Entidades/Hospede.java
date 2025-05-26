package Entidades;

public class Hospede {
    private String nome;
    private Integer CPF;

    public Hospede(String nome, Integer CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }


}
