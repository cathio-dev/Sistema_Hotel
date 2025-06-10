package Entidades;

import java.util.Map;
import java.util.TreeMap;

public class GerenciadorDeQuartos {

    private Map<Integer, Quarto> quartos;

    public GerenciadorDeQuartos() {
        this.quartos = new TreeMap<>();
    }

    public void valorDaDiaria(){
        for (Quarto q : quartos.values()) {
            System.out.println(q.getValorDiaria());
        }
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
        System.out.println("\n=== QUARTOS CADASTRADOS ===");
        for (Quarto q : quartos.values()) {
            String status;
            if (q.isStatus()) {
                status = "Reservado";
            } else {
                status = "Disponível";
            }
            System.out.printf(
                    "Número: %d | Tipo: %-18s | Preço: R$%.2f | Status: %s\n", q.getNumero(),
                    q.getClass().getSimpleName(), q.getValorDiaria(), status);
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
        if (quarto != null && quarto.isStatus()) {
            return true;
        }
        return false;
    }

    public Map<Integer, Quarto> getMapQuartos() {
        return quartos;
    }
}
