package Servicos;
import java.util.List;
import Entidades.Item;
import java.util.ArrayList;

public class ServicoDeQuarto implements Servico{
    private List<Item> itens;

    public ServicoDeQuarto() {
        this.itens = new ArrayList<>();
    }
    public ServicoDeQuarto(List<Item> itens) {
        this.itens = new ArrayList<>(itens);
    }

    public void entregarItem(Item item) {
        itens.add(item);
    }

    @Override
    public String getDescricao() {
        StringBuilder sb = new StringBuilder("Itens Solicitados:\n ");
        if(itens.isEmpty()) {
            return "Nenhum item de serviço de quarto foi solicitado";
        } else {

            for(Item item : itens) {
                sb.append(item.getDescricao() + "\n");
            }
        }

        return sb.toString();
    }

    @Override
    public Double getPreco() {
        double preco = 0;
        for(Item item : itens) {
            preco += item.getPreco();
        }
        return preco;
    }

    @Override
    public String toString() {
        return getDescricao() + " = R$ " + String.format("%.2f", getPreco());
    }
}
