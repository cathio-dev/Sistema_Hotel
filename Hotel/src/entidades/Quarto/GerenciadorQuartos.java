package entidades.Quarto;

import java.util.Map;
import java.util.TreeMap;

public class GerenciadorQuartos {

    private Map<Integer, Quarto> quartos;

    public GerenciadorQuartos() {
        this.quartos = new TreeMap<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        if (quarto != null) {
            quartos.put(quarto.getNumero(), quarto);
        }
    }

    public void removerQuarto(Integer numero) {
        quartos.remove(numero);
    }

    public Quarto obterQuarto(Integer numero) {
        return quartos.get(numero);
    }

    public void listarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            for (Map.Entry<Integer, Quarto> entry : quartos.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    public void atualizarStatusQuarto(Integer numero, boolean status) {
        Quarto quarto = quartos.get(numero);
        if (quarto != null) {
            quarto.setStatus(status);
        }
    }

    public boolean quartoDisponivel(Integer numero) {
        Quarto quarto = quartos.get(numero);
        if(quarto != null & quarto.isStatus() == true){
            return true;
        }
        return false;
    }

    public Map<Integer, Quarto> getMapQuartos() {
        return quartos;
    }
}
