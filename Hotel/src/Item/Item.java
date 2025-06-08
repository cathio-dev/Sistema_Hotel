package Item;

public class Item{
    private String descricao;
    private Double preco;

    public Item(String descricao, Double preco){
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "Item{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}

